package com.secl.svca.manager.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.secl.svca.bean.Code;
import com.secl.svca.bean.ResponseBean;
import com.secl.svca.bean.RoleBean;
import com.secl.svca.manager.RoleManager;
import com.secl.svca.util.Constant;



public class RoleManagerImpl extends ManagerImpl implements RoleManager, Constant {
	
	private Logger _logger = Logger.getLogger(this.getClass());
	
	
	@SuppressWarnings("unchecked")
	@Override
	public ResponseBean getAllRole(ResponseBean response, RoleBean model) {
		try {
			List<RoleBean> roleList = springJdbcDao.getObjectList(queryManager.getAllRoleSql(), null, RoleBean.class);
			if(roleList != null && !roleList.isEmpty()){
				response.setData(roleList);
				response.setSuccess(true);
				response.setCode(Code.Su1003);
			}
			_logger.info("Successfully Load All Role");
		} catch (Exception e){			
			_logger.error("An Exception occured while get all role : ", e);
			response.setCode(Code.Nd1000);
		}
		return response;
	}


	

}
