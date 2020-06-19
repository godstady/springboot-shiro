package com.khjy.zfjd.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.khjy.zfjd.model.BazxBaqryxx;
import com.khjy.zfjd.system.bean.TSFunction;
import com.khjy.zfjd.system.bean.TSLog;
import com.khjy.zfjd.system.bean.TSUser;
import com.khjy.zfjd.system.dao.TSLogDao;
import com.khjy.zfjd.system.dao.TSUserDao;
import com.khjy.zfjd.system.service.TSLogService;
import com.khjy.zfjd.system.service.TSUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by godstady on 2020/6/16.
 */
@Service
public class TSLogServiceImpl implements TSLogService {
    @Autowired
    private TSLogDao dao;

    @Override
    public Page<TSLog> findAll(String kssj,String jssj,Integer pageNo,Integer pagesize) {
        Page<TSLog> page = new Page<>(pageNo,pagesize);
        page.setRecords(dao.findAll(kssj,jssj,page));
        return page;
    }

    @Override
    public void insert(TSLog tSLog) {

        dao.insert(tSLog);
    }
}
