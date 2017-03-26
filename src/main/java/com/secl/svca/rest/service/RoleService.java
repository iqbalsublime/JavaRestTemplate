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
import com.secl.svca.bean.RoleBean;
import com.secl.svca.manager.RoleManager;
import com.secl.svca.util.Constant;

@Path("/role")
public class RoleService implements Constant {
	
	
	@Context ServletContext servletContext;
	@Context HttpServletRequest request;
	private RoleManager roleManager;
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public ResponseBean postObject(RoleBean model) {
		ResponseBean response = new ResponseBean();
		if(model.getOperation().equalsIgnoreCase(GET_ALL_ROLE)){
			response = roleManager.getAllRole(response, model);
		}
		
		return response;
	}
	
	// Setter
	public void setRoleManager(RoleManager roleManager) {
		this.roleManager = roleManager;
	}

    

	
}


