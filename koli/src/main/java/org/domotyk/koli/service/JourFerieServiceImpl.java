package org.domotyk.koli.service;


import java.util.Date;
import java.util.List;
import org.domotyk.koli.analyzer.Tools;
import org.domotyk.koli.dao.JourFerieDao;
import org.domotyk.koli.model.JourFerie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implements methods that enable interaction between a Controller and a
 * JourFerieDao.
 * 
 * @author Nathan Belloulou
 * 
 */
@Service("jourFerieService")
public class JourFerieServiceImpl implements JourFerieService {

	@Autowired
	private JourFerieDao jourFerieDao;

	public JourFerie findById(Long id) {
		return jourFerieDao.findById(id);
	}

	public JourFerieDao getJourFerieDao() {
		return jourFerieDao;
	}

	public void setJourFerieDao(JourFerieDao jourFerieDao) {
		this.jourFerieDao = jourFerieDao;
	}

	@Transactional
	public void update(JourFerie jourFerie) {
		jourFerieDao.update(jourFerie);
	}

	@Transactional
	public void delete(JourFerie jourFerie) {
		jourFerieDao.delete(jourFerie);
	}

	@Transactional
	public void save(JourFerie jourFerie) {
		jourFerieDao.save(jourFerie);
	}

	public List<Date> findAllJourFerie() {
		
		List<Date>jours=Tools.getJourFerieFr();
		List <JourFerie>jourFerie=jourFerieDao.findAllJourFerie();
		for(JourFerie jour: jourFerie){
			jours.add(jour.getDate());
		}
		return jours;
		
		
		
	}
	
public List<JourFerie> findAllJoursFeries() {
		
		return jourFerieDao.findAllJourFerie();
		
		
		
	}

	
}
