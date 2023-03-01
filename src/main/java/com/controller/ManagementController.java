package com.controller;

import com.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("management")
public class ManagementController {

    @Autowired()
    private NoticeService noticeService;
    @Autowired
    private RouteService routeService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private TicketNumService ticketNumService;
    @Autowired
    private OrderService orderService;

    private String flightNumber;
    private String routeNum;
    private String orderid;
    private Integer id;

    @RequestMapping("inManagement")
    @ResponseBody
    public ModelAndView inManagement() {//进入管理页面（echarts图形页面）
        ModelAndView mv = new ModelAndView();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        String nowDay = sf.format(calendar.getTime());
        List list1 = new ArrayList();
        List list2 = new ArrayList();
        String str = " ";
        for (int i = -4; i < 1; i++) {
            String time = changeDay(i).substring(0, 10);
            String money = changeDay(i).substring(10);
            list1.add(time);
            list2.add(money);
        }
        mv.addObject("list1", list1);
        mv.addObject("list2", list2);
        mv.setViewName("management");
        return mv;
    }

    public String changeDay(int num) {//查询不同天的订单总额
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, num);
        String orderTime = sf.format(calendar.getTime());
        int state = 1;
        String money = orderService.countMoney(orderTime, state);
        if (money == null) {
            return orderTime + 0;
        }
        return orderTime + money;
    }

    @RequestMapping("inOrderManagement")
    @ResponseBody
    public ModelAndView inOrderManagement(@RequestParam(defaultValue = "1", required = true, value = "pageNo") Integer pageNo) {//进入管理页面
        Integer pageSize = 10;
        ModelAndView mv = new ModelAndView();
        PageHelper.startPage(pageNo, pageSize);
        List<Order> list = orderService.findAllOrder();
        PageInfo<Order> pageInfo = new PageInfo<Order>(list);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orderManagement");
        return mv;
    }

    @RequestMapping("inRouteManagement")
    @ResponseBody
    public ModelAndView inRouteManagemrnt(@RequestParam(defaultValue = "1", required = true, value = "pageNo") Integer pageNo) {//进入路线管理页面
        Integer pageSize = 10;
        ModelAndView mv = new ModelAndView();
        PageHelper.startPage(pageNo, pageSize);
        List<Route> list = routeService.findAllRoute();
        PageInfo<Route> pageInfo = new PageInfo<Route>(list);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("routeManagement");
        return mv;
    }

    @RequestMapping("insertRoute")
    @ResponseBody
    public String insertRoute(String routeNum, String departurePlace, String arrivalPlace, double minPrice) {//插入路线
        if (routeService.findRouteByRouteNum(routeNum) == null) {
            Route route = new Route();
            route.setRouteNum(routeNum);
            route.setDeparturePlace(departurePlace);
            route.setArrivalPlace(arrivalPlace);
            route.setMinPrice(minPrice);
            routeService.insertRoutr(route);
            return "redirect:inRouteManagement";
        } else {
            return "1";
        }
    }

    @RequestMapping("updateRoute")
    @ResponseBody
    public String updateRoute(String departurePlace, String arrivalPlace, double minPrice, String getrouteNum) {//更新路线
        routeService.updateRoute(departurePlace, arrivalPlace, minPrice, getrouteNum);
        return "redirect:inRouteManagement";
    }

    @RequestMapping("delRoute")
    @ResponseBody
    public String delRoute(String routeNum) {//删除路线
        routeService.delRoute(routeNum);
        if (ticketService.selectTicketByRouteNum(routeNum) != null) {
            ticketService.delTicketByRouteNum(routeNum);
        }
        if (ticketNumService.selectByRouteNum(routeNum) != null) {
            ticketNumService.deleteByRouteNum(routeNum);
        }
        return "redirect:inRouteManagement";
    }

    @RequestMapping("selRoute")
    @ResponseBody
    public Route selRoute(String getrouteNum) {//查询路线
        Route route = routeService.findRouteByRouteNum(getrouteNum);
        return route;
    }

    @RequestMapping("inTicketManagement")
    @ResponseBody
    public ModelAndView inTicketManagement(@RequestParam(defaultValue = "1", required = true, value = "pageNo") Integer pageNo) {//进入车票管理页面
        Integer pageSize = 10;
        ModelAndView mv = new ModelAndView();
        PageHelper.startPage(pageNo, pageSize);
        List<Ticket> list = ticketService.findAllTicket();
        PageInfo<Ticket> pageInfo = new PageInfo<Ticket>(list);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("ticketManagement");
        return mv;
    }

    @RequestMapping("insertTicket")
    @ResponseBody
    public String insertTicket(String flightNumber, String routeNum, String time, String departureStation, String arrivalStation,
                               String vehicleType, String duration, double price, String mileage) throws ParseException {//插入车票
        if (ticketService.selectTicketByNum(flightNumber) == null) {
            Ticket ticket = new Ticket();
            ticket.setFlightNumber(flightNumber);
            ticket.setRouteNum(routeNum);
            ticket.setTime(time);
            ticket.setDepartureStation(departureStation);
            ticket.setArrivalStation(arrivalStation);
            ticket.setVehicleType(vehicleType);
            ticket.setDuration(duration);
            ticket.setPrice(price);
            ticket.setMileage(mileage);
            ticketService.insertTicket(ticket);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            String updateTime = "22:30:00";
            Date upTime = simpleDateFormat.parse(updateTime);
            Date newTime = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
            if (newTime.getTime() > upTime.getTime()) {
                ticketNumService.insertTicketNum6(flightNumber, routeNum);
            } else {
                ticketNumService.insertTicketNum1(flightNumber, routeNum);
            }
            ticketNumService.insertTicketNum2(flightNumber, routeNum);
            ticketNumService.insertTicketNum3(flightNumber, routeNum);
            ticketNumService.insertTicketNum4(flightNumber, routeNum);
            ticketNumService.insertTicketNum5(flightNumber, routeNum);
            return "redirect:inTicketManagement";
        } else {
            return "1";
        }
    }

    @RequestMapping("delticket")
    @ResponseBody
    public String delticket(String flightNumber) {//删除车票
        ticketService.delTicket(flightNumber);
        if (ticketNumService.selectByFlightNumber(flightNumber) != null) {
            ticketNumService.deleteByFlightNumber(flightNumber);
        }
        return "redirect:inTicketManagement";
    }

    @RequestMapping("updateTicket")
    @ResponseBody
    public String updateTicket(String getflightNumber, String time, String departureStation, String arrivalStation,
                               String vehicleType, String duration, double price, String mileage) {//更新车票信息
        ticketService.updateTicket(time, departureStation, arrivalStation, vehicleType, duration, price, mileage, getflightNumber);
        return "redirect:inTicketManagement";
    }

    @RequestMapping("selTicket")
    @ResponseBody
    public Ticket selTicket(String getflightNumber) {//查询车票信息
        Ticket ticket = ticketService.selectTicketByNum(getflightNumber);
        return ticket;
    }

    @RequestMapping("selTicketNum")
    @ResponseBody
    public TicketNum selTicketNum(String flightNumber, String day) {//查询车票数量和状态
        TicketNum ticketNum = ticketNumService.selectTicNumByidAndDay(flightNumber, day);
        return ticketNum;
    }

    @RequestMapping("upTicketNum")
    @ResponseBody
    public String upTicketNum(String flightNumber, String day, Integer ticketNumber, String state) {//更新车票的状态和车票数量
        ticketNumService.upTicketNum(flightNumber, day, ticketNumber, state);
        return "redirect:inTicketManagement";
    }

    @RequestMapping("inNoticeManagement")
    @ResponseBody
    public ModelAndView inNoticeManagement(@RequestParam(defaultValue = "1", required = true, value = "pageNo") Integer pageNo) {//进入公告管理页面
        Integer pageSize = 10;
        ModelAndView mv = new ModelAndView();
        PageHelper.startPage(pageNo, pageSize);
        List<Notice> list = noticeService.findAllNotice();
        PageInfo<Notice> pageInfo = new PageInfo<Notice>(list);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("noticeManagement");
        return mv;
    }

    @RequestMapping("delNotice")
    @ResponseBody
    public String delNotice(Integer id) {//删除公告
        noticeService.delNotice(id);
        return "redirect:inNoticeManagement";
    }

    @RequestMapping("insertNotice")
    @ResponseBody
    public String insertNotice(String title, String date, String content) {//插入公告
        noticeService.insertNotice(title, date, content);
        return "redirect:inNoticeManagement";
    }

    @RequestMapping("updNotice")
    @ResponseBody
    public String updNotice(String title, String date, String content, Integer id) {//更新公告
        noticeService.updNotice(title, date, content, id);
        return "redirect:inNoticeManagement";
    }

    @RequestMapping("selNoticeByid")
    @ResponseBody
    public Notice selNoticeByid(Integer id) {//根据编号查询公告
        Notice notice = noticeService.findNoticeByid(id);
        return notice;
    }

    @RequestMapping("selOneTicket")
    @ResponseBody
    public String selOneTicket(String flightNumber) {//判断要查询的车票是否存在
        this.flightNumber = flightNumber;
        Ticket ticket = ticketService.selectTicketByNum(flightNumber);
        if(ticket == null){
            return "1";
        }else{
            return "redirect:inOneTicketManagement";
        }
    }

    @RequestMapping("inOneTicketManagement")
    @ResponseBody
    public ModelAndView inOneTicketManagement(@RequestParam(defaultValue = "1", required = true, value = "pageNo") Integer pageNo) {//查询指定车票
        Integer pageSize = 2;
        ModelAndView mv = new ModelAndView();
        PageHelper.startPage(pageNo, pageSize);
        List<Ticket> list = ticketService.selectListTicketByNum(flightNumber);
        PageInfo<Ticket> pageInfo = new PageInfo<Ticket>(list);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("ticketManagement");
        return mv;
    }

    @RequestMapping("selOneRoute")
    @ResponseBody
    public String selOneroute(String routeNum) {//判断要查询的路线是否存在
        this.routeNum = routeNum;
        Route route = routeService.findRouteByRouteNum(routeNum);
        if(route == null){
            return "1";
        }else{
            return "redirect:inOneRouteManagemrnt";
        }
    }

    @RequestMapping("inOneRouteManagemrnt")
    @ResponseBody
    public ModelAndView inOneRouteManagemrnt(@RequestParam(defaultValue = "1", required = true, value = "pageNo") Integer pageNo) {//查询指定的路线
        Integer pageSize = 2;
        ModelAndView mv = new ModelAndView();
        PageHelper.startPage(pageNo, pageSize);
        List<Route> list = routeService.findListRouteByRouteNum(routeNum);
        PageInfo<Route> pageInfo = new PageInfo<Route>(list);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("routeManagement");
        return mv;
    }

    @RequestMapping("selOneOrder")
    @ResponseBody
    public String selOneOrder(String orderid) {//判断要查询的订单是否存在
        this.orderid = orderid;
        Order order = orderService.findOrderByOrderid(orderid);
        if(order == null){
            return "1";
        }else{
            return "redirect:inOneOrderManagement";
        }
    }

    @RequestMapping("inOneOrderManagement")
    @ResponseBody
    public ModelAndView inOneOrderManagement(@RequestParam(defaultValue = "1", required = true, value = "pageNo") Integer pageNo) {//查询指定的订单
        Integer pageSize = 2;
        ModelAndView mv = new ModelAndView();
        PageHelper.startPage(pageNo, pageSize);
        List<Order> list = orderService.findListOrderByOrderid(orderid);
        PageInfo<Order> pageInfo = new PageInfo<Order>(list);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orderManagement");
        return mv;
    }

    @RequestMapping("selOneNotice")
    @ResponseBody
    public String selOneNotice(Integer id) {//判断要查询的公告是否存在
        this.id = id;
        Notice notice = noticeService.findNoticeByid(id);
        if(notice == null){
            return "1";
        }else{
            return "redirect:inOneNoticeManagement";
        }
    }

    @RequestMapping("inOneNoticeManagement")
    @ResponseBody
    public ModelAndView inOneNoticeManagement(@RequestParam(defaultValue = "1", required = true, value = "pageNo") Integer pageNo) {//查询指定公告
        Integer pageSize = 2;
        ModelAndView mv = new ModelAndView();
        PageHelper.startPage(pageNo, pageSize);
        List<Notice> list = noticeService.findListNoticeByid(id);
        PageInfo<Notice> pageInfo = new PageInfo<Notice>(list);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("noticeManagement");
        return mv;
    }

    @RequestMapping("inAdmainManagement")
    @ResponseBody
    public ModelAndView inAdmainManagement(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admainManagement");
        return mv;
    }

    @RequestMapping("selectAllRoute")
    @ResponseBody
    public List<Route> selectAllRoute(){//vue测试接口
        List<Route> list = routeService.findAllRoute();
        return list;
    }
}
