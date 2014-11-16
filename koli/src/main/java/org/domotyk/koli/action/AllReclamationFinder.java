/**
 * 
 */
package org.domotyk.koli.action;

import java.util.List;

import org.domotyk.koli.model.Reclamation;
import org.domotyk.koli.service.ReclamationService;

import com.opensymphony.xwork2.ActionSupport;



/**
 * Controller used to respond to user request
 * to find all colis
 * @author nbelloulou
 *
 */
public class AllReclamationFinder extends ActionSupport {
	
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Collection of all analyses.
	 */
	private List<Reclamation> reclamations;
	
	
	
	
	private transient ReclamationService reclamationService;
	
	
	@Override
	public String execute() throws Exception {
		reclamations =reclamationService.findAllReclamation();
		
		return SUCCESS;
		
	}

	public List<Reclamation> getReclamations() {
		return reclamations;
	}

	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

	public ReclamationService getReclamationService() {
		return reclamationService;
	}

	public void setReclamationService(ReclamationService reclamationService) {
		this.reclamationService = reclamationService;
	}

}
