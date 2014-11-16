/**
 * 
 */
package org.domotyk.koli.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.domotyk.koli.generator.DocFile;
import org.domotyk.koli.model.Client;
import org.domotyk.koli.service.ClientService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class ClientIhm extends ActionSupport {

	private transient static final long serialVersionUID = 1L;
	private Client client;
	private List<Client> clients;
	private transient ClientService clientService;
	private List<String> nom;
	private String id;
	private InputStream inputStream;
	public InputStream getInputStream() {
		return inputStream;
	}

	public String execute() throws Exception {
	
		try {
			client =clientService.findByClientId(Long.valueOf(id));
		} catch (Exception e) {
			System.out.println(" recherche de id "+id+" impossible");
		}
		client =clientService.findByClientId(Long.valueOf(id));
		Gson gson = new Gson();
		
		inputStream = new ByteArrayInputStream(gson.toJson(client).getBytes());
		return SUCCESS;
	}
	
	public String generateContrat() throws Exception {
		System.out.println(" generateContrat du client " + id + " ");
		client = clientService.findByClientId(Long.valueOf(id));
		inputStream = DocFile.generateContrat(client);
		return SUCCESS;
	}

	public String generateFicheInfo() throws Exception {
		System.out.println(" generateFicheInfo du client " + id + " ");
		client = clientService.findByClientId(Long.valueOf(id));
		inputStream = DocFile.generateFicheInfo(client);
		return SUCCESS;
	}
	

	public String result() throws Exception {
		setClients(clientService.findAllClients());
		return SUCCESS;
	}

	public List<String> getNom() {
		return nom;
	}

	public void setNom(List<String> nom) {
		this.nom = nom;
	}

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
