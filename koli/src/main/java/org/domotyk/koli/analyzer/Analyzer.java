package org.domotyk.koli.analyzer;

import java.awt.image.RasterFormatException;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import org.domotyk.koli.model.Colis;
import org.domotyk.koli.model.Message;
import org.domotyk.koli.service.ColisService;
import org.domotyk.koli.service.MessageService;
import org.domotyk.koli.service.ReclamationService;

public class Analyzer implements Runnable{
	private static final Logger logger = Logger.getLogger(Analyzer.class.getName() );
	private Colis onColis;
	private MessageService messageService;
	private ColisService colisService;
	private ReclamationService reclamationService;
	private List<java.util.Date> jourFerie;

	public Analyzer(Colis oneColis,
			MessageService messageService, ColisService colisService, ReclamationService reclamationService,
			List<java.util.Date> jourFerie) {

		this.setOnColis(oneColis);
		this.setReclamationService(reclamationService);
		this.setMessageService(messageService);
		this.setColisService(colisService);
		this.setJourFerie(jourFerie);
	}
	public  static void analyseOneColis(Colis analyzingColis,
			MessageService messageService, ColisService colisService,
			List<Date> jourFerie) {
		//validation
		analyzingColis =validator(analyzingColis,jourFerie);
		if(analyzingColis.getEtat().contains(Constant.PAN)){
			// recherche de l'image
			ImageFinder imageFinder = new ImageFinder(analyzingColis.getCode());
			
			try {

				logger.warn("Analyse du colis :" + analyzingColis.getCode());

				// l'image
				//logger.warn("Recherche de l'image pour le colis:"+ analyzingColis.getCode());
				// encodage de l'image du libéllé en code	
				Date date = imageFinder.getdate();
				String code = imageFinder.getCodeOfColisLabel();

				//logger.warn("Code trouvé de l'image :" + code);
				//logger.warn("Recherche du libelle de l'image ");

				Message message = messageService.findbyMessageId(code);

				if (message != null ) {
					//logger.warn("un libellé trouvé pour l'image:"	+ message.getLibelle());
					analyzingColis.setEtat(message.getStatus());
					// Message est un code 20 qui veux dire à analysé la date de
					// retour
					if (Constant.REC.equals(message.getStatus())) {
						//logger.warn("Le colis est recu , recherche de la date !!!");
						//logger.warn("La date trouvée est :" + date);


						// Insertion de la date

						analyzingColis.setRecieve_date(date);

						Date datePrevu=Tools.dateMaxOfColisRecieve(jourFerie,
								analyzingColis.getSend_date());

						if (Tools.compareDate(datePrevu, date)) {
							//logger.warn("colis recu dans les delais ");
							analyzingColis.setEtat(Constant.RIT);
						} else {
							//logger.warn("colis recu hors delais ");
							analyzingColis.setEtat(Constant.ROT);
						}

					} }else {
						logger.warn("Il n'y a pas de libellé pour l'image du colis :"
								+ analyzingColis.getCode());
						// Traitement du message si il ne trouve pas
						analyzingColis.setEtat(Constant.UNL);
						// enregistrement du nouveau message
						Message newMessage = new Message();
						newMessage.setId(code);
						newMessage.setStatus(Constant.UNL);
						newMessage.setLibelle(analyzingColis.getCode());
						imageFinder.saveImage();
						messageService.save(newMessage);
					}


			} catch (RasterFormatException im) {
				logger.error("erreur dans le retour des images du colis:"
						+ analyzingColis.getCode());
				analyzingColis.setEtat(Constant.ERR);

			}
			catch (Exception e) {
				// erreur dans le retour des images
				logger.error("erreur dans le retour des images du colis:"
						+ analyzingColis.getCode());
				analyzingColis.setEtat(Constant.ERR);
				e.printStackTrace();
				/*
				 * TODO catcher plus finnement les exceptions
				 */
			}
		}
		colisService.update(analyzingColis);
	}

	
public static Colis validator(Colis colis,List<Date> jourFerie) {
		
		colis.setEtat(Constant.PAN);
		
//		if ( !Tools.colisAnalizable(jourFerie, colis.getSend_date(),now)){
//			colis.setEtat(Constant.OUT);
//		}else if(!Constant.VALIDCOLISTYPE.contains(colis.getCode().substring(0, 2))
//				||colis.getNbAnalyse()>10 ){
//			colis.setEtat(Constant.ERR);
//		}
		
		return colis;

	}
	@Override
	public void run() {
		
		analyseOneColis(getOnColis(), messageService, colisService,
				jourFerie);
	}
	public Colis getOnColis() {
		return onColis;
	}
	public void setOnColis(Colis onColis) {
		this.onColis = onColis;
	}
	public MessageService getMessageService() {
		return messageService;
	}
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	public ColisService getColisService() {
		return colisService;
	}
	public void setColisService(ColisService colisService) {
		this.colisService = colisService;
	}
	public ReclamationService getReclamationService() {
		return reclamationService;
	}
	public void setReclamationService(ReclamationService reclamationService) {
		this.reclamationService = reclamationService;
	}
	public List<java.util.Date> getJourFerie() {
		return jourFerie;
	}
	public void setJourFerie(List<java.util.Date> jourFerie) {
		this.jourFerie = jourFerie;
	}
}
