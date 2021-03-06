package org.domotyk.koli.dao;

import java.util.List;

import org.domotyk.koli.model.Message;

public interface MessageDao {
	
	public Message findbyMessageId(String id);
	
	public List<Message> findAllMessages();

	public void update(Message message);

	public void delete(Message message);
	
	public void save(Message message); 
	
	
}
