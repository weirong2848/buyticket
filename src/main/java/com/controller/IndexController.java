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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

@Controller
@RequestMapping("index")
public class IndexController {

    @Autowired()
    private NoticeService noticeService;
    @Autowired
    private RouteService routeService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private TicketNumService ticketNumService;
    @Autowired
    private BuyUserService buyUserService;

    private String routeNum = null;
    private String data = null;
    private String flightNumber = null;
    private String title = null;

    @RequestMapping("inIndex")
    @ResponseBody
    public ModelAndView toIndex(){//进入主页
        List<Notice> list1 = noticeService.findNoticeByDate();
        List<Route> list2 = routeService.findRouteById();
        ModelAndView mv = new ModelAndView();
        mv.addObject("list1",list1);
        mv.addObject("list2",list2);
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("getRouteNum")
    @ResponseBody
    public String getRouteNum(String departurePlace, String arrivalPlace, String data) {//获取路线编号
        this.data = data;
        Route route = routeService.findRouteNum(departurePlace, arrivalPlace);
        if(route == null){
            return "0";
        }else{
            this.routeNum = route.getRouteNum();
            return "redirect:selectTicket";
        }
    }

    @RequestMapping("selectTicket")
    @ResponseBody
    public ModelAndView selectTicket(@RequestParam(defaultValue = "1",required = true,value = "pageNo") Integer pageNo) throws ParseException {//查询车票，进入车票页面
        Integer pageSize = 10;
        PageHelper.startPage(pageNo,pageSize);
        ModelAndView mv = new ModelAndView();
        List<TicketConnect> list;
        Route route = routeService.findRouteByRouteNum(routeNum);
        if(routeNum != null && data != null){
            Date newdate = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date seldata = null;
            seldata = simpleDateFormat.parse(data);
            if(seldata.getTime()>newdate.getTime()){
                list = ticketService.findTicketConnect(routeNum,data);
            }else {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String time = sdf.format(new Date());
                list = ticketService.findTicketConnectBytime(routeNum,data,time);
            }
            PageInfo<TicketConnect> pageInfo = new PageInfo<TicketConnect>(list);
            mv.addObject("route",route);
            mv.addObject("data",data);
            mv.addObject("pageInfo",pageInfo);
            mv.setViewName("ticket");
        }
        return mv;
    }

    @RequestMapping("getReady")
    @ResponseBody
    public String getReady(String flightNumber,String data){//获取班次号，出发日期
        this.flightNumber = flightNumber;
        this.data = data;
        return "redirect:getReadyPay";
    }

    @RequestMapping("getReadyPay")
    @ResponseBody
    public ModelAndView getReadyPay(HttpServletRequest request){//进入支付信息页面
        HttpSession session   =  request.getSession();
        Enumeration<String> attrs = session.getAttributeNames();
        Object name = null;
        while(attrs.hasMoreElements()){
            String vakue = attrs.nextElement().toString();
            name = session.getAttribute(vakue);
        }
        String username = (String)name;
        ModelAndView mv = new ModelAndView();
        Ticket ticket = ticketService.selectTicketByNum(flightNumber);
        List<BuyUser> list = buyUserService.findBuyUserByUsername(username);
        mv.addObject("ticket",ticket);
        mv.addObject("data",data);
        mv.addObject("list",list);
        mv.setViewName("payMessage");
        return mv;
    }

    @RequestMapping("inProblem")
    @ResponseBody
    public ModelAndView inProblem(){//进入问题页面
        ModelAndView mv  = new ModelAndView();
        mv.setViewName("problem");
        return mv;
    }

    @RequestMapping("inMoreNotice")
    @ResponseBody
    public ModelAndView inMoreNotice(@RequestParam(defaultValue = "1",required = true,value = "pageNo") Integer pageNo){//进入公告列表页
        Integer pageSize = 9;
        PageHelper.startPage(pageNo,pageSize);
        ModelAndView mv = new ModelAndView();
        List<Notice> list = noticeService.findAllNotice();
        PageInfo<Notice> pageInfo = new PageInfo<Notice>(list);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("moreNotice");
        return mv;
    }

    @RequestMapping("getTitle")
    @ResponseBody
    public String getTitle(String title){//获取公告的标题
        this.title = title;
        return "redirect:InNotice";
    }

    @RequestMapping("inNotice")
    @ResponseBody
    public ModelAndView inNotice(){//进入公告详情页
        ModelAndView mv  = new ModelAndView();
        Notice notice = noticeService.findNoticeByTitle(title);
        mv.addObject("notice",notice);
        mv.setViewName("notice");
        return mv;
    }

    @RequestMapping("inLogin")
    @ResponseBody
    public  ModelAndView inLogin(){//进入登录页
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping("inRegister")
    @ResponseBody
    public ModelAndView inRegister(){//进入注册页
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register");
        return mv;
    }

    @RequestMapping("inLogin1")
    @ResponseBody
    public ModelAndView inLogin1(){//进入登录页
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login1");
        return mv;
    }

}


