package org.domotyk.koli.dao;

import java.util.List;

import org.domotyk.koli.model.Client;



public interface ClientDao {
	
	public Client findByClientId(Long id);

	public List<Client> findAllClients();
	
	public void update(Client client);
	
	public void delete(Client client);
	
	public void save(Client Client);

	
}
