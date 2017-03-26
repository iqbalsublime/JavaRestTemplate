package com.secl.svca.util;

import org.apache.log4j.Logger;

import com.secl.svca.bean.LoginBean;
import com.secl.svca.dao.SpringJdbcDao;
import com.secl.svca.manager.QueryManager;

public class LoginUtil implements Constant {
	
	@SuppressWarnings("unused")
	private static Logger _logger = Logger.getLogger(LoginUtil.class);

	public static LoginBean getLogin(SpringJdbcDao springJdbcDao, QueryManager queryManager, String loginID) throws Exception {
		LoginBean login = (LoginBean) springJdbcDao.getObject(queryManager.getLoginSql(), new Object[]{loginID}, LoginBean.class);
		return login;
	}
	
	
}
