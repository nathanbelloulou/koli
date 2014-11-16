/**
 * 
 */
package org.domotyk.koli.action;

import org.domotyk.koli.model.Colis;
import org.domotyk.koli.service.ColisService;

import com.opensymphony.xwork2.ActionSupport;



/**
 * Acts as the controller for handling user
 * requests to delete a Colis object.
 * @author brucephillips
 *
 */
public class ColisDeleter extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private  transient ColisService colisService;
	
	private Colis colis ;
	
	private String id ;
	
	
	
	
	/**
	 * Use emplid provided in the user's 
	 * request to find the Colis 
	 * object and then delete that Colis's
	 * record.
	 */
	public String execute() {

		colis = colisService.findById(id);
		
		colisService.delete(colis); 
		
		return SUCCESS;
	}

	public ColisService getColisService() {
		return colisService;
	}

	public void setColisService(ColisService colisService) {
		this.colisService = colisService;
	}

	public Colis getColis() {
		return colis;
	}

	public void setColis(Colis colis) {
		this.colis = colis;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

}
