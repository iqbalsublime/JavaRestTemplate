package com.secl.svca.bean;

import java.io.Serializable;


 
@SuppressWarnings("serial")
public class ReportParamBean implements Serializable {
	
	public LoginBean loginBean;
	public String reportName;
	public String destinationFolder;
	public String fromDate;
	public String toDate;
	public String oid;
	public String[] oids;
	
	public ReportParamBean() {}
	
	
	
}
