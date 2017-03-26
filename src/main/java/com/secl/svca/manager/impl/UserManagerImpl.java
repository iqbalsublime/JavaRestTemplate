package com.secl.svca.manager.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.secl.svca.bean.Code;
import com.secl.svca.bean.LoginBean;
import com.secl.svca.bean.ResponseBean;
import com.secl.svca.bean.UserBean;
import com.secl.svca.manager.UserManager;
import com.secl.svca.util.Constant;
import com.secl.svca.util.ParamUtil;



public class UserManagerImpl extends ManagerImpl implements UserManager, Constant {
	
	private Logger _logger = Logger.getLogger(this.getClass());
	
	@Override
	public ResponseBean saveUser(ResponseBean response, UserBean model) {
		try {
			LoginBean loginBean = dataProviderUtil.getLoginByLoginID(springJdbcDao, queryManager, model.getLoginID());
			if(loginBean != null){
				response.setCode(Code.Ed1000);
				return response;
			}
			Object[] param = ParamUtil.getParamsWithoutObject(model.getLoginID(), model.getRoleID(), model.getPassword(),
					model.getStatus(), model.getName(), model.getImagePath(), model.getLoginBean().getLoginID(),
					model.getLat(), model.getLng());
			springJdbcDao.saveObject(queryManager.insertLoginSql(), param);
			response.setSuccess(true);
			response.setCode(Code.Sc1001);
			_logger.info("Successfully Save User for login ID : "+model.getLoginID());
		} catch (Exception e){			
			_logger.error("An Exception occured while Save User : ", e);
			response.setCode(Code.Us1000);
		}
		return response;
	}
	
	@Override
	public ResponseBean updateUser(ResponseBean response, UserBean model) {
		try {
			LoginBean loginBean = dataProviderUtil.getLoginByLoginID(springJdbcDao, queryManager, model.getLoginID());
			if(loginBean == null){
				response.setCode(Code.Nd1000);
				return response;
			}
			Object[] param = ParamUtil.getParamsWithoutObject(model.getRoleID(), model.getStatus(), model.getName(), 
					model.getImagePath(), model.getLoginBean().getLoginID(), new Date(), 
					model.getLat(), model.getLng(), model.getLoginID());
			springJdbcDao.updateObject(queryManager.updateLoginSql(), param);
			response.setSuccess(true);
			response.setCode(Code.Su1000);
			_logger.info("Successfully Update User for login ID : "+model.getLoginID());
		} catch (Exception e){			
			_logger.error("An Exception occured while Update User : ", e);
			response.setCode(Code.Us1000);
		}
		return response;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ResponseBean getAllUser(ResponseBean response, UserBean model) {
		try {
			List<UserBean> userList = springJdbcDao.getObjectList(queryManager.getAllLoginSql(), null, UserBean.class);
			if(userList != null && !userList.isEmpty()){
				response.setData(userList);
				response.setSuccess(true);
				response.setCode(Code.Su1002);
			}
			_logger.info("Successfully Load All User");
		} catch (Exception e){			
			_logger.error("An Exception occured while get all users : ", e);
			response.setCode(Code.Nd1000);
		}
		return response;
	}

	@Override
	public ResponseBean changePassword(ResponseBean response, UserBean model) {
		try {
			LoginBean entity = dataProviderUtil.getLoginByLoginID(springJdbcDao, queryManager, model.getLoginBean().getLoginID());
			if(!entity.getPassword().equals(model.getOldPassword())){
				response.setCode(Code.Pw1000);
				return response;
			}
			springJdbcDao.updateObject(queryManager.updateLoginPasswordSql(), 
					new Object[]{ model.getNewPassword(), new Date(), model.getLoginID(), model.getLoginBean().getLoginID() });
			response.setSuccess(true);
			response.setCode(Code.Su1001);
			_logger.info("Successfully Update Password : "+ model.getLoginBean().getLoginID());
		} catch (Exception e){			
			_logger.error("An Exception occured while update to password : ", e);
			response.setCode(Code.Us1000);
		}
		return response;
	}

	@Override
	public ResponseBean resetPassword(ResponseBean response, UserBean model) {
		try {
			springJdbcDao.updateObject(queryManager.updateLoginPasswordSql(), 
					new Object[]{ model.getNewPassword(), new Date(), model.getLoginBean().getLoginID(), model.getLoginID() });
			response.setSuccess(true);
			response.setCode(Code.Su1001);
			_logger.info("Successfully Reset Password : "+ model.getLoginID());
		} catch (Exception e){			
			_logger.error("An Exception occured while Reset to password : ", e);
			response.setCode(Code.Us1000);
		}
		return response;
	}

	@Override
	public ResponseBean getUserByLoginID(ResponseBean response, UserBean model) {
		try {
			LoginBean loginBean = dataProviderUtil.getLoginByLoginID(springJdbcDao, queryManager, model.getLoginID());
			if(loginBean == null){
				response.setCode(Code.Nd1000);
				return response;
			}
			response.setData(loginBean);
			response.setSuccess(true);
			_logger.info("Successfully Get User by login ID : "+model.getLoginID());
		} catch (Exception e){			
			_logger.error("An Exception occured while Get User by login ID : ", e);
			response.setCode(Code.Us1000);
		}
		return response;
	}

	

}
