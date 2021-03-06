/**
 * 
 */
package org.domotyk.koli.action;

import java.util.List;

import org.domotyk.koli.model.Client;
import org.domotyk.koli.service.ClientService;

import com.opensymphony.xwork2.ActionSupport;



public class ClientSaver extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private  transient ClientService clientService;
	
	private Client client ;
	
	private List<Client> clients ;

	
	

	public String execute() {

		System.out.println(client.getAdresse());
		clientService.save(client); 
		
		clients= clientService.findAllClients();
		
		return SUCCESS;
	}
	
	public void validate() {
		
		
		
		
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

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Client> getClients() {
		return clients;
	}


	

}
