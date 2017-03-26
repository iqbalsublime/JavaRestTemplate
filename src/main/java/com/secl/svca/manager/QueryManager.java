package com.secl.svca.manager;


public interface QueryManager {
	
	public String getLoginSql();
	
	public String insertLoginSql();
	
	public String insertLoginLog();
	
	public String updateLoginLog();
	
	//public String getLoginByLoginIDSql();

	public String getAllLoginSql();

	public String updateLoginPasswordSql();
	
	public String getMetaPropertyByOidSQL();
	
	public String getAllRoleSql();

	public String updateLoginSql();

	public String getAllSubscribersUserSql();
	
	

}




