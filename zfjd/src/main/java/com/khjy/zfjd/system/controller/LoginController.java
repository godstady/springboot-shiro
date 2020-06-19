package com.khjy.zfjd.system.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.khjy.zfjd.system.bean.TSFunction;
import com.khjy.zfjd.system.bean.TSLog;
import com.khjy.zfjd.system.bean.TSUser;
import com.khjy.zfjd.system.service.impl.TSLogServiceImpl;
import com.khjy.zfjd.system.service.impl.TSUserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by godstady on 2020/6/17.
 */
@Controller
public class LoginController {
    
    @Autowired
    private TSUserServiceImpl service;
    @Autowired
    private TSLogServiceImpl logservice;
    
    @GetMapping("/login")
    public String login(){

        return "login2";
    }


    @PostMapping("/login")
    public String login(String username, HttpServletRequest requset , String password, ModelMap mode){

        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject currentUser = SecurityUtils.getSubject();

        try {
            //主体提交登录请求到SecurityManager
            currentUser.login(token);
        }catch (IncorrectCredentialsException ice){
            System.out.println("密码不正确");
            mode.addAttribute("msg","密码不正确");
        }catch(UnknownAccountException uae){
            System.out.println("账号不存在");
            mode.addAttribute("msg","账号不存在");
        }
        if(currentUser.isAuthenticated()){
            System.out.println("认证成功");
            TSUser user = service.getUser(username);
            requset.getSession().setAttribute("user",user);
            List<String> roleList = service.getrole(user.getUserno());
            List<TSFunction> funlist = service.getfun(roleList);
            //funlist.stream().filter()
            List<Map> list = new ArrayList<>();
            //BeanMap beanMap = BeanMap.create(funlist.get(0));
            funlist.stream().forEach(bean->{
                Map <String,Object> map = new HashMap<>();
                map.put("id",bean.getId());
                map.put("url",bean.getFunctionurl());
                map.put("parent",bean.getParentfunctionid());
                map.put("name",bean.getFunctionname());
                list.add(map);
            });
            ObjectMapper mapper = new ObjectMapper();
            try {
               String strjson =  mapper.writeValueAsString(list);
                mode.addAttribute("strjson",strjson);
                mode.addAttribute("list",list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            TSLog log = new TSLog();
            log.setOperator(user.getUsername());
            log.setOptime(new Date());
            log.setOptlx(user.getUserno());
            log.setOptype("登录");
            log.setUrl("/login");
            logservice.insert(log);
            mode.addAttribute("funlist",funlist);


            mode.addAttribute("user",user);
            return "bazx";
        }else{
            token.clear();
            return "login2";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){

        TSUser user  = (TSUser)request.getSession().getAttribute("user");
        TSLog log = new TSLog();
        log.setOperator(user.getUsername());
        log.setOptime(new Date());
        log.setOptlx(user.getUserno());
        log.setOptype("退出");
        log.setUrl("/logout");
        logservice.insert(log);

        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login2";
    }
}
