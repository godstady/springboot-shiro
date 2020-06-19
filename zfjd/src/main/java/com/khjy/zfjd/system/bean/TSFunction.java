package com.khjy.zfjd.system.bean;

/**
 * Created by godstady on 2020/6/17.
 */
public class TSFunction {
    private  String id;
    private  Integer functionlevel;
    private  String functionname;
    private  String functionorder;
    private  String functionurl;
    private  String parentfunctionid;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getFunctionlevel() {
        return functionlevel;
    }

    public void setFunctionlevel(Integer functionlevel) {
        this.functionlevel = functionlevel;
    }

    public String getFunctionname() {
        return functionname;
    }

    public void setFunctionname(String functionname) {
        this.functionname = functionname;
    }

    public String getFunctionorder() {
        return functionorder;
    }

    public void setFunctionorder(String functionorder) {
        this.functionorder = functionorder;
    }

    public String getFunctionurl() {
        return functionurl;
    }

    public void setFunctionurl(String functionurl) {
        this.functionurl = functionurl;
    }

    public String getParentfunctionid() {
        return parentfunctionid;
    }

    public void setParentfunctionid(String parentfunctionid) {
        this.parentfunctionid = parentfunctionid;
    }

    @Override
    public String toString() {
        return "TSFunction{" +
                "id='" + id + '\'' +
                ", functionlevel=" + functionlevel +
                ", functionname='" + functionname + '\'' +
                ", functionorder='" + functionorder + '\'' +
                ", functionurl='" + functionurl + '\'' +
                ", parentfunctionid='" + parentfunctionid + '\'' +
                '}';
    }
}
