package com.secl.svca.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.secl.svca.bean.MetaPropertyBean;
import com.secl.svca.bean.ResponseBean;
import com.secl.svca.manager.MetapropertyManager;
import com.secl.svca.util.Constant;

@Component
@Scope("prototype")
@Path("/setupdata")
public class MetapropertyService implements Constant {
	
	private MetapropertyManager metapropertyManager;
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public ResponseBean postObject(MetaPropertyBean model) {
		ResponseBean response = new ResponseBean();
		if(model.getOperation().equalsIgnoreCase(GET_ALL)){
			response = metapropertyManager.getSetupItem(response, model);
		} else if(model.getOperation().equalsIgnoreCase(UPDATE)){
			response = metapropertyManager.updateSetupItem(response, model);
		}
		return response;
	}

	public void setMetapropertyManager(MetapropertyManager metapropertyManager) {
		this.metapropertyManager = metapropertyManager;
	}



}
