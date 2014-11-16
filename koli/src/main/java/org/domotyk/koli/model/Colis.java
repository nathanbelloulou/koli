
package org.domotyk.koli.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name="colis")
@NamedQuery(name="colis.findById", query="from Colis where id = :id")

public class Colis implements Serializable {

	private static final long serialVersionUID = 3697535594187479699L;

	private Long id;
	
	private String code;
	
	private String etat;
	
	private String name;
	
	private Date  send_date;
	
	private Date  recieve_date;
	
	private String  id_client;
	

	private int nbAnalyse;
//	@ManyToOne
//	private Reclamation reclamation_id;
	
	@Override
	public String toString() {
		return "Colis [id=" + id + ", etat=" + etat
				+ ", name=" + name + "]";
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((etat== null) ? 0 : etat.hashCode());
		result = prime * result
				+ ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colis other = (Colis) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!etat.equals(other.etat))
			return false;
		if (etat == null) {
			if (other.etat != null)
				return false;
		} 
		return true;
	}



	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}

	public Date getSend_date() {
		return send_date;
	}

	public void setRecieve_date(Date recieve_date) {
		this.recieve_date = recieve_date;
	}

	public Date getRecieve_date() {
		return recieve_date;
	}


	public void setId_client(String id_client) {
		this.id_client = id_client;
	}

	public String getId_client() {
		return id_client;
	}

	public void setNbAnalyse(int nbAnalyse) {
		this.nbAnalyse = nbAnalyse;
	}

	public int getNbAnalyse() {
		return nbAnalyse;
	}
	public int addAnalyse() {
		this.setNbAnalyse(getNbAnalyse()+1);
		return getNbAnalyse();
	}
//	@ManyToOne
//	public Reclamation getReclamation() {
//		return reclamation_id;
//	}
//
//	public void setReclamation(Reclamation reclamation) {
//		this.reclamation_id = reclamation;
//	}

}
