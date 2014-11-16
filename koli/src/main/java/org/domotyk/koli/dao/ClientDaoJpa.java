package org.domotyk.koli.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import org.domotyk.koli.model.Client;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;



@Repository("clientDao")
public class ClientDaoJpa implements ClientDao {

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Client findByClientId(Long id) throws DataAccessException{
		Client client= null;
		TypedQuery<Client> query = entityManager.createNamedQuery("findByClientId", Client.class);
		query.setParameter("id", id);
		try {
			client = query.getSingleResult() ;
		}
		catch (javax.persistence.NoResultException ex){
		}
		return client;
	}


	public List<Client> findAllClients() {
		TypedQuery<Client> query = entityManager.createQuery("from " + Client.class.getName(), Client.class);
		List<Client> clients = query.getResultList();
		return clients;
	}

	public void update(Client client) {
		entityManager.merge(client);
	}
	
	public void delete(Client client) {
		Client deleteClient = entityManager.merge(client);
		entityManager.remove(deleteClient);
	}

	public void save(Client client) {
		System.out.println("t2"+client.getAdresse());
		entityManager.persist(client);
	}

}
