package com.secl.svca.manager;


import javax.servlet.http.HttpServletRequest;

import com.secl.svca.bean.LoginBean;
import com.secl.svca.bean.ResponseBean;



public interface LoginManager extends Manager {
	
	public ResponseBean doLogin(HttpServletRequest request, ResponseBean response, LoginBean model);
	
	public ResponseBean doLogout(HttpServletRequest request, ResponseBean resBean, LoginBean model);



}
