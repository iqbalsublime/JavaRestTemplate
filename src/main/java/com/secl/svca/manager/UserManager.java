package com.secl.svca.manager;


import com.secl.svca.bean.ResponseBean;
import com.secl.svca.bean.UserBean;



public interface UserManager extends Manager {
	
	public ResponseBean saveUser(ResponseBean response, UserBean model);
	
	public ResponseBean updateUser(ResponseBean response, UserBean model);
	
	public ResponseBean getAllUser(ResponseBean response, UserBean model);

	public ResponseBean changePassword(ResponseBean response, UserBean model);

	public ResponseBean resetPassword(ResponseBean response, UserBean model);

	public ResponseBean getUserByLoginID(ResponseBean response, UserBean model);

}
