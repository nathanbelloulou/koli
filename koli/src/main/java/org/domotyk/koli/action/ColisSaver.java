/**
 * 
 */
package org.domotyk.koli.action;

import org.domotyk.koli.model.Colis;
import org.domotyk.koli.service.ColisService;

import com.opensymphony.xwork2.ActionSupport;



public class ColisSaver extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private  transient ColisService colisService;
	
	private Colis colis ;

	
	

	public String execute() {

		
		colisService.save(colis); 
		
		return SUCCESS;
	}
	
	public void validate() {
		
		if ( colis.getName().length() == 0 ){	

			addFieldError( "colis.name", "Le nom doit etre rentrer." );
			
		}
		
		
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


	

}
