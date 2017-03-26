package com.secl.svca.manager;


import com.secl.svca.bean.ResponseBean;
import com.secl.svca.bean.SubscribersBean;



public interface SubscriberManager extends Manager {
	
	public ResponseBean getAllSubscribers(ResponseBean response, SubscribersBean model);
	
}
