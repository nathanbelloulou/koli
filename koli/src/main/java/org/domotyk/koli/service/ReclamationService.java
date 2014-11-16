/**
 * 
 */
package org.domotyk.koli.service;

import java.util.List;

import org.domotyk.koli.model.Reclamation;




public interface ReclamationService {

	public Reclamation findById(Long id);

	public List<Reclamation> findAllReclamation();
	
	public void save(Reclamation reclamation);
	public void update(Reclamation reclamation );
	public void delete(Reclamation reclamation);

}
