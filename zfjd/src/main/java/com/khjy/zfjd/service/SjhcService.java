package com.khjy.zfjd.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.khjy.zfjd.model.BazxBaqryxx;
import com.khjy.zfjd.model.BazxRygj;
import com.khjy.zfjd.model.BazxSswp;

import java.util.List;

public interface SjhcService {

    Page<BazxBaqryxx> getList(Integer pageNo,Integer pageSize,String badw,String kssj,String jssj);


    List<BazxRygj> getRygj(String rybh);

    List<BazxSswp> getSswp(String rybh);


}
