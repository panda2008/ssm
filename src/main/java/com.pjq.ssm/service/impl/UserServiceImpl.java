package com.pjq.ssm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pjq.ssm.dao.UserDao;
import com.pjq.ssm.model.User;
import com.pjq.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getUser(Integer id){
        return userDao.getUser(id);
    }

    public int save(User user){
        return userDao.save(user);
    }

    @Override
    public List<User> getUserList() {
        Page<Object> page = PageHelper.startPage(1, 2);
        List<User> userList = userDao.getUserList();
        return userList;
    }
}
