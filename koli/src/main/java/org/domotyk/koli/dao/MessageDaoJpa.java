package org.domotyk.koli.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import org.domotyk.koli.model.Message;


@Repository("messageDao")
public class MessageDaoJpa implements MessageDao {
	
	private static final Logger logger = Logger.getLogger(MessageDaoJpa.class.getName() );
	
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	public Message findbyMessageId(String id) throws DataAccessException {
		Message message = null ;
		TypedQuery<Message> query =  entityManager.createNamedQuery("message.findByMessageId", Message.class);
		query.setParameter("id", id);
		
		try {
			message = query.getSingleResult() ;
		} catch (javax.persistence.NoResultException ex) {
			logger.warn("logs " + id);
		}
		return message;
	}



	public List<Message> findAllMessages() {
		TypedQuery<Message> query = entityManager.createQuery("from " + Message.class.getName(), Message.class);
		List<Message> lists = query.getResultList();
		return lists;
	}


	public void update(Message message) {
		entityManager.merge(message);	
	}

	
	public void delete(Message message) {
		Message deletePerson = entityManager.merge(message);
		entityManager.remove(deletePerson);
	}

	public void save(Message message) {
		entityManager.persist(message);
	}


	

}
