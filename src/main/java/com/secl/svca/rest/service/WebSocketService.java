package com.secl.svca.rest.service;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;

import com.secl.svca.util.SpringConfigurator;



@ServerEndpoint(value = "/websocketservice", configurator = SpringConfigurator.class)
public class WebSocketService {
	
	private Logger _logger = Logger.getLogger(this.getClass());
    public static final Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
	
	
    @OnOpen
    public void onOpen(Session session) {
        try {
            clients.add(session);
        	_logger.warn(session.getId() + " : Client is connected!!!");
        } catch(Exception e){
        	_logger.error(session.getId() + " : Client is connected!!!");
        }
    }
    
    @OnClose
    public void onClose(Session session) {
    	_logger.warn(session.getId() + " : Client is closed!!!");
        clients.remove(session);
    }
    
    @OnError
    public void onError(Session session, Throwable throwable) {
    	_logger.error("An Error occured in Client!!!");
    }
    
    @OnMessage
    public void onMessage(Session session, String msg) throws Exception {
    	try {
    		if(clients.size() <= 1) {
    			return;
    		}
    		for (Session sess : session.getOpenSessions()) {
	            if (sess.isOpen())
	            	sess.getBasicRemote().sendText(msg);
    		}
    	} catch (IOException e) {  
    		_logger.warn("An warn occured while send message to client!!!");
    	}
    }


}
















