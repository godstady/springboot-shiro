package com.khjy.zfjd.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.khjy.zfjd.mapper.SjhcMapper;
import com.khjy.zfjd.model.BazxBaqryxx;
import com.khjy.zfjd.model.BazxRygj;
import com.khjy.zfjd.model.BazxSswp;
import com.khjy.zfjd.service.SjhcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SjhcServiceImpl implements SjhcService {




    @Autowired
    private SjhcMapper sjhcMapper;



    @Override
    public Page<BazxBaqryxx> getList(Integer pageNo, Integer pageSize, String badw,String kssj,String jssj) {
        Page<BazxBaqryxx> page = new Page<>(pageNo,pageSize);
        List<BazxBaqryxx> list = sjhcMapper.getList(badw,kssj,jssj,page);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<BazxRygj> getRygj(String rybh) {
        return sjhcMapper.getRygj(rybh);
    }

    @Override
    public List<BazxSswp> getSswp(String rybh) {
        return sjhcMapper.getSswp(rybh);
    }
}
