package com.springboottest.service.impl;

import com.springboottest.entity.LoginUser;
import com.springboottest.mapper.LoginUserMapper;
import com.springboottest.service.LoginUserService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class LoginUserServiceImpl implements LoginUserService {

    //注入mapper接口对象
    @Resource
    private LoginUserMapper loginUserMapper;

    @Override
    public void save(LoginUser loginUser){


        loginUserMapper.save(loginUser);

    }

}
