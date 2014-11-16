package org.domotyk.koli.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.domotyk.koli.model.Colis;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository("colisDao")
public class ColisDaoJpa implements ColisDao {

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Colis findById(String id) throws DataAccessException {
		Colis colis = null;
		TypedQuery<Colis> query = entityManager.createNamedQuery(
				"colis.findById", Colis.class);
		query.setParameter("id", id);
		try {
			colis = query.getSingleResult();
		} catch (javax.persistence.NoResultException ex) {
		}
		return colis;
	}

	public List<Colis> findAllColis() {
		TypedQuery<Colis> query = entityManager.createQuery("from "
				+ Colis.class.getName(), Colis.class);
		List<Colis> colis = query.getResultList();
		return colis;
	}

	public void update(Colis colis) {
		entityManager.merge(colis);
	}

	public void delete(Colis colis) {
		Colis deleteColis = entityManager.merge(colis);
		entityManager.remove(deleteColis);
	}

	public void save(Colis colis) {
		entityManager.persist(colis);
	}

	@Override
	public List<Colis> findAllColisWithStatus(String colisEtat)
			throws DataAccessException {

		List<Colis> colis = null;
		TypedQuery<Colis> query = entityManager.createQuery(
				"SELECT c FROM Colis c WHERE c.etat = ?1", Colis.class);
		query.setParameter(1, colisEtat);
		colis = query.getResultList();
		return colis;

	}

	@Override
	public List<Colis> findColisByClient(String idclient) 
		throws DataAccessException {

			List<Colis> colis = new ArrayList<Colis>();
			TypedQuery<Colis> query = entityManager.createQuery(
					"SELECT c FROM Colis c WHERE c.id_client LIKE ?1", Colis.class);
			query.setParameter(1, idclient);
			colis = query.getResultList();
			return colis;
	}

}
