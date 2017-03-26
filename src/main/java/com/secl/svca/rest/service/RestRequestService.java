package com.secl.svca.rest.service;

import java.util.UUID;

import org.apache.log4j.Logger;

import com.secl.svca.util.Constant;
import com.secl.svca.util.RestClient;
import com.secl.svca.util.RestClient.RequestMethod;




public class RestRequestService implements Constant  {
	
	
	private Logger _logger = Logger.getLogger(this.getClass());
	private String baseUrl;
	private RestClient restClient;
	
	public String addBalance(String url, String partnerID) {
		String response = null;
		try {
			restClient.setUrl(baseUrl + url);
			restClient.AddHeader("Content-Type", CONTENT_TYPE);
			restClient.AddParam("requestID", UUID.randomUUID().toString());
			restClient.AddParam("partnerID", partnerID);
			restClient.AddParam("operationType", "addBalance");
			restClient.Execute(RequestMethod.POST);
			response = restClient.getResponse();
		} catch (Exception e) {
			_logger.error("An Exception occured while add Balance for : "+partnerID, e);
		}
		return response;
	}

	
	// Setter for Spring DI
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public void setRestClient(RestClient restClient) {
		this.restClient = restClient;
	}
	
}












