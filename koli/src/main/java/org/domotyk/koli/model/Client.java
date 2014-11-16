
package org.domotyk.koli.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="client")
@NamedQuery(name="findByClientId", query="from Client where id = :id")
public class Client implements Serializable {

	private static final long serialVersionUID = 3697535594187479699L;

	private Long id;
	
	private String name;
	
	private String adresse;
	
	private String ville;
	
	private String codePostal;
	
	private String capital;
	
	private String RCS;
	
	private String gerant;
	
	private String idLaPoste;
	private String idExpeditorINET ;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getCapital() {
		return capital;
	}

	public void setRCS(String rCS) {
		RCS = rCS;
	}

	public String getRCS() {
		return RCS;
	}

	public void setGerant(String gerant) {
		this.gerant = gerant;
	}

	public String getGerant() {
		return gerant;
	}

	public void setIdLaPoste(String idLaPoste) {
		this.idLaPoste = idLaPoste;
	}

	public String getIdLaPoste() {
		return idLaPoste;
	}

	public void setIdExpeditorINET(String idExpeditorINET) {
		this.idExpeditorINET = idExpeditorINET;
	}

	public String getIdExpeditorINET() {
		return idExpeditorINET;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getVille() {
		return ville;
	}

}
