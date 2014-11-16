package org.domotyk.koli.dao;

import java.util.List;

import org.domotyk.koli.model.JourFerie;



public interface JourFerieDao {

	
	public JourFerie findById(Long id);

	public List<JourFerie> findAllJourFerie();
	
	
	public void update(JourFerie jourFerie);
	
	public void delete(JourFerie jourFerie);
	
	public void save(JourFerie JourFerie); 
	
	
}
