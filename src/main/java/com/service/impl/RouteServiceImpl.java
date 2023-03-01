package com.service.impl;

import com.entity.Route;
import com.mapper.RouteMapper;
import com.service.RouteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("routeService")
public class RouteServiceImpl implements RouteService {

    @Resource
    private RouteMapper routeMapper;

    @Override
    public List<Route> findAllRoute() {
        return routeMapper.findAllRoute();
    }

    @Override
    public List<Route> findRouteById() {
        return routeMapper.findRouteById();
    }

    @Override
    public List<Route> findListRouteByRouteNum(String routeNum) {
        return routeMapper.findListRouteByRouteNum(routeNum);
    }

    @Override
    public Route findRouteByRouteNum(String routeNum) {
        return routeMapper.findRouteByRouteNum(routeNum);
    }

    @Override
    public Route findRouteNum(String departurePlace, String arrivalPlace) {
        return routeMapper.findRouteNum(departurePlace, arrivalPlace);
    }

    @Override
    public void insertRoutr(Route route) {
        routeMapper.insertRoutr(route);
    }

    @Override
    public void delRoute(String routeNum) {
        routeMapper.delRoute(routeNum);
    }

    @Override
    public void updateRoute(String departurePlace,String arrivalPlace,double minPrice,String routeNum){
        routeMapper.updateRoute(departurePlace, arrivalPlace, minPrice, routeNum);
    }

    @Override
    public List<Route> findRouteByNum(String routeNum) {
        return routeMapper.findRouteByNum(routeNum);
    }
}
