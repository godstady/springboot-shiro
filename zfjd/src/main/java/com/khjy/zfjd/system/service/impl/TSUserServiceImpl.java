package com.khjy.zfjd.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.khjy.zfjd.system.bean.TSFunction;
import com.khjy.zfjd.system.bean.TSUser;
import com.khjy.zfjd.system.dao.TSUserDao;
import com.khjy.zfjd.system.service.TSUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by godstady on 2020/6/16.
 */
@Service
public class TSUserServiceImpl implements TSUserService {
    @Autowired
    private TSUserDao dao;

    public List<TSUser> findAll(Page<TSUser> page){
        return dao.findAll(page);
    }
    public TSUser getUser(String id){
        return dao.getUser(id);
    }
    public List<String> getrole(String userno){
        return dao.getrole(userno);
    }

    @Override
    public List<TSFunction> getfun(List<String> rolist) {
        return dao.getfun(rolist);
    }

}
