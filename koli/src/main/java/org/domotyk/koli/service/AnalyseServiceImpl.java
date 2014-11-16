package org.domotyk.koli.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implements methods that enable interaction between a Controller and a
 * AnalyseDao.
 * 
 * @author Nathan Belloulou
 * 
 */
@Service("analyseService")
public class AnalyseServiceImpl implements AnalyseService {

	
	private Ordonnanceur ordonnanceur =null;
	@Autowired
	private MessageService messageService;

	@Autowired
	private ColisService colisService;

	@Autowired
	private JourFerieService jourFerieService;
	
	@Autowired
	private ReclamationService reclamationService;

public boolean now(){
	if(ordonnanceur==null){
		setOrdonnanceur(Ordonnanceur.getInstance(reclamationService,messageService, colisService, jourFerieService, this));
		Thread ordonnanceurThread = new Thread(ordonnanceur);
		System.out.println("etat de l'ordonnanceur:"+ordonnanceur.isSwitchOnOff());
		ordonnanceurThread.start();	
	}
	
	return ordonnanceur.isSwitchOnOff();
	
}
	public boolean switchOnOff() {
		System.out.println("switch");
			ordonnanceur.setSwitchOnOff(!now());
		return now();
	}
	
	
	public Ordonnanceur getOrdonnanceur() {
		return ordonnanceur;
	}
	public void setOrdonnanceur(Ordonnanceur ordonnanceur) {
		this.ordonnanceur = ordonnanceur;
	}
	public void setJourFerieService(JourFerieService jourFerieService) {
		this.jourFerieService = jourFerieService;
	}

	public JourFerieService getJourFerieService() {
		return jourFerieService;
	}
	
	public void setNbThread(int nbThread) {
		setOrdonnanceur(Ordonnanceur.getInstance(reclamationService,messageService, colisService, jourFerieService, this));
		ordonnanceur.setNbThread(nbThread);
	}

	public int getNbThread() {
		setOrdonnanceur(Ordonnanceur.getInstance(reclamationService,messageService, colisService, jourFerieService, this));
		return ordonnanceur.getNbThread();
	}	

}
