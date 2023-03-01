package com.service;

import com.entity.BuyUser;

import java.util.List;

public interface BuyUserService {

    public List<BuyUser> findBuyUserByUsername(String username);

    public void insertBuyUser(BuyUser buyUser);

    public void updateBuyUser(String idnumber,String name,String phone,String username);

    public void deleteBuyUser(String idnumber,String username);

    public  BuyUser findBuyUserByUsernameAndIdnumber(String idnumber,String username);
}
