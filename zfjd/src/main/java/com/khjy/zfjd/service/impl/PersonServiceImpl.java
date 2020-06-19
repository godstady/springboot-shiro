package com.khjy.zfjd.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.khjy.zfjd.mapper.PersonMapper;
import com.khjy.zfjd.model.Code;
import com.khjy.zfjd.model.Data;
import com.khjy.zfjd.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * 办案中心人员的业务实现
 * @author renjignkai
 */
@Service
public class PersonServiceImpl implements PersonService {


    @Autowired
    private PersonMapper personMapper;


//    @Override
//    public List<Data> getRyxx(Integer pageNo, Integer pageSize,String badw) {
////        Page<Data> page = new Page<>(pageNo,pageSize);
//        return personMapper.getPerson(badw);
//    }


    @Override
    public List<Code> getBadw() {
        return personMapper.getBadw();
    }
}
