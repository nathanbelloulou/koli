/**
 * 
 */
package org.domotyk.koli.service;

import java.util.List;


import org.domotyk.koli.model.Client;
import org.domotyk.koli.model.Colis;




public interface ClientService {

	public Client findByClientId(Long id);
	
	public void insertClientColis(List<Colis> colis);

	public List<Client> findAllClients();
	
	public void update(Client client);

	public void delete(Client client);
	
	public void save(Client client);

}
