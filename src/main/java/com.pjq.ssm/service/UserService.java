package com.pjq.ssm.service;

import com.pjq.ssm.common.Service;
import com.pjq.ssm.model.User;

public interface UserService extends Service<User> {

    User getUser(Integer id);
}
