/**
 * 
 */
package org.domotyk.koli.action;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.List;

import org.domotyk.koli.model.JourFerie;
import org.domotyk.koli.service.JourFerieService;

import com.opensymphony.xwork2.ActionSupport;



/**
 * Acts as the controller for handling user
 * requests to edit a JourFerie object.
 * @author nathan Belloulou
 *
 */
public class JourFerieUpdater extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private  transient JourFerieService jourFerieService;
	
	private JourFerie jourFerie ;
	
	private String date;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	private Long id ;
	
	private List<JourFerie> joursFeries;
	
	public String input() {
		
		jourFerie = jourFerieService.findById(id);
		
		return INPUT ;
		
	}
	public String execute() {
		System.out.println("la date a "+date);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		ParsePosition pos = new ParsePosition(0);
		jourFerie.setDate(formatter.parse(date,pos));

		jourFerieService.update(jourFerie);
		joursFeries=jourFerieService.findAllJoursFeries();
		
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
