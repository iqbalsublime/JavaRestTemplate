package com.secl.svca.rest.service;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.secl.svca.bean.LoginBean;
import com.secl.svca.bean.ResponseBean;
import com.secl.svca.manager.LoginManager;
import com.secl.svca.util.Constant;

@Path("/security")
public class LoginService implements Constant {
	
	
	@Context ServletContext servletContext;
	@Context HttpServletRequest request;
	private LoginManager loginManager;
	
	@POST
	@Path("/useraccess")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public ResponseBean postObject(LoginBean model) {
		ResponseBean response = new ResponseBean();
		if(model.getOperation().equalsIgnoreCase(LOGIN)){
			response = loginManager.doLogin(request, response, model);
		} else if(model.getOperation().equalsIgnoreCase(LOGOUT)){
			response = loginManager.doLogout(request, response, model);
		}
		
		return response;
	}
	
	// Setter
	public void setLoginManager(LoginManager loginManager) {
		this.loginManager = loginManager;
	}

    

	
}


