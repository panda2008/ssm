package com.pjq.ssm.service;

import com.pjq.ssm.model.User;

import java.util.List;


public interface UserService {

    public User getUser(Integer id);

    public int save(User user);

    List<User> getUserList();
}
