package com.khjy.zfjd.mapper;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.khjy.zfjd.model.Code;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;


/**
 * 办案中心数据查询
 * @author renjingkai
 */
@DS("bazx")
@Mapper
public interface PersonMapper {

//    /**
//     * 得到办案中心的数据
//     * @return
//     */
//    public List<Data> getPerson(@Param("badw") String badw);
//
    /**
     * 得到办案单位信息
     * @param
     * @return
     */
    public List<Code> getBadw();


    /**
     * 根据组织机构no查ID
     * @return
     */
    public String getBadwid(@Param("orgno") String orgno);

}
