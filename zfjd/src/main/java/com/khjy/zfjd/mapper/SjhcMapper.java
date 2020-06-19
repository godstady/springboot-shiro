package com.khjy.zfjd.mapper;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.khjy.zfjd.model.BazxBaqryxx;
import com.khjy.zfjd.model.BazxRygj;
import com.khjy.zfjd.model.BazxSswp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;


@DS("bazx")
@Mapper
public interface SjhcMapper {

    /**
     * 查询已经回传的数据
     * @param badw
     * @param page
     * @return
     */
    public List<BazxBaqryxx> getList(@Param("badw") String badw, @Param("kssj") String kssj ,@Param("jssj") String jssj,Page<BazxBaqryxx> page);


    /**
     * 查看某个人的随身物品信息
     * @param rybh
     * @return
     */
    public List<BazxSswp> getSswp(@Param("rybh") String rybh);


    /**
     * 查看某个人的轨迹信息
     * @param rybh
     * @return
     */
    public List<BazxRygj> getRygj(@Param("rybh") String rybh);
}
