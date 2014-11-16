package org.domotyk.koli.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.domotyk.koli.model.Reclamation;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository("reclamationDao")
public class ReclamationDaoJpa implements ReclamationDao {

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Reclamation findById(Long id) throws DataAccessException {
		Reclamation reclamation = null;
		TypedQuery<Reclamation> query = entityManager.createNamedQuery(
				"reclamation.findById", Reclamation.class);
		query.setParameter("id", id);
		try {
			reclamation = query.getSingleResult();
		} catch (javax.persistence.NoResultException ex) {
		}
		return reclamation;
	}

	public List<Reclamation> findAllReclamation() {
		TypedQuery<Reclamation> query = entityManager.createQuery("from "
				+ Reclamation.class.getName(), Reclamation.class);
		List<Reclamation> reclamation = query.getResultList();
		return reclamation;
	}

	public void update(Reclamation reclamation) {
		entityManager.merge(reclamation);
	}

	public void delete(Reclamation reclamation) {
		Reclamation deleteReclamation = entityManager.merge(reclamation);
		entityManager.remove(deleteReclamation);
	}




	@Override
	public void save(Reclamation reclamation) {
		entityManager.persist(reclamation);
		
	}

	
	

}
