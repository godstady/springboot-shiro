package com.khjy.zfjd.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.khjy.zfjd.config.R;
import com.khjy.zfjd.model.*;
import com.khjy.zfjd.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;


/**
 * 数据返回controller
 * @author renjingkai
 */
@Controller
@RequestMapping("/")
public class DataController {


    /**
     * 市局下发数据比对业务
     */
    @Autowired
    private DataService dataService;


    /**
     * 办案中心数据业务
     */
    @Autowired
    private PersonService personService;


    /**
     * 派出所数据业务
     */
    @Autowired
    private PcsService pcsService;


    /**
     * 数据回传业务
     */
    @Autowired
    private SjhcService sjhcService;


    /**
     * 警综平台视频业务
     */
    @Autowired
    private JzspService jzspService;



    @RequestMapping("/getInfo")
    @ApiOperation(value = "返回跟市局下发数据比对后的数据")
    @ResponseBody
    public R getInfo (@RequestParam(required = false) Integer page,
                      @RequestParam(required = false) Integer limit,
                      @RequestParam(required = false) String badw,
                      @RequestParam(required = false) String kssj,
                      @RequestParam(required = false) String jssj){

        Page<Data> data = dataService.getData(page,limit,badw,kssj,jssj);
        return R.success(0,"成功！",data.getTotal(),data.getRecords());
    }


    @RequestMapping("/getBadw")
    @ApiOperation(value = "返回办案中心数据库的组织单位")
    @ResponseBody
    public List<Code> getBadw(){
        return personService.getBadw();
    }



    @RequestMapping("/getPcsZy")
    @ApiOperation(value = "返回派出所数据库在押的人员信息")
    @ResponseBody
    public R getPcsZy(@RequestParam(required = false) Integer page,
                      @RequestParam(required = false) Integer limit,
                      @RequestParam(required = false) String badw,
                      @RequestParam(required = false) String kssj,
                      @RequestParam(required = false) String jssj){

            Page<PersonsInvoled> data = pcsService.getZydata(page,limit,badw,kssj,jssj);

            return R.success(0,"成功！",data.getTotal(),data.getRecords());
    }


    @RequestMapping("/getPcsYj")
    @ApiOperation(value = "返回派出所数据库在押超过24小时的信息")
    @ResponseBody
    public R getPcsYj(@RequestParam(required = false) Integer page,
                      @RequestParam(required = false) Integer limit,
                      @RequestParam(required = false) String badw,
                      @RequestParam(required = false) String kssj,
                      @RequestParam(required = false) String jssj){

        Page<PersonsInvoled> data = pcsService.getYjdata(page,limit,badw,kssj,jssj);

        return R.success(0,"成功！",data.getTotal(),data.getRecords());
    }



    @RequestMapping("/getSjwhc")
    @ApiOperation("返回已经回传过去的数据")
    @ResponseBody
    public R getSjwhc(@RequestParam(required = false) Integer page,
                      @RequestParam(required = false) Integer limit,
                      @RequestParam(required = false) String badw,
                      @RequestParam(required = false) String kssj,
                      @RequestParam(required = false) String jssj){
        Page<BazxBaqryxx> data = sjhcService.getList(page,limit,badw,kssj,jssj);

        return R.success(0,"成功！",data.getTotal(),data.getRecords());
    }



    @RequestMapping("/getSswp/{rybh}")
    @ApiOperation("根据人员编号返回随身物品数据")
    @ResponseBody
    public R getSswp(@PathVariable String rybh){
        List<BazxSswp> list = sjhcService.getSswp(rybh);
        return R.success(0,"成功！",(long)list.size(),list);
    }


    @RequestMapping("/getRygj/{rybh}")
    @ApiOperation("根据人员编号返回人员轨迹数据")
    @ResponseBody
    public R getRygj(@PathVariable String rybh){
        List<BazxRygj> list = sjhcService.getRygj(rybh);
        return R.success(0,"成功！",(long)list.size(),list);
    }



    @RequestMapping("/getCxxx")
    @ApiOperation("根据编号查询基本信息")
    public String getRyxxById(@RequestParam("serchKey") String serchKey, @RequestParam("serchValue") String serchValue, Model model){

        List<Ryxx> ryxx = dataService.getRyxxById(serchKey,serchValue);
        List<Ajxx> ajxx = dataService.getAjxxById(serchKey,serchValue);
        List<SjjhWaWpxx> wpxx = dataService.getWpxxById(serchKey,serchValue);
        List<SjjhWaJqxx> jqxx = dataService.getJqxxById(serchKey,serchValue);
        List<SjjhWaRyclxx> rycl = dataService.getRyclById(serchKey,serchValue);

        model.addAttribute("ryxxList",ryxx);
        model.addAttribute("ajxxList",ajxx);
        model.addAttribute("wpxxList",wpxx);
        model.addAttribute("jqxxList",jqxx);
        model.addAttribute("ryclList",rycl);

        return "zfba/cxxx-data";

    }


    @ResponseBody
    @RequestMapping("/getJzsp")
    @ApiOperation("查询警综平台音视频信息")
    public R getJzsp(@RequestParam(required = false) Integer page,
                     @RequestParam(required = false) Integer limit,
                     @RequestParam(required = false) String kssj,
                     @RequestParam(required = false) String jssj){
        Page<FzyspGlfkb> data = jzspService.getSp(page,limit,kssj,jssj);
        return R.success(0,"成功！",data.getTotal(),data.getRecords());
    }

}
