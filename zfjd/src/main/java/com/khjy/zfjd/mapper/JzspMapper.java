package com.khjy.zfjd.mapper;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.khjy.zfjd.model.FzyspGlfkb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 警综音视频数据库的mapper
 * @author renjingkai
 */
@DS("bazx")
@Mapper
public interface JzspMapper {

    /**
     * 查询已经上传的音视频情况
     * @param kssj
     * @param jssj
     * @param page
     * @return
     */
    public List<FzyspGlfkb> getSp(@Param("kssj") String kssj, @Param("jssj") String jssj, Page<FzyspGlfkb> page);




}
