package org.domotyk.koli.dao;

import java.util.List;

import org.domotyk.koli.model.Colis;



public interface ColisDao {
	public  List<Colis> findAllColisWithStatus(String colisEtat);
	
	public Colis findById(String id);

	public List<Colis> findAllColis();
	
	public List<Colis> findColisByClient(String idclient);
	
	public void update(Colis colis);
	
	public void delete(Colis colis);
	
	public void save(Colis Colis); 
	
	
}
