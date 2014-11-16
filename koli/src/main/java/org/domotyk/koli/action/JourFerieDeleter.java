/**
 * 
 */
package org.domotyk.koli.action;

import java.util.List;

import org.domotyk.koli.model.JourFerie;
import org.domotyk.koli.service.JourFerieService;

import com.opensymphony.xwork2.ActionSupport;



public class JourFerieDeleter extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private  transient JourFerieService jourFerieService;
	
	private JourFerie jourFerie ;
	
	private Long id ;
	
	private List<JourFerie> joursFeries;
	
	

	public String execute() {
		System.out.println(" identifiant"+id);

		jourFerie = jourFerieService.findById(id);
		jourFerieService.delete(jourFerie); 
		setJoursFeries(jourFerieService.findAllJoursFeries());
		return SUCCESS;
	}

	public JourFerieService getJourFerieService() {
		return jourFerieService;
	}

	public void setJourFerieService(JourFerieService jourFerieService) {
		this.jourFerieService = jourFerieService;
	}

	public JourFerie getJourFerie() {
		return jourFerie;
	}

	public void setJourFerie(JourFerie jourFerie) {
		this.jourFerie = jourFerie;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setJoursFeries(List<JourFerie> joursFeries) {
		this.joursFeries = joursFeries;
	}

	public List<JourFerie> getJoursFeries() {
		return joursFeries;
	}


	

}
