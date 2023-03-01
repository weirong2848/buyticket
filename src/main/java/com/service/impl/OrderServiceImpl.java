package com.service.impl;

import com.entity.Order;
import com.mapper.OrderMapper;
import com.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<Order> findAllOrder() {
        return orderMapper.findAllOrder();
    }

    @Override
    public List<Order> findOrderByUsername(String username) {
        return orderMapper.findOrderByUsername(username);
    }

    @Override
    public List<Order> findListOrderByOrderid(String orderid) {
        return orderMapper.findListOrderByOrderid(orderid);
    }

    @Override
    public Order findOrderByOrderid(String orderid) {
        return orderMapper.findOrderByOrderid(orderid);
    }

    @Override
    public String countMoney(String orderTime,Integer state) {
        return orderMapper.countMoney(orderTime,state);
    }

    @Override
    public void insertOrder(Order order) {
        orderMapper.insertOrder(order);
    }

    @Override
    public void deleteOrderByOrderid(String orderid) {
        orderMapper.deleteOrderByOrderid(orderid);
    }

    @Override
    public void updateOrder(String orderid, Integer state) {
        orderMapper.updateOrder(orderid,state);
    }
}
