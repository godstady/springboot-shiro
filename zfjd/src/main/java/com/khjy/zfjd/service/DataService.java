package com.khjy.zfjd.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.khjy.zfjd.model.*;

import java.util.List;


public interface DataService {

    public Page<Data> getData(Integer pageNo, Integer pageSize,String badw,String kssj ,String jssj);

    /**
     * 根据编号查询人员基本信息
     * @return
     */
    public List<Ryxx> getRyxxById(String serchKey,String serchValue);


    /**
     * 根据编号查物品信息
     * @return
     */
    public List<SjjhWaWpxx> getWpxxById(String serchKey,String serchValue);


    /**
     * 根据编号查警情信息
     * @return
     */
    public List<SjjhWaJqxx> getJqxxById(String serchKey,String serchValue);


    /**
     * 根据编号查人员处理信息
     * @return
     */
    public List<SjjhWaRyclxx> getRyclById(String serchKey,String serchValue);


    /**
     * 根据编号查案件信息
     * @return
     */
    public List<Ajxx> getAjxxById(String serchKey,String serchValue);
}
