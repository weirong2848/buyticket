package com.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.entity.*;
import com.service.*;
import com.util.AlipayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("pay")
public class PayController {

    @Autowired
    private BuyUserService buyUserService;
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
    @Autowired
    private UserService userService;

    private String inorderid = null;
    private String outOrderid = null;
    @RequestMapping("getPay")
    @ResponseBody
    public String getPay( String username,String idnumber,String name,String phone,String flightNumber,String data,double money,HttpServletRequest httpRequest)throws Exception{//生成订单并跳转支付页面
        Order order = new Order();
        Ticket ticket = ticketService.selectTicketByNum(flightNumber);
        Date newData  = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String orderTime = df.format(newData);
        TicketNum ticketNum =  ticketNumService.selectTicNumByidAndDay(flightNumber,data);
        String data1 = data;
        data = data+" "+ticket.getTime();
        String orderid = null;
        UUID uuid = UUID.randomUUID();
        orderid = uuid.toString();
        orderid = orderid.replace("-", "");
        int num = orderid.hashCode();
        num = num < 0 ? -num : num;
        orderid = String.valueOf(num);
        int seatNumber = ticketNum.getTicketNumber();
        int seatNumber2 = seatNumber - 1;
        seatNumber = 46 - seatNumber + 1;
        order.setOrderid(orderid);
        inorderid = orderid;
        order.setUsername(username);
        order.setIdnumber(idnumber);
        order.setName(name);
        order.setPhone(phone);
        order.setOrderTime(orderTime);
        order.setFlightNumber(flightNumber);
        order.setTime(data);
        order.setDepartureStation(ticket.getDepartureStation());
        order.setArrivalStation(ticket.getArrivalStation());
        order.setSeatNumber(seatNumber);
        order.setPrice(ticket.getPrice());
        order.setMoney(money);
        order.setState(0);
        orderService.insertOrder(order);
        ticketNumService.upTicketNumber(flightNumber,data1,seatNumber2);
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        try {
            alipayRequest.setBizContent("{\"out_trade_no\":\""+ orderid+"\","
                    + "\"total_amount\":\""+ money +"\","
                    + "\"subject\":\""+ "车票" +"\","
                    + "\"body\":\""+ " " +"\","
                    + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
            //请求
            String result;
            result = alipayClient.pageExecute(alipayRequest).getBody();
            return result;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("inIndex")
    @ResponseBody
    public ModelAndView toIndex(){//进入主页
        int state = 1;
        orderService.updateOrder(inorderid,state);
        List<Notice> list1 = noticeService.findNoticeByDate();
        List<Route> list2 = routeService.findRouteById();
        ModelAndView mv = new ModelAndView();
        mv.addObject("list1",list1);
        mv.addObject("list2",list2);
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("paymoney")
    @ResponseBody
    public String paymoney(String orderid,double money){//跳转支付页面
        inorderid=orderid;
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        try {
            alipayRequest.setBizContent("{\"out_trade_no\":\""+ orderid+"\","
                    + "\"total_amount\":\""+ money +"\","
                    + "\"subject\":\""+ "车票" +"\","
                    + "\"body\":\""+ " " +"\","
                    + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
            //请求
            String result;
            result = alipayClient.pageExecute(alipayRequest).getBody();
            return result;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("refund")
    @ResponseBody
    public void refund(String orderid, double money, HttpServletResponse response, HttpSession session) throws AlipayApiException, IOException {//退款
        outOrderid = orderid;
        Order order = orderService.findOrderByOrderid(orderid);
        String day = order.getTime().substring(0,11);
        TicketNum ticketNum = ticketNumService.selectTicNumByidAndDay(order.getFlightNumber(),day);
        int ticketNumber = ticketNum.getTicketNumber();
        ticketNumber = ticketNumber + 1;
        ticketNumService.upTicketNumber(order.getFlightNumber(),day,ticketNumber);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        money = money*0.85;
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();
        //标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传
        String out_request_no = new String(UUID.randomUUID().toString());

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ orderid +"\","
                + "\"refund_amount\":\""+ money +"\","
                + "\"out_request_no\":\""+ out_request_no +"\"}");
        //请求
        String result = alipayClient.execute(alipayRequest).getBody();
        //输出
        out.println(result);
    }

    @RequestMapping("inUserInfo")
    @ResponseBody
    public ModelAndView inUserInfo(HttpServletRequest request){//进入个人中心
        int state = 2;
        orderService.updateOrder(outOrderid,state);
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

    @RequestMapping("inAlipay")
    @ResponseBody
    public ModelAndView inAlipay(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("alipay");
        return mv;
    }
}
