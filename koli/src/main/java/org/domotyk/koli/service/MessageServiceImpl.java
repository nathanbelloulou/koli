/**
 * 
 */
package org.domotyk.koli.service;

import java.util.List;

import org.domotyk.koli.dao.MessageDao;
import org.domotyk.koli.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("messageService")
public class MessageServiceImpl implements MessageService {
	
	 @Autowired
	 private MessageDao messageDao;

	public Message findbyMessageId(String id) {
		
		return messageDao.findbyMessageId(id);
		
	}

	public MessageDao getPersonDao() {
		return messageDao;
	}

	public void setPersonDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}


	public List<Message> findAllMessages() {
		
		return messageDao.findAllMessages() ;
		
		
	}


	@Transactional
	public void update(Message message) {
	
		messageDao.update(message);
		
	}


	@Transactional
	public void delete(Message message) {
		
		messageDao.delete(message);

	}


	@Transactional
	public void save(Message message) {
	
		messageDao.save(message);
		
		
	}
	
	

}
