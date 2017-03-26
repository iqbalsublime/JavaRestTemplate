package com.secl.svca.manager.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.secl.svca.bean.Code;
import com.secl.svca.bean.ResponseBean;
import com.secl.svca.bean.SubscribersBean;
import com.secl.svca.manager.SubscriberManager;
import com.secl.svca.util.Constant;


public class SubscriberManagerImpl extends ManagerImpl implements SubscriberManager, Constant {
	
	private Logger _logger = Logger.getLogger(this.getClass());

	@SuppressWarnings("unchecked")
	@Override
	public ResponseBean getAllSubscribers(ResponseBean response, SubscribersBean model) {
	
		try {
			List<SubscribersBean> subscriberList = springJdbcDao.getObjectList(queryManager.getAllSubscribersUserSql(), null, SubscribersBean.class);
			response.setData(subscriberList);
			response.setSuccess(true);
			response.setCode(Code.Su1002);
			_logger.info("Successfully Load All Subscriber");
		} catch (Exception e){			
			_logger.error("An Exception occured while get all Subscriber : ", e);
			response.setCode(Code.Nd1000);
		}
		return response;
	}
	

}
