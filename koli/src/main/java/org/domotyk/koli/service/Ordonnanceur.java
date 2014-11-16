package org.domotyk.koli.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.domotyk.koli.analyzer.Analyzer;
import org.domotyk.koli.analyzer.Constant;
import org.domotyk.koli.model.Colis;

public class  Ordonnanceur implements Runnable {

	private static MessageService messageService;
	private static ColisService colisService;
	private static JourFerieService jourFerieService;
	private static ReclamationService reclamationService;
	private static AnalyseService analyseService;
	private static Ordonnanceur ordonnanceur;
	private static ExecutorService executor;
	private static boolean switchOnOff =false;
	private  int nbThread =25;
	public static Ordonnanceur getInstance(ReclamationService reclamationService, MessageService messageService,
			ColisService colisService, JourFerieService jourFerieService,
			AnalyseService analyseService) {

		
				if (null == ordonnanceur ) { 
					ordonnanceur = new Ordonnanceur(reclamationService, messageService,
							colisService, jourFerieService, analyseService);
				}
			
		
		return ordonnanceur;
	}

	private Ordonnanceur(ReclamationService reclamationService, MessageService messageService,
			ColisService colisService, JourFerieService jourFerieService,
			AnalyseService analyseService) {
		//instantiation unique
		setAnalyseService(analyseService);
		setMessageService(messageService);
		setColisService(colisService);
		setJourFerieService(jourFerieService);
		setReclamationService(reclamationService);
		setExecutor(Executors.newFixedThreadPool(nbThread));
	}

	private synchronized void  OrdanalyseColis() throws InterruptedException {
		
		while (true){
			if(switchOnOff){
				
		List<Colis> listColis = colisService
				.findAllColisWithStatus(Constant.INI);
		List<Date> jourFerie = jourFerieService.findAllJourFerie();
		
		for (Colis colis : listColis) {
			colis.addAnalyse();
			
				Analyzer analyzer = new Analyzer(
						colis, messageService, colisService,reclamationService, jourFerie);
				Thread colisThread = new Thread(analyzer);
				executor.submit(colisThread, "FIN " + colis.getCode());
			}
	
			}

			Thread.sleep(2000);

		}
	}

    
	

	public void run() {


		try {
			OrdanalyseColis();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setMessageService(MessageService messageService) {
		Ordonnanceur.messageService = messageService;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setColisService(ColisService colisService) {
		Ordonnanceur.colisService = colisService;
	}

	public ColisService getColisService() {
		return colisService;
	}
	public AnalyseService getAnalyseService() {
		return analyseService;
	}

	public static void setAnalyseService(AnalyseService analyseService) {
		Ordonnanceur.analyseService = analyseService;
	}

	public JourFerieService getJourFerieService() {
		return jourFerieService;
	}

	public void setJourFerieService(JourFerieService jourFerieService) {
		Ordonnanceur.jourFerieService = jourFerieService;
	}

	public static ExecutorService getExecutor() {
		return executor;
	}

	public static void setExecutor(ExecutorService executor) {
		Ordonnanceur.executor = executor;
	}

	public  boolean isSwitchOnOff() {
		return switchOnOff;
	}

	public  void setSwitchOnOff(boolean switchOnOff) {
		setExecutor(Executors.newFixedThreadPool(nbThread));
		Ordonnanceur.switchOnOff = switchOnOff;
	
		
	}

	public  int getNbThread() {
		return nbThread;
	}

	public void setNbThread(int nbThread) {
		this.nbThread = nbThread;
	}

	public static ReclamationService getReclamationService() {
		return reclamationService;
	}

	public static void setReclamationService(ReclamationService reclamationService) {
		Ordonnanceur.reclamationService = reclamationService;
	}


	
}
