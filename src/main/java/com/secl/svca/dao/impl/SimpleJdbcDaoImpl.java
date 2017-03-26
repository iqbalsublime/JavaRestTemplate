package com.secl.svca.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.cglib.beans.BeanMap;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.secl.svca.dao.SimpleJdbcDao;

public class SimpleJdbcDaoImpl extends SimpleJdbcDaoSupport implements SimpleJdbcDao {

    @SuppressWarnings("rawtypes")
    public void saveObjectList(String sql, List entityList) throws Exception {
        try {
            //String sql = "INSERT INTO CUSTOMER (CUST_ID, NAME, AGE) VALUES (:custId, :name, :age)";
            SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(entityList.toArray());             
            getSimpleJdbcTemplate().batchUpdate(sql, params);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
	
	@SuppressWarnings("unchecked")
	private HashMap<String, Object> getBeanMap(Object obj) {
		HashMap<String, Object> map = new HashMap<>();
		map.putAll(BeanMap.create(obj));
		return map;
	}
	
	@Override
	public boolean saveObject(Object obj, String tableName) {
		HashMap<String, Object> map = getBeanMap(obj);
		SimpleJdbcInsert simpleInsert = new SimpleJdbcInsert(getJdbcTemplate());
		simpleInsert.setTableName(tableName);
		int rowsInserted = simpleInsert.execute(map);
		return rowsInserted == 1;
	}
    
}
