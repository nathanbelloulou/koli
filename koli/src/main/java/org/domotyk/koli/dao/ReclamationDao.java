package org.domotyk.koli.dao;

import java.util.List;

import org.domotyk.koli.model.Reclamation;



public interface ReclamationDao {
	
	public Reclamation findById(Long id);

	public List<Reclamation> findAllReclamation();
		
	public void update(Reclamation reclamation);
	
	public void delete(Reclamation reclamation);
	
	public void save(Reclamation reclamation); 
	
	
}
