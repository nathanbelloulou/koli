/**
 * 
 */
package org.domotyk.koli.action;

import org.domotyk.koli.model.Colis;
import org.domotyk.koli.service.ColisService;
import org.domotyk.koli.service.MessageService;

import com.opensymphony.xwork2.ActionSupport;

public class ColisAnalyser extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * colisoyee ID of the colis to find.
	 */
	private String id;

	private Colis colis;

	/**
	 * Provides methods to get Colis objects.
	 */
	private transient ColisService colisService;
	private transient MessageService messageService;

	@Override
	public String execute() {
		colis = colisService.findById(id);
		
	
//		ColisAnalyzerMessageImpl colisAnalyzerMessageImpl = new ColisAnalyzerMessageImpl( messageService,colisService, null);
//		colisAnalyzerMessageImpl.analyseOneColis(colis);
		colis = colisService.findById(id);

		return SUCCESS;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Colis getColis() {
		return colis;
	}

	public void setColis(Colis colis) {
		this.colis = colis;
	}

	public ColisService getColisService() {
		return colisService;
	}

	public void setColisService(ColisService colisService) {
		this.colisService = colisService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public MessageService getMessageService() {
		return messageService;
	}

}
