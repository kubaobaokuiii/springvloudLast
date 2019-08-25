package com.springboottest.controller;

import com.springboottest.entity.LoginUser;
import com.springboottest.service.LoginUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/loginUser")
public class LoginUserController {

    @Resource
    private LoginUserService loginUserService;

    //跳转到input页面
    @RequestMapping("/input")
    public String input(){

        return "input";

    }

    /**
     * 保存方法
     */
    @RequestMapping("/save")
    public void save(LoginUser loginUser){

        loginUserService.save(loginUser);

    }

}








