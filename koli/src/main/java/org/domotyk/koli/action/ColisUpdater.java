/**
 * 
 */
package org.domotyk.koli.action;

import org.domotyk.koli.model.Colis;
import org.domotyk.koli.service.ColisService;

import com.opensymphony.xwork2.ActionSupport;



/**
 * Acts as the controller for handling user
 * requests to edit a Colis object.
 * @author nathan Belloulou
 *
 */
public class ColisUpdater extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private  transient ColisService colisService;
	
	private Colis colis ;
	
	private String id ;
	
	public String input() {
		
		colis = colisService.findById(id);
		
		return INPUT ;
		
	}
	public String execute() {

		colisService.update(colis);
		
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
