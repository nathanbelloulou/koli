
package org.domotyk.koli.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;




@Entity
@Table(name="jourferie")
@NamedQuery(name="jourFerie.findById", query="from JourFerie where id = :id")

public class JourFerie implements Serializable {


	public JourFerie() {
	}
	private static final long serialVersionUID = 1L;
	private Date  date;
	private Long id;
	
	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public JourFerie(Date date1){
		this.date=date1;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
}
