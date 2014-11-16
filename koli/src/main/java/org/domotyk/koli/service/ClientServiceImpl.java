package org.domotyk.koli.service;


import java.util.List;


import org.domotyk.koli.dao.ClientDao;
import org.domotyk.koli.model.Client;
import org.domotyk.koli.model.Colis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implements methods that enable interaction between a Controller and a
 * ClientDao.
 * 
 * @author Nathan Belloulou
 * 
 */
@Service("clientService")
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDao clientDao;
	@Autowired
	private ColisService colisService;
	@Autowired
	private MessageService messageService;
	
	private List<Colis> colis;

	public List<Colis> getColis() {
		return colis;
	}

	public void setColis(List<Colis> colis) {
		this.colis = colis;
	}

	public Client findByClientId(Long id) {
		return clientDao.findByClientId(id);
	}

	public ClientDao getClientDao() {
		return clientDao;
	}

	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@Transactional
	public void update(Client client) {
		clientDao.update(client);
	}

	@Transactional
	public void delete(Client client) {
		clientDao.delete(client);
	}

	@Transactional
	public void save(Client client) {
		
		clientDao.save(client);
	}

	public List<Client> findAllClients() {
		return clientDao.findAllClients();
	}


	@Override
	public void insertClientColis(List<Colis> colis) {
		
		
	}

	public void setColisService(ColisService colisService) {
		this.colisService = colisService;
	}

	public ColisService getColisService() {
		return colisService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	


}
