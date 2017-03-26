package com.secl.svca.manager.impl;

import com.secl.svca.manager.QueryManager;
import com.secl.svca.util.Constant;
import com.secl.svca.util.Table;

public class PostgreSqlQueryManagerImpl implements QueryManager, Constant {
	
	
	@Override
	public String getLoginSql() {
		String sql = "SELECT l.loginID, l.password, l.roleID, l.name, l.status, r.menuJSON, l.imagePath, l.lat, l.lng "
				+ "FROM "+Table.LOGIN+" l, "+Table.ROLE+" r WHERE l.roleID = r.roleID AND l.loginID = ?";
		return sql;
	}

	@Override
	public String insertLoginSql() {
		String sql = "insert into "+Table.LOGIN+"(loginID,roleID, password, status, name, imagePath, createdBy, lat, lng) " +
				"values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		return sql;
	}

	@Override
	public String insertLoginLog() {
		String sql = "insert into "+Table.LOGIN_LOG+"(oid, loginID, roleID, ipAddress, loginTime, loginStatus) " +
				"values(?, ?, ?, ?, ?, ?)";
		return sql;
	}

	@Override
	public String updateLoginLog() {
		String sql = "update "+Table.LOGIN_LOG+" set loginStatus = ?, logoutTime = ? where oid = ?";
		return sql;
	}

	@Override
	public String updateLoginPasswordSql() {
		String sql = "update "+Table.LOGIN+" set password = ?, editedOn = ?, editedBy = ? where loginID = ?";
		return sql;
	}

	/*@Override
	public String getLoginByLoginIDSql() {
		String sql = "Select loginID, password, status, roleID from Login where loginID = ?";
		return sql;
	}*/
	
	@Override
	public String getMetaPropertyByOidSQL() {
		String sql = "select * from "+Table.META_PROPERTY+" where OID = ? ";
		return sql;	
	}

	@Override
	public String getAllLoginSql() {
		String sql = "SELECT l.loginID, l.imagePath, l.roleID, l.name, l.status, r.roleDescription, r.menuJSON, l.lat, l.lng "
				+ "FROM "+Table.LOGIN+" l, "+Table.ROLE+" r WHERE l.roleID = r.roleID order by l.createdOn desc";
		return sql;
	}

	@Override
	public String getAllRoleSql() {
		String sql = "SELECT r.roleID, r.roleDescription, r.menuJSON FROM "+Table.ROLE+" r ";
		return sql;
	}

	@Override
	public String updateLoginSql() {
		String sql = "update "+Table.LOGIN+" set roleID = ?, status = ?, name = ?, "
				+ "imagePath = ?, editedBy = ?, editedOn = ?, lat = ?, lng = ? where loginID = ?";
		return sql;
	}

	@Override
	public String getAllSubscribersUserSql() {
		String sql = "select * from "+Table.SUBSCRIBER +" order by createdon desc";
		return sql;	
	}




}





