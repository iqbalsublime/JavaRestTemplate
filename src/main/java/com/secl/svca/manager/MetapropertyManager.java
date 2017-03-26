package com.secl.svca.manager;

import com.secl.svca.bean.MetaPropertyBean;
import com.secl.svca.bean.ResponseBean;


public interface MetapropertyManager extends Manager {
	
	public ResponseBean getSetupItem(ResponseBean response, MetaPropertyBean model);

	public ResponseBean updateSetupItem(ResponseBean response, MetaPropertyBean model);
			
}
