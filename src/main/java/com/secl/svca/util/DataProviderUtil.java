package com.secl.svca.util;

import org.apache.log4j.Logger;

import com.secl.svca.bean.LoginBean;
import com.secl.svca.dao.SpringJdbcDao;
import com.secl.svca.manager.QueryManager;



public class DataProviderUtil implements Constant {
	
	private static Logger _logger = Logger.getLogger(DataProviderUtil.class);
	
	public LoginBean getLoginByLoginID(SpringJdbcDao springJdbcDao, QueryManager queryManager, String loginID) {
		LoginBean loginBean = null;
		try {
			loginBean = LoginUtil.getLogin(springJdbcDao, queryManager, loginID);
		} catch (Exception e){			
			_logger.error("An Exception occured while try to get Login Info by LoginID : ", e);
		}
		return loginBean;
	}
	
	
	
}
