/**
 * 
 */
package org.domotyk.koli.action;

import java.util.ArrayList;
import java.util.List;

import org.domotyk.koli.model.Client;
import org.domotyk.koli.model.Colis;
import org.domotyk.koli.service.ClientService;
import org.domotyk.koli.service.ColisService;

import com.opensymphony.xwork2.ActionSupport;


public class AllColisFinder extends ActionSupport {
	
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Collection of all coliss.
	 */
	private List<Colis> coliss;
	private List<Colis> colis;
	private Client client;
	private String  id;
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Provides methods to get Colis objects.
	 */
	
	private transient ColisService colisService;
	
	private transient ClientService clientService;
	@Override
	public String execute() throws Exception {
		coliss= new ArrayList<Colis>();
		colis = colisService.findAllColis();
		for(Colis col:colis){
		col.setEtat(org.domotyk.koli.analyzer.Constant.ColisEtat.get(col.getEtat()));
			coliss.add(col);
		}
		return SUCCESS;
		
	}
	

	public String executeSeleted() throws Exception {
		
		coliss = colisService.findColisByClient(id);
		
		setClient(clientService.findByClientId(Long.parseLong(id))); 
		
		return SUCCESS;
		
	}

	public List<Colis> getColiss() {
		return coliss;
	}

	public void setColiss(List<Colis> coliss) {
		this.coliss = coliss;
	}

	public ColisService getColisService() {
		return colisService;
	}

	public void setColisService(ColisService colisService) {
		this.colisService = colisService;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Client getClient() {
		return client;
	}


	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}


	public ClientService getClientService() {
		return clientService;
	}


	public List<Colis> getColis() {
		return colis;
	}


	public void setColis(List<Colis> colis) {
		this.colis = colis;
	}

}
