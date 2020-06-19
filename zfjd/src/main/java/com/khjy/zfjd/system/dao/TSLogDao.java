package com.khjy.zfjd.system.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.khjy.zfjd.system.bean.TSFunction;
import com.khjy.zfjd.system.bean.TSLog;
import com.khjy.zfjd.system.bean.TSUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by godstady on 2020/6/16.
 */
@Mapper
public interface TSLogDao {
    public List<TSLog> findAll(@Param("kssj")String kssj ,@Param("jssj")String jssj,Page<TSLog> page);

    public void insert(TSLog tSLog);


}
