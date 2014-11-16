/**
 * 
 */
package org.domotyk.koli.action;

import java.util.List;

import org.domotyk.koli.model.Client;
import org.domotyk.koli.service.ClientService;

import com.opensymphony.xwork2.ActionSupport;



public class ClientDeleter extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private  transient ClientService clientService;
	
	private Client client ;
	
	private String id ;
	
	private List<Client> clients;
	
	
	

	public String execute() {

		client = clientService.findByClientId(Long.parseLong(id));
		clientService.delete(client); 
		clients=clientService.findAllClients();
		
		return SUCCESS;
	}

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Client> getClients() {
		return clients;
	}
	

}
