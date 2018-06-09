package com.pjq.ssm.dao;

import com.pjq.ssm.model.User;

import java.util.List;

public interface UserDao {

    User getUser(Integer id);

    int save(User user);

    List<User> getUserList();
}
