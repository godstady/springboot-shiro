package com.khjy.zfjd.mapper;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.khjy.zfjd.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 市局下发数据比对的mapper
 */
@DS("zfba")
@Mapper
public interface DataMapper {

    /**
     * 查询比对之后的数据
     * @param badw 办案单位
     * @param kssj 开始时间
     * @param jssj 结束时间
     * @param page 分页
     * @return
     */
    public List<Data> getData(@Param("badw") String badw,@Param("kssj") String kssj,@Param("jssj") String jssj,Page<Data> page);


    /**
     * 根据编号查询人员基本信息
     * @return
     */
    public List<Ryxx> getRyxxById(@Param("serchKey") String serchKey,@Param("serchValue") String serchValue);


    /**
     * 根据编号查物品信息
     * @return
     */
    public List<SjjhWaWpxx> getWpxxById(@Param("serchKey") String serchKey,@Param("serchValue") String serchValue);


    /**
     * 根据编号查警情信息
     * @return
     */
    public List<SjjhWaJqxx> getJqxxById(@Param("serchKey") String serchKey,@Param("serchValue") String serchValue);


    /**
     * 根据编号查人员处理信息
     * @return
     */
    public List<SjjhWaRyclxx> getRyclById(@Param("serchKey") String serchKey,@Param("serchValue") String serchValue);


    /**
     * 根据编号查案件信息
     * @return
     */
    public List<Ajxx> getAjxxById(@Param("serchKey") String serchKey,@Param("serchValue") String serchValue);
}
