/**
 * 
 */
package org.domotyk.koli.action;

import java.util.List;

import org.domotyk.koli.model.Message;
import org.domotyk.koli.service.MessageService;

import com.opensymphony.xwork2.ActionSupport;



public class MessageSaver extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private  transient MessageService messageService;
	
	private Message message ;
	
	private List<Message> messages ;

	
	

	public String execute() {

		
		messageService.save(message); 
		messages= messageService.findAllMessages();
		
		return SUCCESS;
	}
	
	public void validate() {
		
		if ( message.getId().length() == 0 ){	

			addFieldError( "message.name", "L'identifiant doit etre rentrer." );
			
		}
		
		
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

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<Message> getMessages() {
		return messages;
	}


	

}
