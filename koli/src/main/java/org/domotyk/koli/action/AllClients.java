/**
 * 
 */
package org.domotyk.koli.action;

import java.util.List;

import org.domotyk.koli.model.Client;
import org.domotyk.koli.service.ClientService;

import com.opensymphony.xwork2.ActionSupport;


public class AllClients extends ActionSupport {


	private static final long serialVersionUID = 1L;
	private List<Client> clients;
	private transient ClientService clientService;
	
	@Override
	public String execute() throws Exception {
		
		clients= clientService.findAllClients();
		
		return SUCCESS;
		
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public ClientService getClientService() {
		return clientService;
	}

}
