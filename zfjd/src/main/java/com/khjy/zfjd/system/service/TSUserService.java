package com.khjy.zfjd.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.khjy.zfjd.system.bean.TSFunction;
import com.khjy.zfjd.system.bean.TSUser;

import java.util.List;

/**
 * Created by godstady on 2020/6/16.
 */

public interface TSUserService {
    public List<TSUser> findAll(Page<TSUser> page);
    public TSUser getUser(String id);
    public List<String> getrole(String userno);
    public List<TSFunction> getfun(List<String> rolist);
}
