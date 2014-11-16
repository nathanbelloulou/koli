
package org.domotyk.koli.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="reclamation")
@NamedQuery(name="reclamation.findById", query="from Reclamation where id = :id")
public class Reclamation implements Serializable {

	private static final long serialVersionUID = 3697535594187479699L;

	private Long id;
	private List<Colis> colis;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	@OneToMany
	public List<Colis> getColis() {
		return colis;
	}

	public void setColis(List<Colis> colis) {
		this.colis = colis;
	}

}
