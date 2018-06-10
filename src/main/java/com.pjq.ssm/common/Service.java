package com.pjq.ssm.common;

import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

public interface Service<T> {
    //持久化
    int save(T model);

    //批量持久化
    int save(List<T> models);

    //通过主鍵刪除
    int deleteById(Integer id);

    //批量刪除 eg：list<id>
    int deleteByIds(List<Object> list);

    //更新
    int updateByPrimaryKeySelective(T model);

    //通过ID查找
    T findById(Integer id);

    //通过某个成员属性查找,value需符合unique约束
    T findBy(String property, Object value) throws TooManyResultsException;

    //通过多个ID查找//eg：ids -> “1,2,3,4”
    List<T> findByIds(String ids);

    //根据条件查找
    List<T> findByCondition(Condition condition);

    //获取所有
    List<T> findAll();
}
