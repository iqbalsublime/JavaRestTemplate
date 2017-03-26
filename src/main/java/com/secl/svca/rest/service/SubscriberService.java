package com.secl.svca.rest.service;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.secl.svca.bean.ResponseBean;
import com.secl.svca.bean.SubscribersBean;
import com.secl.svca.manager.SubscriberManager;
import com.secl.svca.util.Constant;

@Path("/subscriber")
public class SubscriberService implements Constant {
	
	
	@Context ServletContext servletContext;
	@Context HttpServletRequest request;
	private SubscriberManager subscriberManager;
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public ResponseBean postObject(SubscribersBean model) {
		ResponseBean response = new ResponseBean();
		if(model.getOperation().equalsIgnoreCase(GET_ALL_SUBSCRIBER)){
			response = subscriberManager.getAllSubscribers(response, model);
		} 	
		return response;
	}	
	// Setter
	public void setSubscriberManager(SubscriberManager subscribersManager) {
		this.subscriberManager = subscribersManager;
	}

    

	
}


