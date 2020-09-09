package com.mapper;

import com.entity.Ticket;
import com.entity.TicketConnect;
import org.apache.ibatis.annotations.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface TicketMapper {

    @Select("select * from tb_ticket where routeNum=#{routeNum}")
    List<Ticket> selectTicketByRouteNum(String routeNum);

    @Select("select * from tb_ticket")
    List<Ticket> findAllTicket();

    @Select("select * from tb_ticket where routeNum=#{routeNum} and time>#{time}")
    List<Ticket> selectTicketByRouteNumAndTime(@Param("routeNum") String routeNum,@Param("time") String time);

    @Select("select * from tb_ticket where flightNumber=#{flightNumber}")
    Ticket selectTicketByNum(String flightNumber);

    @Select("select * from tb_ticket where flightNumber=#{flightNumber}")
    List<Ticket> selectListTicketByNum(String flightNumber);

    @Insert("insert into tb_ticket(flightNumber,routeNum,time,departureStation,arrivalStation,vehicleType,duration,price,mileage)" +
            " values(#{flightNumber},#{routeNum},#{time},#{departureStation},#{arrivalStation},#{vehicleType},#{duration},#{price},#{mileage})")
    void insertTicket(Ticket ticket);

    @Delete("delete from tb_ticket where flightNumber=#{flightNumber}")
    void delTicket(String flightNumber);

    @Delete("delete from tb_ticket where routeNum=#{routeNum}")
    void delTicketByRouteNum(String routeNum);

    @Update("update tb_ticket set time=#{time},departureStation=#{departureStation},arrivalStation=#{arrivalStation},vehicleType=#{vehicleType}," +
            "duration=#{duration},price=#{price},mileage=#{mileage} where flightNumber=#{flightNumber}")
    void updateTicket(@Param("time") String time,@Param("departureStation") String departureStation,@Param("arrivalStation") String arrivalStation, @Param("vehicleType") String vehicleType,
                      @Param("duration") String duration,@Param("price") double price,@Param("mileage") String mileage,@Param("flightNumber") String flightNumber);

    @Select("select tic1.flightNumber,tic1.time,tic1.departureStation,tic1. arrivalStation,tic1.vehicleType,tic1.duration,tic1.price,tic1.mileage,tic2.ticketNumber,tic2.state " +
            "from tb_ticket tic1,tb_ticketnum tic2 where tic2.routeNum = #{routeNum} and tic2.day = #{day} and tic1.flightNumber = tic2.flightNumber and tic1.time>#{time} order by tic1.time")
    List<TicketConnect> findTicketConnectBytime(@Param("routeNum") String routeNum,@Param("day") String day,@Param("time") String time);

    @Select("select tic1.flightNumber,tic1.time,tic1.departureStation,tic1. arrivalStation,tic1.vehicleType,tic1.duration,tic1.price,tic1.mileage,tic2.ticketNumber,tic2.state " +
            "from tb_ticket tic1,tb_ticketnum tic2 where tic2.routeNum = #{routeNum} and tic2.day = #{day} and tic1.flightNumber = tic2.flightNumber order by tic1.time")
    List<TicketConnect> findTicketConnect(@Param("routeNum") String routeNum,@Param("day") String day);
}