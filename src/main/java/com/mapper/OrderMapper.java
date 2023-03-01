package com.mapper;

import com.entity.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("select * from tb_order")
    List<Order> findAllOrder();

    @Select("select * from tb_order where username=#{username}")
    List<Order> findOrderByUsername(String username);

    @Select("select * from tb_order where orderid=#{orderid}")
    List<Order> findListOrderByOrderid(String orderid);

    @Select("select * from tb_order where orderid=#{orderid}")
    Order findOrderByOrderid(String orderid);

    @Select("select sum(money) from tb_order where orderTime like concat(#{orderTime},'%') and state=#{state}")
    String countMoney(@Param("orderTime") String orderTime,@Param("state") Integer state);

    @Insert("insert into tb_order(orderid,username,idnumber,name,phone,orderTime,flightNumber,time,departureStation,arrivalStation,seatNumber,price,money,state) " +
            "values(#{orderid},#{username},#{idnumber},#{name},#{phone},#{orderTime},#{flightNumber},#{time},#{departureStation},#{arrivalStation},#{seatNumber},#{price},#{money},#{state})")
    void insertOrder(Order order);

    @Delete("delete from tb_order where orderid=#{orderid}")
    void deleteOrderByOrderid(String orderid);

    @Update("update tb_order set state=#{state} where orderid=#{orderid}")
    void updateOrder(@Param("orderid") String orderid, @Param("state")Integer state);

}
