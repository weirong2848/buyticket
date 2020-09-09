package com.controller;

import com.entity.User;
import com.util.Email;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UserService userService;

    private String username;
    private String password;

    @RequestMapping("getCode")
    @ResponseBody
    public int getCode(String email){//生成验证码并发送验证码
        int code = (int) ((Math.random()*9+1)*1000);
        Email mail = new Email();
        mail.sendEmails(email,code);
        return code;
    }

    @RequestMapping("zhuce")
    @ResponseBody
    public String zhuce(String email, String username, String password, String idnumber, String name, String phone){//注册用户
        User user =  new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        user.setIdnumber(idnumber);
        user.setName(name);
        user.setPhone(phone);
        user.setIntegral(100);
        user.setIsadmin(0);
        userService.insertUser(user);
        return "login";
    }

    @RequestMapping("isIdNumRegister")
    @ResponseBody
    public boolean isIdNumRegister(String idnumber){//判断身份证是否被注册过
        if(userService.selectUserByIdNum(idnumber)==null){
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping("isEmailRegister")
    @ResponseBody
    public boolean isEmailRegister(String email){//判断用户是否存在
        if(userService.selectUserByEmail(email)==null){
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping("isNameRegister")
    @ResponseBody
    public boolean isNameRegister(String username){//判断用户名是否已经使用
        if(userService.selectUserByUsername(username)==null){
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping("dengru")
    @ResponseBody
    public String dengru(String email, String password, HttpServletRequest request ){//登入
        User user = userService.selectUserByEmail(email);
        if(user == null){
            return "0";
        }
        else if(!password.equals(user.getPassword())){
           return "1";
        }
        else {
            if(user.getIsadmin()==1){
                this.username = user.getUsername();
                this.password = password;
                return "11";
            }
            else{
                String username = user.getUsername();
                request.getSession().setAttribute("username",username);
                return "10";
            }
        }
    }

    @RequestMapping("deng")
    @ResponseBody
    public ModelAndView deng(){//跳转到车票信息页
        ModelAndView mv = new ModelAndView();
        mv.setViewName("ticket");
        return mv;
    }

    @RequestMapping("adminUpPassword")
    @ResponseBody
    public String adminUpPassword(String password,String newpassword){//更改密码
        if(this.password.equals(password)){
            System.out.println(1);
            userService.updatePassword(username,newpassword);
            return "redirect:management/inRouteManagement";
        }else {
            System.out.println(2);
            return "0";
        }
    }
}


