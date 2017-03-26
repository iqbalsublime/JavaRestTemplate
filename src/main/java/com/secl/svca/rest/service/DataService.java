package com.secl.svca.rest.service;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.secl.svca.bean.RequestBean;
import com.secl.svca.bean.ResponseBean;
import com.secl.svca.util.Constant;


@Path("/data")
public class DataService implements Constant {
	
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public ResponseBean postObject(RequestBean request) {
		ResponseBean response = new ResponseBean();
		return response;
	}

	
	
	
	// Setter

	
	
}






