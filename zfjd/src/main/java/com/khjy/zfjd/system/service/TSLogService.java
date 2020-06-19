package com.khjy.zfjd.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.khjy.zfjd.system.bean.TSFunction;
import com.khjy.zfjd.system.bean.TSLog;
import com.khjy.zfjd.system.bean.TSUser;

import java.util.List;

/**
 * Created by godstady on 2020/6/16.
 */

public interface TSLogService {
    public Page<TSLog> findAll(String kssj , String jssj,Integer pageNo, Integer pagesize);
    public void insert(TSLog tSLog);

}
