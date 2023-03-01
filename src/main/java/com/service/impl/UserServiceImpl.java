package com.service.impl;

import com.entity.User;
import com.mapper.UserMapper;
import com.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void insertUser(User user) {
       userMapper.insertUser(user);
    }

    @Override
    public User selectUserByEmail(String email) {
        return userMapper.selectUserByEmail(email);
    }

    @Override
    public User selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }

    @Override
    public User selectUserByIdNum(String idnumber) {
        return userMapper.selectUserByIdNum(idnumber);
    }

    @Override
    public void updatePassword(String username, String password) {
        userMapper.updatePassword(username, password);
    }

}
