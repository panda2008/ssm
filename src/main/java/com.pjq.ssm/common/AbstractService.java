package com.pjq.ssm.common;


import com.pjq.ssm.model.User;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

public abstract class AbstractService<T> implements Service<T> {

    @Autowired
    protected BaseMapper<T> dao;

    private Class<T> modelClass;    // 当前泛型真实类型的Class

    public AbstractService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public int save(T model) {
        return dao.insertSelective(model);
    }

    @Override
    public int save(List<T> models) {
        return dao.insertList(models);
    }

    @Override
    public int deleteById(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByIds(List<Object> list) {
        Example example = new Example(User.class);
        example.createCriteria().andIn("id", list);
        return dao.deleteByExample(example);
    }

    @Override
    public int updateByPrimaryKeySelective(T model) {
        return dao.updateByPrimaryKeySelective(model);
    }

    @Override
    public T findById(Integer id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public T findBy(String property, Object value) throws TooManyResultsException {
        try {
            T model = modelClass.newInstance();
            Field field = modelClass.getDeclaredField(property);
            field.setAccessible(true);
            field.set(model, value);
            return dao.selectOne(model);
        } catch (ReflectiveOperationException e) {
            //throw new ServiceException(e.getMessage(), e); 最好使用一个自定义异常
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public List<T> findByIds(String ids) {
        return dao.selectByIds(ids);
    }

    @Override
    public List<T> findByCondition(Condition condition) {
        return dao.selectByCondition(condition);
    }

    @Override
    public List<T> findAll() {
        return dao.selectAll();
    }
}
