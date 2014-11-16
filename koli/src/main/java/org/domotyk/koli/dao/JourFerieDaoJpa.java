package org.domotyk.koli.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.domotyk.koli.model.JourFerie;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository("jourFerieDao")
public class JourFerieDaoJpa implements JourFerieDao {

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public JourFerie findById(Long id) throws DataAccessException {
		JourFerie jourFerie = null;
		TypedQuery<JourFerie> query = entityManager.createNamedQuery(
				"jourFerie.findById", JourFerie.class);
		query.setParameter("id", id);
		try {
			jourFerie = query.getSingleResult();
		} catch (javax.persistence.NoResultException ex) {
		}
		return jourFerie;
	}

	public List<JourFerie> findAllJourFerie() {
		TypedQuery<JourFerie> query = entityManager.createQuery("from "
				+ JourFerie.class.getName(), JourFerie.class);
		List<JourFerie> jourFerie = query.getResultList();
		return jourFerie;
	}

	public void update(JourFerie jourFerie) {
		entityManager.merge(jourFerie);
	}

	public void delete(JourFerie jourFerie) {
		JourFerie deleteJourFerie = entityManager.merge(jourFerie);
		entityManager.remove(deleteJourFerie);
	}

	public void save(JourFerie jourFerie) {
		entityManager.persist(jourFerie);
	}

}
