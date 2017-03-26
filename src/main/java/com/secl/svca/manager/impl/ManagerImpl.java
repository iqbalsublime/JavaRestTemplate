package com.secl.svca.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.secl.svca.dao.MemoryDao;
import com.secl.svca.dao.SimpleJdbcDao;
import com.secl.svca.dao.SpringJdbcDao;
import com.secl.svca.entity.AbstractEntity;
import com.secl.svca.manager.IdGenerator;
import com.secl.svca.manager.Manager;
import com.secl.svca.manager.QueryManager;
import com.secl.svca.manager.SessionManager;
import com.secl.svca.util.DataProviderUtil;
import com.secl.svca.util.MetaPropertyDataProviderUtil;
import com.secl.svca.util.ReportUtil;


public class ManagerImpl implements Manager {
	
	protected SessionManager sessionManager;
	protected QueryManager queryManager;
	protected IdGenerator idGenerator;
	protected SpringJdbcDao springJdbcDao;
    protected SimpleJdbcDao simpleJdbcDao;
    protected MemoryDao memoryDao;
    protected ReportUtil reportUtil;
    protected DataProviderUtil dataProviderUtil;
    protected MetaPropertyDataProviderUtil metaPropertyDataProviderUtil;
    protected DriverManagerDataSource dataSource;
	protected List<AbstractEntity> entityList = new ArrayList<AbstractEntity>();

	public void setIdGenerator(IdGenerator idGenerator) {
		this.idGenerator = idGenerator;
	}

	public void setSpringJdbcDao(SpringJdbcDao springJdbcDao) {
		this.springJdbcDao = springJdbcDao;
	}

	public void setSimpleJdbcDao(SimpleJdbcDao simpleJdbcDao) {
		this.simpleJdbcDao = simpleJdbcDao;
	}

	public void setQueryManager(QueryManager queryManager) {
		this.queryManager = queryManager;
	}

	public void setSessionManager(SessionManager sessionManager) {
		this.sessionManager = sessionManager;
	}

	public void setDataSource(DriverManagerDataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setReportUtil(ReportUtil reportUtil) {
		this.reportUtil = reportUtil;
	}

	public void setDataProviderUtil(DataProviderUtil dataProviderUtil) {
		this.dataProviderUtil = dataProviderUtil;
	}

	public void setMemoryDao(MemoryDao memoryDao) {
		this.memoryDao = memoryDao;
	}

	public void setMetaPropertyDataProviderUtil(MetaPropertyDataProviderUtil metaPropertyDataProviderUtil) {
		this.metaPropertyDataProviderUtil = metaPropertyDataProviderUtil;
	}


	
	

}
