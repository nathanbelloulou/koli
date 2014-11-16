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



public class JourFerieSaver extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String date;
	private List<JourFerie> joursFeries;

	private  transient JourFerieService jourFerieService;
	
	public JourFerieService getJourFerieService() {
		return jourFerieService;
	}




	public void setJourFerieService(JourFerieService jourFerieService) {
		this.jourFerieService = jourFerieService;
	}

	private JourFerie  jourFerie ;

	
	

	public String execute() {
		System.out.println("la date a "+date);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		ParsePosition pos = new ParsePosition(0);
		jourFerie= new JourFerie();
		jourFerie.setDate(formatter.parse(date,pos));
		jourFerieService.save(jourFerie);
		
		joursFeries=jourFerieService.findAllJoursFeries();
		return SUCCESS;
	}
	
	
	

	public JourFerie getJourFerie() {
		return jourFerie;
	}

	public void setJourFerie(JourFerie jourFerie) {
		this.jourFerie = jourFerie;
	}




	public String getDate() {
		return date;
	}




	public void setDate(String date) {
		this.date = date;
	}




	public List<JourFerie> getJoursFeries() {
		return joursFeries;
	}




	public void setJoursFeries(List<JourFerie> joursFeries) {
		this.joursFeries = joursFeries;
	}

	
	

}
