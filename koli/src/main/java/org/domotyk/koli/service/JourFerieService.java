/**
 * 
 */
package org.domotyk.koli.service;

import java.util.Date;
import java.util.List;

import org.domotyk.koli.model.JourFerie;




public interface JourFerieService {

	public JourFerie findById(Long id);
	
	public List<Date> findAllJourFerie();

	public List<JourFerie> findAllJoursFeries();
	
	public void update(JourFerie jourFerie);

	public void delete(JourFerie jourFerie);
	
	public void save(JourFerie jourFerie); 

}
