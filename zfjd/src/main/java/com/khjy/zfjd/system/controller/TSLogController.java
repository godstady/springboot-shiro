package com.khjy.zfjd.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.khjy.zfjd.config.R;
import com.khjy.zfjd.model.BazxBaqryxx;
import com.khjy.zfjd.system.bean.TSFunction;
import com.khjy.zfjd.system.bean.TSLog;
import com.khjy.zfjd.system.bean.TSUser;
import com.khjy.zfjd.system.service.impl.TSLogServiceImpl;
import com.khjy.zfjd.system.service.impl.TSUserServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by godstady on 2020/6/17.
 */
@Controller
public class TSLogController {
    

    @Autowired
    private TSLogServiceImpl logservice;
    
    @GetMapping("/tslog")
    public String login(){
        return "system/tslog";
    }

    @RequestMapping("/gettslog")
    @ApiOperation("返回已经回传过去的数据")
    @ResponseBody
    public R gettslog(@RequestParam(required = false) Integer page,
                      @RequestParam(required = false) Integer limit,
                      @RequestParam(required = false) String kssj,
                      @RequestParam(required = false) String jssj){
        Page<TSLog> data = logservice.findAll(kssj,jssj,page,limit);

        return R.success(0,"成功！",data.getTotal(),data.getRecords());
    }

}
