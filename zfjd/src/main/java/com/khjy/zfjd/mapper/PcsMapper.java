package com.khjy.zfjd.mapper;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.khjy.zfjd.model.PersonsInvoled;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 派出所的mapper
 * @author renjingkai
 */
@DS("pcs")
@Mapper
public interface PcsMapper {

    /**
     * 查询派出所在押人员信息的数据
     * @param badw 办案单位
     * @param page 分页
     * @return
     */
    public List<PersonsInvoled> getZydata(@Param("badw") String badw, @Param("kssj") String kssj,@Param("jssj") String jssj, Page<PersonsInvoled> page);


    /**
     * 查询派出所在押人员预警信息的数据
     * @param badw 办案单位
     * @param page 分页
     * @return
     */
    public List<PersonsInvoled> getYjdata(@Param("badw") String badw, @Param("kssj") String kssj,@Param("jssj") String jssj, Page<PersonsInvoled> page);


}
