package com.khjy.zfjd.model;


import lombok.Data;

import java.io.Serializable;

@Data
public class CaseInfo implements Serializable {

  private String caseid;
  private String casecode;
  private String casename;
  private String casetype;
  private String casecategory;
  private String casebrief;
  private String receiveday;
  private String handleDeptid;
  private String sponsorName;
  private String sponsorPoliceidd;
  private String centersponsor;
  private String processer;
  private String processDeptid;
  private String processtime;
  private String isdel;
  private String isborrowed;
  private String existingProblem;



}
