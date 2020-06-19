package com.khjy.zfjd.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.khjy.zfjd.model.PersonsInvoled;


public interface PcsService {
    public Page<PersonsInvoled> getZydata(Integer pageNo, Integer pageSize , String badw, String kssj,String jssj);

    public Page<PersonsInvoled> getYjdata(Integer pageNo, Integer pageSize , String badw, String kssj,String jssj);
}
