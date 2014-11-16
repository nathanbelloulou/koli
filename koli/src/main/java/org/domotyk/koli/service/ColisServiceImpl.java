package org.domotyk.koli.service;

import java.util.List;

import org.domotyk.koli.dao.ColisDao;
import org.domotyk.koli.model.Colis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implements methods that enable interaction between a Controller and a
 * ColisDao.
 * 
 * @author Nathan Belloulou
 * 
 */
@Service("colisService")
public class ColisServiceImpl implements ColisService {

	@Autowired
	private ColisDao colisDao;

	public Colis findById(String id) {
		return colisDao.findById(id);
	}

	public ColisDao getColisDao() {
		return colisDao;
	}

	public void setColisDao(ColisDao colisDao) {
		this.colisDao = colisDao;
	}

	@Transactional
	public void update(Colis colis) {
		colisDao.update(colis);
	}

	@Transactional
	public void delete(Colis colis) {
		colisDao.delete(colis);
	}

	@Transactional
	public void save(Colis colis) {
		colisDao.save(colis);
	}

	public List<Colis> findAllColis() {
		return colisDao.findAllColis();
	}

	public List<Colis> findAllColisWithStatus(String coliStatus) {
		return colisDao.findAllColisWithStatus(coliStatus);
	}

	@Override
	public List<Colis> findColisByClient(String idclient) {
		
		return colisDao.findColisByClient(idclient);
	}

}
