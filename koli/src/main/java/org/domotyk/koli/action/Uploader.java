/**
 * 
 */
package org.domotyk.koli.action;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.domotyk.koli.analyzer.Constant;
import org.domotyk.koli.analyzer.ReadExcel;
import org.domotyk.koli.model.Client;
import org.domotyk.koli.model.Colis;
import org.domotyk.koli.service.ClientService;
import org.domotyk.koli.service.ColisService;

import com.opensymphony.xwork2.ActionSupport;

public class Uploader  extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private File upload;//The actual file
	private String uploadContentType; //The content type of the file
	private String uploadFileName; //The uploaded file name
	private String fileCaption;//The caption o
	private List<Colis> coliss;
	private String id;
	private Client client;

	private transient ColisService colisService;
	private transient ClientService clientService;
	
	public String importer() {
		
	
		
		return INPUT ;
		
	}
	@Override
	public String execute() throws Exception {
		//Traitement du fichier importer
		coliss= new ArrayList<Colis>();
		File theFile = new File("import.xls");
		FileUtils.copyFile(upload, theFile);
		ReadExcel test = new ReadExcel();  
		test.setInputFile(upload); 
		//maping avec l'objet colis
		coliss= test.read();
		for(Colis colis:coliss){
			colis.setId(null);
			colis.setEtat(Constant.INI);
			colis.setId_client(id);
			colis.setNbAnalyse(0);
			colisService.save(colis);
		}

		// client =clientService.findByClientId(Long.parseLong(id));

		
		return SUCCESS;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public File getUpload() {
		return upload;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setFileCaption(String fileCaption) {
		this.fileCaption = fileCaption;
	}

	public String getFileCaption() {
		return fileCaption;
	}

	public void setColisService(ColisService colisService) {
		this.colisService = colisService;
	}

	public ColisService getColisService() {
		return colisService;
	}

	public void setColiss(List<Colis> coliss) {
		this.coliss = coliss;
	}

	public List<Colis> getColiss() {
		return coliss;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Client getClient() {
		return client;
	}
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}
	public ClientService getClientService() {
		return clientService;
	}

}
