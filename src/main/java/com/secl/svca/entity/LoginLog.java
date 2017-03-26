package com.secl.svca.entity;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.secl.svca.bean.LoginBean;
import com.secl.svca.util.Constant;

@SuppressWarnings("serial")
public class LoginLog extends AbstractEntity {
	
	private String loginID;
	private String roleID;
	private String ipAddress;
	private Date loginTime;
	private Date logoutTime;
	private String loginStatus;
	
	public LoginLog() {}
	
	public LoginLog(LoginBean loginBean, HttpServletRequest request) {
		this.oid = loginBean.getSessionId();
		this.loginID = loginBean.getLoginID();
		this.roleID = loginBean.getRoleID();
		this.ipAddress = request.getRemoteHost();
		this.loginTime = new Date();
		this.loginStatus = Constant.LOGIN;
	}
	
	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Date getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	@Override
	public String getOid() {
		return oid;
	}

	@Override
	public void setOid(String oid) {
		this.oid = oid;
	}


	

}
