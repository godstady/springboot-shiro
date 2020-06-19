package com.khjy.zfjd.system.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.khjy.zfjd.system.bean.TSFunction;
import com.khjy.zfjd.system.bean.TSUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by godstady on 2020/6/16.
 */
@Mapper
public interface TSUserDao {
    public List<TSUser> findAll(Page<TSUser> page);
    public TSUser getUser(@Param("id") String id);
    public List<String> getrole(@Param("userno") String userno);
    public List<TSFunction> getfun(@Param("rolist") List<String> rolist);

}
