package com.service;

import com.entity.Ticket;
import com.entity.TicketConnect;

import java.util.List;

public interface TicketService {

    public List<Ticket> selectTicketByRouteNum(String routeNum);

    public List<Ticket> selectTicketByRouteNumAndTime(String routeNum,String time);

    public List<Ticket> findAllTicket();

    public  List<Ticket> selectListTicketByNum(String flightNumber);

    public void insertTicket(Ticket ticket);

    public void delTicket(String flightNumber);

    public Ticket selectTicketByNum(String flightNumber);

    public void delTicketByRouteNum(String routeNum);

    public void updateTicket(String time,String departureStation,String arrivalStation, String vehicleType,String duration,double price,String mileage,String flightNumber);

    public List<TicketConnect> findTicketConnectBytime(String routeNum,String day,String time);

    List<TicketConnect> findTicketConnect(String routeNum,String day);
}
