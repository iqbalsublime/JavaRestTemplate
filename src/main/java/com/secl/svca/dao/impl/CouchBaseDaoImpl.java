package com.secl.svca.dao.impl;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.couchbase.client.CouchbaseClient;
import com.secl.svca.dao.MemoryDao;


public class CouchBaseDaoImpl implements MemoryDao {

	private Logger _logger = Logger.getLogger(this.getClass());
	private CouchbaseClient client;
	private String couchUrl;
	private String couchBucket;
	private String couchPassword;
	private String couchViewMode;
	
	public void init() {
		try {
			List<URI> hosts = Arrays.asList(new URI(couchUrl));
			System.setProperty("viewmode", couchViewMode);
			client = new CouchbaseClient(hosts, couchBucket, couchPassword);
			_logger.info("Couchbase connect");
		} catch (Exception e) {
			_logger.error("Unable to connect Couchbase!!!");
			client = null;
			throw new IllegalStateException(e);
		}
	}

	public void destroy() {
		if (client != null) {
			client.shutdown();
			client = null;
			_logger.warn("Couchbase connection closing!!!");
		}
	}

	
	// Setter
	public void setCouchUrl(String couchUrl) {
		this.couchUrl = couchUrl;
	}

	public void setCouchBucket(String couchBucket) {
		this.couchBucket = couchBucket;
	}

	public void setCouchPassword(String couchPassword) {
		this.couchPassword = couchPassword;
	}

	public void setCouchViewMode(String couchViewMode) {
		this.couchViewMode = couchViewMode;
	}

	
	
	
}




