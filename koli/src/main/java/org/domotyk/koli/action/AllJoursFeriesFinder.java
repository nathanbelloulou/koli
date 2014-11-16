/**
 * 
 */
package org.domotyk.koli.action;

import java.util.List;

import org.domotyk.koli.model.JourFerie;
import org.domotyk.koli.service.JourFerieService;

import com.opensymphony.xwork2.ActionSupport;



/**
 * Controller used to respond to user request
 * to find all date off
 * @author nbelloulou
 *
 */
public class AllJoursFeriesFinder extends ActionSupport {
	
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Collection of all
	 */
	private List<JourFerie> joursFeries;
	
	
	/**
	 */
	
	private transient JourFerieService jourFerieService;
	
	
	@Override
	public String execute() throws Exception {
		
		joursFeries =  jourFerieService.findAllJoursFeries();
		
		return SUCCESS;
		
	}


	public List<JourFerie> getJoursFeries() {
		return joursFeries;
	}

	public void setJoursFeries(List<JourFerie> joursFeries) {
		this.joursFeries = joursFeries;
	}

	public JourFerieService getJourFerieService() {
		return jourFerieService;
	}

	public void setJourFerieService(JourFerieService jourFerieService) {
		this.jourFerieService = jourFerieService;
	}

}
