package com.secl.svca.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.common.base.Strings;
import com.secl.svca.bean.MetaPropertyBean;
import com.secl.svca.bean.SetUpBean;
import com.secl.svca.dao.SpringJdbcDao;


public class MetaPropertyDataProviderUtil {
	
	private Logger _logger = Logger.getLogger(this.getClass());
	
	public synchronized MetaPropertyBean getMetaPropertyByOid(SpringJdbcDao springJdbcDao, String sql, String oid) throws Exception {
		MetaPropertyBean metaPropertyBean = null;
		try {
			metaPropertyBean = (MetaPropertyBean) springJdbcDao.getObject(sql, new Object[]{oid}, MetaPropertyBean.class);
		} catch (Exception e){			
			_logger.error("An Exception occured while try to get MetaProperty By OID : ", e);
			throw e;
		}
		return metaPropertyBean;
	}

	public synchronized SetUpBean getSetUpBeanByKey(MetaPropertyBean metaPropertyBean, String key) throws Exception {
		SetUpBean setUpBean = null;
		if(metaPropertyBean == null || Strings.isNullOrEmpty(metaPropertyBean.getValueJSON())){
			return setUpBean;
		}
		SetUpBean[] list = (SetUpBean[]) GsonUtil.parseObject(metaPropertyBean.getValueJSON(), SetUpBean[].class);
		if(list == null || list.length == 0){
			return setUpBean;
		}
		for(SetUpBean bean : list){
			if(bean.getId().equalsIgnoreCase(key)){
				setUpBean = bean;
				break;
			}
		}
		return setUpBean;
	}
	
	public synchronized List<SetUpBean> getSetUpBeanList(MetaPropertyBean metaPropertyBean) {
		if(metaPropertyBean == null || Strings.isNullOrEmpty(metaPropertyBean.getValueJSON())){
			return null;
		}
		SetUpBean[] list = (SetUpBean[]) GsonUtil.parseObject(metaPropertyBean.getValueJSON(), SetUpBean[].class);
		if(list == null || list.length == 0){
			return null;
		}
		Arrays.sort(list, SetUpBean.SortOrderComparator);
		return new ArrayList<SetUpBean>(Arrays.asList(list));
	}
	
	public synchronized SetUpBean getSetUpBeanByKey(List<SetUpBean> setUpBeanList, String key) {
		if(setUpBeanList == null || setUpBeanList.isEmpty()){
			return null;
		}
		for(SetUpBean bean : setUpBeanList){
			if(bean.getId().equalsIgnoreCase(key)){
				return bean;
			}
		}
		return null;
	}
	

	

}
