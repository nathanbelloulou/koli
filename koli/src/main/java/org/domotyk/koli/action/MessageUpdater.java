/**
 * 
 */
package org.domotyk.koli.action;

import java.util.List;

import org.domotyk.koli.model.Message;
import org.domotyk.koli.service.MessageService;

import com.opensymphony.xwork2.ActionSupport;



/**
 * Acts as the controller for handling user
 * requests to edit a Message object.
 * @author nathan Belloulou
 *
 */
public class MessageUpdater extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private  transient MessageService messageService;
	
	private Message message ;
	
	private String id ;
	
	private List<Message> messages;
	
	public String input() {
		
		message = messageService.findbyMessageId(id);
		
		return INPUT ;
		
	}
	public String execute() {

		messageService.update(message);
		messages=messageService.findAllMessages();
		
		return SUCCESS;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public List<Message> getMessages() {
		return messages;
	}
	

}
