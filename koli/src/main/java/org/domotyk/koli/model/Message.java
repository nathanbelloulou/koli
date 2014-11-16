
package org.domotyk.koli.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="message")
@NamedQuery(name="message.findByMessageId", query="from Message where id = :id")
public class Message implements Serializable {

	private static final long serialVersionUID = 3697535594187479699L;

	private String id;
	
	private String status;
	
	private String libelle;

	public void setId(String id) {
		this.id = id;
	}
	@Id
	public String getId() {
		return id;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getLibelle() {
		return libelle;
	}
	
	
	

	
	

}
