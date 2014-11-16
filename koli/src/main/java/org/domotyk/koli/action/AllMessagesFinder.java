/**
 * 
 */
package org.domotyk.koli.action;

import java.util.List;

import org.domotyk.koli.model.Message;
import org.domotyk.koli.service.MessageService;

import com.opensymphony.xwork2.ActionSupport;



/**
 * Controller used to respond to user request
 * to find all message
 * @author nbelloulou
 *
 */
public class AllMessagesFinder extends ActionSupport {
	
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Collection of all messages.
	 */
	private List<Message> messages;
	
	
	/**
	 * Provides methods to get Message objects.
	 */
	
	private transient MessageService messageService;
	
	
	@Override
	public String execute() throws Exception {
		
		messages = messageService.findAllMessages();
		
		return SUCCESS;
		
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

}
