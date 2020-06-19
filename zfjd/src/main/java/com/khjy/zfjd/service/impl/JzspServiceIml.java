package com.khjy.zfjd.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.khjy.zfjd.mapper.JzspMapper;
import com.khjy.zfjd.model.FzyspGlfkb;
import com.khjy.zfjd.service.JzspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;



// @CacheConfig(cacheNames = {"jzspCache"})
@Service
public class JzspServiceIml implements JzspService {


    @Autowired
    private JzspMapper jzspMapper;


    // @Cacheable(key = "#kssj" ,value = "jzspCache")
    @Override
    public Page<FzyspGlfkb> getSp(Integer pageNo, Integer pageSize, String kssj, String jssj) {
        Page<FzyspGlfkb> page = new Page<>(pageNo,pageSize);
        List<FzyspGlfkb> list = jzspMapper.getSp(kssj,jssj,page);
        return page.setRecords(list);
    }
}
