package com.secl.svca.manager.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.secl.svca.bean.Code;
import com.secl.svca.bean.LoginBean;
import com.secl.svca.bean.ResponseBean;
import com.secl.svca.entity.LoginLog;
import com.secl.svca.manager.LoginManager;
import com.secl.svca.util.Constant;
import com.secl.svca.util.ParamUtil;
import com.secl.svca.util.Table;



public class LoginManagerImpl extends ManagerImpl implements LoginManager, Constant {
	
	private Logger _logger = Logger.getLogger(this.getClass());
	
	@Override
	public ResponseBean doLogin(HttpServletRequest request, ResponseBean response, LoginBean model) {
		try {
			LoginBean loginBean = dataProviderUtil.getLoginByLoginID(springJdbcDao, queryManager, model.getLoginID());
			if(loginBean == null){
				_logger.warn("No found Login for : "+model.getLoginID());
				response.setCode(Code.Nl1000);
				return response;
			}
			else if(!loginBean.getStatus().equalsIgnoreCase(ACTIVE_SHORT)){
				_logger.warn("Inactive user for : "+model.getLoginID());
				response.setCode(Code.Ia1000);
				return response;
			}
			else if(!loginBean.getPassword().equals(model.getPassword())){
				_logger.warn("Password not match for : "+ model.getLoginID());
				response.setCode(Code.Pw1000);
				return response;
			}
			loginBean.setSessionId(idGenerator.getSessionId());
			loginBean.setPassword(null);
			response.setData(loginBean);
			sessionManager.setUserInSession(loginBean);
			//LoginLog loginLog = new LoginLog(loginBean, request);
			//simpleJdbcDao.saveObject(loginLog, Table.LOGIN_LOG);
			_logger.info("Successfully Login : "+ model.getLoginID());
		} catch (Exception e){			
			_logger.error("An Exception occured while try to Login : ", e);
		}
		return response;
	}
	
	public ResponseBean doLogout(HttpServletRequest request, ResponseBean resBean, LoginBean model) {
		try {
			Object[] params = ParamUtil.getParamsWithoutObject(LOGOUT, new Date(), model.getSessionId());
			springJdbcDao.updateObject(queryManager.updateLoginLog(), params);
			resBean.setSuccess(true);
			sessionManager.clearSession(model);
			_logger.info("Successfully Logout : "+ model.getLoginID());
		} catch (Exception e) {
			_logger.error("An exception occured while to Logout : "+model.getLoginID(), e);
		}
		return resBean;
	}
	

}
