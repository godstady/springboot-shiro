package com.khjy.zfjd.system.bean;

import java.util.Date;

/**
 * Created by godstady on 2020/6/19.
 */
public class TSLog {
    private  String id;
    private  String operator;
    private Date optime;
    private String optype;
    private String optlx;
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getOptime() {
        return optime;
    }

    public void setOptime(Date optime) {
        this.optime = optime;
    }

    public String getOptype() {
        return optype;
    }

    public void setOptype(String optype) {
        this.optype = optype;
    }

    public String getOptlx() {
        return optlx;
    }

    public void setOptlx(String optlx) {
        this.optlx = optlx;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
