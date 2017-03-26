package com.secl.svca.manager;


import com.secl.svca.bean.ResponseBean;
import com.secl.svca.bean.RoleBean;



public interface RoleManager extends Manager {
	
	
	public ResponseBean getAllRole(ResponseBean response, RoleBean model);


}
