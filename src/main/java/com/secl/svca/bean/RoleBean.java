package com.secl.svca.bean;

@SuppressWarnings("serial")
public class RoleBean extends AbstractBean {
	
	private String roleID;
	private String roleDescription;
	private String menuJSON;
	private LoginBean loginBean;
	
	public RoleBean() {}
	
	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}

	public String getMenuJSON() {
		return menuJSON;
	}

	public void setMenuJSON(String menuJSON) {
		this.menuJSON = menuJSON;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	@Override
	public String getOperation() {
		return operation;
	}

	@Override
	public void setOperation(String operation) {
		this.operation = operation;
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
