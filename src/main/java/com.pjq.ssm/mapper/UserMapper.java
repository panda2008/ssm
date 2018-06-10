package com.pjq.ssm.mapper;

import com.pjq.ssm.common.BaseMapper;
import com.pjq.ssm.model.User;

public interface UserMapper extends BaseMapper<User> {

    public User getUser(Integer id);
}
