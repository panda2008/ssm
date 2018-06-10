package com.pjq.ssm.controller;

import com.pjq.ssm.model.User;
import com.pjq.ssm.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(value="UserController",description="测试接口描述")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUesr", method = RequestMethod.GET)
    @ApiOperation(value = "根据ID获取用户信息", notes  = "get user by id", response = User.class)
    public User getUser(@ApiParam(required = true,value = "用户ID",name = "id") @RequestParam(value = "id") Integer id){
        return userService.findById(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public int save(String name){
        User user = new User();
        user.setName(name);

        List<Object> list = new ArrayList<>();
        list.add("1");
        list.add("3");
        list.add("4");
        return userService.deleteByIds(list);
    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public List<User> getUserList(){
        return userService.findByIds("2,3,4,5,6");
    }

}
