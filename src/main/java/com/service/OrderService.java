package com.service;

import com.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderService {

    public List<Order> findAllOrder();

    public List<Order> findOrderByUsername(String username);

    public List<Order> findListOrderByOrderid(String orderid);

    public Order findOrderByOrderid(String orderid);

    public String countMoney(String orderTime,Integer state);

    public void insertOrder(Order order);

    public void deleteOrderByOrderid(String orderid);

    public void updateOrder(String orderid,Integer state);
}
