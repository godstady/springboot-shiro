package com.khjy.zfjd.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.khjy.zfjd.model.FzyspGlfkb;



public interface JzspService {


    public Page<FzyspGlfkb> getSp(Integer pageNo,Integer pageSize,String kssj, String jssj) ;
}
