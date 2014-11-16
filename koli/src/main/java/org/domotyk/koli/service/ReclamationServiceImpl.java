package org.domotyk.koli.service;

import java.util.List;
import org.domotyk.koli.dao.ReclamationDao;
import org.domotyk.koli.model.Reclamation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implements methods that enable interaction between a Controller and a
 * AnalyseDao.
 * 
 * @author Nathan Belloulou
 * 
 */
@Service("reclamationService")
public class ReclamationServiceImpl implements ReclamationService {

	@Autowired
	private ReclamationDao reclamationDao;

	
	@Transactional
	public void update(Reclamation reclamation ) {
		reclamationDao.update(reclamation);
	}

	@Transactional
	public void delete(Reclamation reclamation) {
		reclamationDao.delete(reclamation);
	}

	

	@Override
	public List<Reclamation> findAllReclamation() {
return reclamationDao.findAllReclamation();
	}

	@Transactional
	public void save(Reclamation reclamation) {
		reclamationDao.save(reclamation);		
	}

	public ReclamationDao getReclamationDao() {
		return reclamationDao;
	}

	public void setReclamationDao(ReclamationDao reclamationDao) {
		this.reclamationDao = reclamationDao;
	}

	@Override
	public Reclamation findById(Long id) {
return reclamationDao.findById(id);
	}

}
