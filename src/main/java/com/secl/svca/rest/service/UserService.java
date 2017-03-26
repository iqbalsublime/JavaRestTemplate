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
import com.secl.svca.bean.UserBean;
import com.secl.svca.manager.UserManager;
import com.secl.svca.util.Constant;

@Path("/user")
public class UserService implements Constant {
	
	
	@Context ServletContext servletContext;
	@Context HttpServletRequest request;
	private UserManager userManager;
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public ResponseBean postObject(UserBean model) {
		ResponseBean response = new ResponseBean();
		if(model.getOperation().equalsIgnoreCase(SAVE)){
			response = userManager.saveUser(response, model);
		} else if(model.getOperation().equalsIgnoreCase(UPDATE)){
			response = userManager.updateUser(response, model);
		} else if(model.getOperation().equalsIgnoreCase(GET_USER_BY_LOGINID)){
			response = userManager.getUserByLoginID(response, model);
		} else if(model.getOperation().equalsIgnoreCase(GET_ALL_USER)){
			response = userManager.getAllUser(response, model);
		} else if(model.getOperation().equalsIgnoreCase(CHANGE_PASSWORD)){
			response = userManager.changePassword(response, model);
		} else if(model.getOperation().equalsIgnoreCase(RESET_PASSWORD)){
			response = userManager.resetPassword(response, model);
		}
		
		return response;
	}
	
	// Setter
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

    

	
}


