package com.pjq.ssm.controller;

import com.pjq.ssm.model.User;
import com.pjq.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUesr", method = RequestMethod.GET)
    public User getUser(Integer id){
        return userService.getUser(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public int save(String name){
        User user = new User();
        user.setName(name);
        return userService.save(user);
    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public List<User> getUserList(){
        return userService.getUserList();
    }

}
