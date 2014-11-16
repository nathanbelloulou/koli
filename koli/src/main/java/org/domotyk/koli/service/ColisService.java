/**
 * 
 */
package org.domotyk.koli.service;

import java.util.List;


import org.domotyk.koli.model.Colis;




public interface ColisService {

	public Colis findById(String id);

	public List<Colis> findAllColis();
	
	public List<Colis> findColisByClient(String idclient);
	
	public void update(Colis colis);

	public void delete(Colis colis);
	
	public void save(Colis colis);
	List<Colis> findAllColisWithStatus(String coliStatus); 

}
