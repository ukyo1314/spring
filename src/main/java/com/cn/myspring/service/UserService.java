package com.cn.myspring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.myspring.mapper.UserMapper;
import com.cn.myspring.po.User;

@Service("userService")
public class UserService {

    @Autowired  
    private UserMapper userMapper;  
	
	public void insertUser(User user) throws Exception{
        userMapper.insert(user);
	}
	
}
