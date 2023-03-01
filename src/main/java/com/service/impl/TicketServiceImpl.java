package com.service.impl;

import com.entity.Ticket;
import com.entity.TicketConnect;
import com.mapper.TicketMapper;
import com.service.TicketService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ticketService")
public class TicketServiceImpl implements TicketService {

    @Resource
    private TicketMapper ticketMapper;

    @Override
    public List<Ticket> selectTicketByRouteNum(String routeNum) {
        return ticketMapper.selectTicketByRouteNum(routeNum);
    }

    @Override
    public List<Ticket> selectTicketByRouteNumAndTime(String routeNum, String time) {
        return ticketMapper.selectTicketByRouteNumAndTime(routeNum,time);
    }

    @Override
    public List<Ticket> findAllTicket() {
        return ticketMapper.findAllTicket();
    }

    @Override
    public List<Ticket> selectListTicketByNum(String flightNumber) {
        return ticketMapper.selectListTicketByNum(flightNumber);
    }

    @Override
    public void insertTicket(Ticket ticket) {
        ticketMapper.insertTicket(ticket);
    }

    @Override
    public void delTicket(String flightNumber) {
        ticketMapper.delTicket(flightNumber);
    }

    @Override
    public Ticket selectTicketByNum(String flightNumber) {
        return ticketMapper.selectTicketByNum(flightNumber);
    }

    @Override
    public void delTicketByRouteNum(String routeNum) {
        ticketMapper.delTicketByRouteNum(routeNum);
    }

    @Override
    public void updateTicket(String time, String departureStation, String arrivalStation, String vehicleType, String duration, double price, String mileage,String flightNumber) {
        ticketMapper.updateTicket(time, departureStation, arrivalStation, vehicleType, duration, price, mileage,flightNumber);
    }

    @Override
    public List<TicketConnect> findTicketConnectBytime(String routeNum, String day,String time) {
        return ticketMapper.findTicketConnectBytime(routeNum,day,time);
    }

    @Override
    public List<TicketConnect> findTicketConnect(String routeNum, String day) {
        return ticketMapper.findTicketConnect(routeNum,day);
    }
}
