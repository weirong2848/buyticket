package com.controller;

import com.entity.BuyUser;
import com.entity.Order;
import com.entity.TicketNum;
import com.entity.User;
import com.service.BuyUserService;
import com.service.OrderService;
import com.service.TicketNumService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BuyUserService buyUserService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private TicketNumService ticketNumService;

    @RequestMapping("insertBuyUser")
    @ResponseBody
    public String insertBuyUser(BuyUser buyUser){//添加乘车人
        buyUserService.insertBuyUser(buyUser);
        return"redirect:../index/getReadyPay";
    }

    @RequestMapping("istBuyUser")
    @ResponseBody
    public String isBuyUser(String idnumber,String username){//判断乘车人是否已经添加
        BuyUser buyUser = buyUserService.findBuyUserByUsernameAndIdnumber(idnumber,username);
        if (buyUser == null){
            return"0";
        }else {
            return "1";
        }
    }

    @RequestMapping("inUserInfo")
    @ResponseBody
    public ModelAndView inUserInfo(HttpServletRequest request){//跳转到个人中心页面
        ModelAndView mv =  new ModelAndView();
        HttpSession session   =  request.getSession();
        Enumeration<String> attrs = session.getAttributeNames();
        Object name = null;
        while(attrs.hasMoreElements()){
            String vakue = attrs.nextElement().toString();
            name = session.getAttribute(vakue);
        }
        String username = (String)name;
        User user = userService.selectUserByUsername(username);
        List<Order> list = orderService.findOrderByUsername(username);
        List<BuyUser> list1 =  buyUserService.findBuyUserByUsername(username);
        mv.addObject("user",user);
        mv.addObject("list",list);
        mv.addObject("list1",list1);
        mv.setViewName("userInfo");
        return mv;
    }

    @RequestMapping("delOrder")
    @ResponseBody
    public String delOrder(String orderid) throws ParseException {//删除订单
        Order order = orderService.findOrderByOrderid(orderid);
        int state = order.getState();
        String time = order.getTime()+":00";
        Date newdate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date seldata = null;
        seldata = simpleDateFormat.parse(time);
        if (state ==0){
            if(newdate.getTime()>seldata.getTime()){
                orderService.deleteOrderByOrderid(orderid);
                return "redirect:inUserInfo";
            }else {
                String day = order.getTime().substring(0,11);
                TicketNum ticketNum = ticketNumService.selectTicNumByidAndDay(order.getFlightNumber(),day);
                int ticketNumber = ticketNum.getTicketNumber();
                ticketNumber = ticketNumber + 1;
                ticketNumService.upTicketNumber(order.getFlightNumber(),day,ticketNumber);
                orderService.deleteOrderByOrderid(orderid);
                return "redirect:inUserInfo";
            }
        }else {
            orderService.deleteOrderByOrderid(orderid);
            return "redirect:inUserInfo";
        }

    }

    @RequestMapping("updatePassword")
    @ResponseBody
    public String updatePassword(HttpServletRequest request,String password){//更改密码
        HttpSession session   =  request.getSession();
        Enumeration<String> attrs = session.getAttributeNames();
        Object name = null;
        while(attrs.hasMoreElements()){
            String vakue = attrs.nextElement().toString();
            name = session.getAttribute(vakue);
        }
        String username = (String)name;
        userService.updatePassword(username,password);
        return "redirect:inUserInfo";
    }

    @RequestMapping("delBuyUser")
    @ResponseBody
    public String delBuyUser(HttpServletRequest request,String idnumber){//删除乘车人
        HttpSession session   =  request.getSession();
        Enumeration<String> attrs = session.getAttributeNames();
        Object name = null;
        while(attrs.hasMoreElements()){
            String vakue = attrs.nextElement().toString();
            name = session.getAttribute(vakue);
        }
        String username = (String)name;
        buyUserService.deleteBuyUser(idnumber,username);
        return "redirect:inUserInfo";
    }

}
