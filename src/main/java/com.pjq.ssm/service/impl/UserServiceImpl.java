package com.pjq.ssm.service.impl;

import com.pjq.ssm.common.BaseService;
import com.pjq.ssm.mapper.UserMapper;
import com.pjq.ssm.model.User;
import com.pjq.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl extends BaseService<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(Integer id) {
        return userMapper.getUser(id);
    }
}
