package com.service.impl;

import com.entity.BuyUser;
import com.mapper.BuyUserMapper;
import com.service.BuyUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("buyUserService")
public class BuyUserServiceImpl implements BuyUserService {

    @Resource
    private BuyUserMapper buyUserMapper;

    @Override
    public List<BuyUser> findBuyUserByUsername(String username) {
        return buyUserMapper.findBuyUserByUsername(username);
    }

    @Override
    public void insertBuyUser(BuyUser buyUser) {
        buyUserMapper.insertBuyUser(buyUser);
    }

    @Override
    public void updateBuyUser(String idnumber, String name, String phone, String username) {
        buyUserMapper.updateBuyUser(idnumber, name, phone, username);
    }

    @Override
    public void deleteBuyUser(String idnumber, String username) {
        buyUserMapper.deleteBuyUser(idnumber, username);
    }

    @Override
    public BuyUser findBuyUserByUsernameAndIdnumber(String idnumber,String username) {
        return buyUserMapper.findBuyUserByUsernameAndIdnumber(idnumber,username);
    }
}
