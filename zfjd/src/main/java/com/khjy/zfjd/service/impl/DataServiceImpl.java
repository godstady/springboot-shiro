package com.khjy.zfjd.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.khjy.zfjd.mapper.DataMapper;
import com.khjy.zfjd.model.*;
import com.khjy.zfjd.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class DataServiceImpl implements DataService {


    @Autowired
    private DataMapper dataMapper;



    @Override
    public Page<Data> getData(Integer pageNo,Integer pageSize,String badw,String kssj,String jssj) {
        Page<Data> page = new Page<>(pageNo,pageSize);
        List<Data> data = dataMapper.getData(badw,kssj,jssj,page);
        return page.setRecords(data);
    }

    @Override
    public List<Ryxx> getRyxxById(String serchKey, String serchValue) {
        return dataMapper.getRyxxById(serchKey,serchValue);
    }

    @Override
    public List<SjjhWaWpxx> getWpxxById(String serchKey, String serchValue) {
        return dataMapper.getWpxxById(serchKey,serchValue);
    }

    @Override
    public List<SjjhWaJqxx> getJqxxById(String serchKey, String serchValue) {
        return dataMapper.getJqxxById(serchKey,serchValue);
    }

    @Override
    public List<SjjhWaRyclxx> getRyclById(String serchKey, String serchValue) {
        return dataMapper.getRyclById(serchKey,serchValue);
    }

    @Override
    public List<Ajxx> getAjxxById(String serchKey, String serchValue) {
        return dataMapper.getAjxxById(serchKey,serchValue);
    }


}
