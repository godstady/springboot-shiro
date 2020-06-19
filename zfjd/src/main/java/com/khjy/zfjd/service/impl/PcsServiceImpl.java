package com.khjy.zfjd.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.khjy.zfjd.mapper.PcsMapper;
import com.khjy.zfjd.model.PersonsInvoled;
import com.khjy.zfjd.service.PcsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PcsServiceImpl implements PcsService {



    @Autowired
    private PcsMapper pcsMapper;


    @Override
    public Page<PersonsInvoled> getZydata(Integer pageNo, Integer pageSize, String badw, String kssj,String jssj) {
        Page<PersonsInvoled> page = new Page<>(pageNo,pageSize);
        List<PersonsInvoled> zydata = pcsMapper.getZydata(badw, kssj,jssj ,page);

        return page.setRecords(zydata);
    }

    @Override
    public Page<PersonsInvoled> getYjdata(Integer pageNo, Integer pageSize, String badw, String kssj,String jssj) {
        Page<PersonsInvoled> page = new Page<>(pageNo,pageSize);
        List<PersonsInvoled> zydata = pcsMapper.getYjdata(badw, kssj,jssj ,page);

        return page.setRecords(zydata);
    }
}
