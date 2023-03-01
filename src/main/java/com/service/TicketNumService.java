package com.service;

import com.entity.TicketNum;

import java.util.List;

public interface TicketNumService {

    public List<TicketNum> selectAll();

    public List<TicketNum> selectTicNumByid(String routeNum, String day);

    public List<TicketNum> selectByFlightNumber(String flightNumber);

    public List<TicketNum> selectByRouteNum(String routeNum);

    public void deleteByFlightNumber(String flightNumber);

    public void deleteByRouteNum(String routeNum);

    public void upTicketNumber(String flightNumber,String day,Integer ticketNumber);

    public void upTicketNum(String flightNumber,String day,Integer ticketNumber,String state);

    public void insertTicketNum1(String flightNumber,String routeNum);

    public void insertTicketNum2(String flightNumber,String routeNum);

    public void insertTicketNum3(String flightNumber,String routeNum);

    public void insertTicketNum4(String flightNumber,String routeNum);

    public void insertTicketNum5(String flightNumber,String routeNum);

    public void insertTicketNum6(String flightNumber,String routeNum);

    public  TicketNum selectTicNumByidAndDay(String flightNumber ,String day);

}
