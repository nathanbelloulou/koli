/**
 * 
 */
package org.domotyk.koli.action;

import org.domotyk.koli.model.Colis;
import org.domotyk.koli.service.ColisService;

import com.opensymphony.xwork2.ActionSupport;

public class ColisFinder extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String id;
	private Colis colis;

	private  transient ColisService colisService;

	@Override
	public String execute() throws Exception {
		colis = colisService.findById(id);
		return SUCCESS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Colis getColis() {
		return colis;
	}

	public void setColis(Colis colis) {
		this.colis = colis;
	}

	public ColisService getColisService() {
		return colisService;
	}
	public void setColisService(ColisService colisService) {
		this.colisService = colisService;
	}

}
