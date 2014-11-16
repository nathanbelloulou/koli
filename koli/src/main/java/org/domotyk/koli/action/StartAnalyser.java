/**
 * 
 */
package org.domotyk.koli.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.domotyk.koli.service.AnalyseService;
import org.domotyk.koli.service.ColisService;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class StartAnalyser extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private transient AnalyseService analyseService;
	private transient ColisService colisService;
	private String nbThread;
	private InputStream inputStream;
	public String execute() {
		 
		return SUCCESS;
	}
 
  public String now() throws Exception {
	 
		Gson gson = new Gson();
		
		setInputStream(new ByteArrayInputStream(gson.toJson(analyseService.now()).getBytes()));
		return SUCCESS;
	}
  
  public String switchOnOff() throws Exception {
		 
		Gson gson = new Gson();
		
		setInputStream(new ByteArrayInputStream(gson.toJson(analyseService.switchOnOff()).getBytes()));
		return SUCCESS;
	}
  
  public String getNbThread() throws Exception {
		 
		Gson gson = new Gson();
		setInputStream(new ByteArrayInputStream(gson.toJson(analyseService.getNbThread()).getBytes()));
		return SUCCESS;
	}
  public String setNbThread() throws Exception {
		 
		Gson gson = new Gson();
		System.out.println(nbThread);
		analyseService.setNbThread(Integer.parseInt(nbThread));
		setInputStream(new ByteArrayInputStream(gson.toJson(analyseService.getNbThread()).getBytes()));
		return SUCCESS;
	}
	public ColisService getColisService() {
		return colisService;
	}

	public void setColisService(ColisService colisService) {
		this.colisService = colisService;
	}

	public void setAnalyseService(AnalyseService analyseService) {
		this.analyseService = analyseService;
	}

	public AnalyseService getAnalyseService() {
		return analyseService;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public void setNbThread(String nbThread) {
		this.nbThread = nbThread;
	}



}
