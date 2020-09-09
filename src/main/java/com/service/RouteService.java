package com.service;

import com.entity.Route;

import java.util.List;

public interface RouteService {

    public List<Route> findAllRoute();

    public List<Route> findRouteById();

    public List<Route> findListRouteByRouteNum(String routeNum);

    public Route findRouteByRouteNum(String routeNum);

    public Route findRouteNum(String departurePlace,String arrivalPlace);

    public void insertRoutr(Route route);

    public void delRoute(String routeNum);

    public void updateRoute(String departurePlace,String arrivalPlace,double minPrice,String routeNum);

    public List<Route> findRouteByNum(String routeNum);
}
