package com.service.impl;

import com.entity.TicketNum;
import com.mapper.TicketNumMapper;
import com.service.TicketNumService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ticketNumService")
public class TicketNumServiceImpl implements TicketNumService {

    @Resource
    private TicketNumMapper ticketNumMapper;

    @Override
    public List<TicketNum> selectAll() {
        return ticketNumMapper.selectAll();
    }

    @Override
    public List<TicketNum> selectTicNumByid(String routeNum, String day) {
        return ticketNumMapper.selectTicNumByid(routeNum,day);
    }

    @Override
    public List<TicketNum> selectByFlightNumber(String flightNumber) {
        return ticketNumMapper.selectByFlightNumber(flightNumber);
    }

    @Override
    public List<TicketNum> selectByRouteNum(String routeNum) {
        return ticketNumMapper.selectByRouteNum(routeNum);
    }

    @Override
    public void deleteByFlightNumber(String flightNumber) {
        ticketNumMapper.deleteByFlightNumber(flightNumber);
    }

    @Override
    public void deleteByRouteNum(String routeNum) {
        ticketNumMapper.deleteByRouteNum(routeNum);
    }

    @Override
    public void upTicketNumber(String flightNumber, String day, Integer ticketNumber) {
        ticketNumMapper.upTicketNumber(flightNumber, day, ticketNumber);
    }

    @Override
    public void upTicketNum(String flightNumber, String day, Integer ticketNumber, String state) {
        ticketNumMapper.upTicketNum(flightNumber, day, ticketNumber, state);
    }

    @Override
    public void insertTicketNum1(String flightNumber, String routeNum) {
        ticketNumMapper.insertTicketNum1(flightNumber, routeNum);
    }

    @Override
    public void insertTicketNum2(String flightNumber, String routeNum) {
        ticketNumMapper.insertTicketNum2(flightNumber, routeNum);
    }

    @Override
    public void insertTicketNum3(String flightNumber, String routeNum) {
        ticketNumMapper.insertTicketNum3(flightNumber, routeNum);
    }

    @Override
    public void insertTicketNum4(String flightNumber, String routeNum) {
        ticketNumMapper.insertTicketNum4(flightNumber, routeNum);
    }

    @Override
    public void insertTicketNum5(String flightNumber, String routeNum) {
        ticketNumMapper.insertTicketNum5(flightNumber, routeNum);
    }

    @Override
    public void insertTicketNum6(String flightNumber, String routeNum) {
        ticketNumMapper.insertTicketNum6(flightNumber, routeNum);
    }

    @Override
    public TicketNum selectTicNumByidAndDay(String flightNumber, String day) {
        return ticketNumMapper.selectTicNumByidAndDay(flightNumber, day);
    }
}
