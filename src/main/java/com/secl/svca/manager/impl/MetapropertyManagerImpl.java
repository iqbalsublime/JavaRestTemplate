package com.secl.svca.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.secl.svca.bean.Code;
import com.secl.svca.bean.MetaPropertyBean;
import com.secl.svca.bean.ResponseBean;
import com.secl.svca.manager.MetapropertyManager;
import com.secl.svca.util.Constant;
import com.secl.svca.util.Table;


@Service
public class MetapropertyManagerImpl extends ManagerImpl implements MetapropertyManager {

	private Logger _logger = Logger.getLogger(this.getClass());
	
	@Override
	public ResponseBean getSetupItem(ResponseBean response, MetaPropertyBean model) {
		try {
			MetaPropertyBean metaPropertySetUpBean = null;
			try {
				metaPropertySetUpBean = metaPropertyDataProviderUtil.getMetaPropertyByOid(springJdbcDao, 
					queryManager.getMetaPropertyByOidSQL(), Constant.META_PROPERTY_OID_SETUP_DATA);
			} catch(Exception e){
				_logger.error("An Exception occured while get Meta Property : ", e);
				return response;			
			}
			if(metaPropertySetUpBean == null){
				_logger.warn("Meta Property are Not Found!!!");
				return response;
			}
			response.setData(metaPropertySetUpBean);
			response.setSuccess(true);
		} catch (Exception e) {
			_logger.error("An Exception occurred while getting all setup data : ", e);
		}	
		return response;
	}

	@Override
	public ResponseBean updateSetupItem(ResponseBean response,MetaPropertyBean model) {
		try {
			String sql = "UPDATE "+Table.META_PROPERTY+" SET valueJSON = '"+model.getValueJSON()+"' WHERE oid = '"+Constant.META_PROPERTY_OID_SETUP_DATA+"'";
			springJdbcDao.updateObject(sql, null);
			_logger.info("Successfully update valueJSON Record for..."+ Constant.META_PROPERTY_OID_SETUP_DATA);
			response.setCode(Code.Su1000);
		} catch (Exception e){
			_logger.error("An Exception occurred while updating valueJSON for : "+Constant.META_PROPERTY_OID_SETUP_DATA, e); 
			e.printStackTrace();
			response.setCode(Code.Up1000);
			return response;
		}
		return response;
	}
	
}
