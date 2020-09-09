package com.mapper;

import com.entity.TicketNum;
import org.apache.ibatis.annotations.*;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

@Mapper
public interface TicketNumMapper {

    @Select("select * from tb_ticketnum")
    List<TicketNum> selectAll();

    @Select("select * from tb_ticketnum where flightNumber=#{flightNumber}")
    List<TicketNum> selectByFlightNumber(String flightNumber);

    @Select("select * from tb_ticketnum where routeNum=#{routeNum}")
    List<TicketNum> selectByRouteNum(String routeNum);

    @Select("select * from tb_ticketnum where routeNum=#{routeNum} and day=#{day}")
    List<TicketNum> selectTicNumByid(@Param("routeNum") String routeNum, @Param("day") String day);

    @Select("select * from tb_ticketnum where flightNumber=#{flightNumber} and day=#{day}")
    TicketNum selectTicNumByidAndDay(@Param("flightNumber") String flightNumber , @Param("day") String day);

    @Delete("delete from tb_ticketnum where flightNumber=#{flightNumber}")
    void deleteByFlightNumber(String flightNumber);

    @Delete("delete from tb_ticketnum where routeNum=#{routeNum}")
    void deleteByRouteNum(String routeNum);

    @Update("update tb_ticketnum set ticketNumber=#{ticketNumber} where flightNumber=#{flightNumber} and day=#{day}")
    void upTicketNumber(@Param("flightNumber") String flightNumber,@Param("day") String day,@Param("ticketNumber") Integer ticketNumber);

    @Update("update tb_ticketnum set ticketNumber=#{ticketNumber},state=#{state} where flightNumber=#{flightNumber} and day=#{day}")
    void upTicketNum(@Param("flightNumber") String flightNumber,@Param("day") String day,@Param("ticketNumber") Integer ticketNumber,@Param("state") String state);

    @Insert("insert into tb_ticketnum(flightNumber,routeNum,day,ticketNumber,state) values(#{flightNumber},#{routeNum},date_format(now(), '%Y-%m-%d'),46,'-')")
    void insertTicketNum1(@Param("flightNumber") String flightNumber,@Param("routeNum") String routeNum);

    @Insert("insert into tb_ticketnum(flightNumber,routeNum,day,ticketNumber,state) values(#{flightNumber},#{routeNum},date_add(date_format(now(), '%Y-%m-%d'),interval 1 day),46,'-');")
    void insertTicketNum2(@Param("flightNumber") String flightNumber,@Param("routeNum") String routeNum);

    @Insert("insert into tb_ticketnum(flightNumber,routeNum,day,ticketNumber,state) values(#{flightNumber},#{routeNum},date_add(date_format(now(), '%Y-%m-%d'),interval 2 day),46,'-');")
    void insertTicketNum3(@Param("flightNumber") String flightNumber,@Param("routeNum") String routeNum);

    @Insert("insert into tb_ticketnum(flightNumber,routeNum,day,ticketNumber,state) values(#{flightNumber},#{routeNum},date_add(date_format(now(), '%Y-%m-%d'),interval 3 day),46,'-');")
    void insertTicketNum4(@Param("flightNumber") String flightNumber,@Param("routeNum") String routeNum);

    @Insert("insert into tb_ticketnum(flightNumber,routeNum,day,ticketNumber,state) values(#{flightNumber},#{routeNum},date_add(date_format(now(), '%Y-%m-%d'),interval 4 day),46,'-');")
    void insertTicketNum5(@Param("flightNumber") String flightNumber,@Param("routeNum") String routeNum);

    @Insert("insert into tb_ticketnum(flightNumber,routeNum,day,ticketNumber,state) values(#{flightNumber},#{routeNum},date_add(date_format(now(), '%Y-%m-%d'),interval 5 day),46,'-');")
    void insertTicketNum6(@Param("flightNumber") String flightNumber,@Param("routeNum") String routeNum);

}
