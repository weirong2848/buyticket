package com.service;

import com.entity.User;

public interface UserService {

    public void insertUser(User user);

    public User selectUserByEmail(String email);

    public User selectUserByUsername(String username);

    public User selectUserByIdNum(String idnumber);

    public void updatePassword(String username,String password);
}
