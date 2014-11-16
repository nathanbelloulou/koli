package org.domotyk.koli.generator;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;

import org.domotyk.koli.model.Client;

import word.utils.Utils;

public class DocFile {
	public static InputStream generateFicheInfo(Client client){
	String xmlTemplate = Utils.readFile("modeles/ficheinformation.doc");
    
    xmlTemplate = replacePh(xmlTemplate, "phraisonsocial", "EasyWorld - coding for fun pty");
    xmlTemplate = replacePh(xmlTemplate, "phEnv", "Production");
    xmlTemplate = replacePh(xmlTemplate, "phProjectName", "Production");
     xmlTemplate = replacePh(xmlTemplate, "phVersion", "1.0 beta");
    xmlTemplate = replacePh(xmlTemplate, "phProjectLeader", "Leonardo Correa");
    
//   
    xmlTemplate = replacePh(xmlTemplate, "phDateTime", new Date().toString());
    

    
    InputStream fileInputStream = new ByteArrayInputStream(xmlTemplate.getBytes());
   
    
	return fileInputStream;
}
	public static InputStream generateContrat(Client client){
	String xmlTemplate = Utils.readFile("modeles/contratdeservice.doc");
    
    xmlTemplate = replacePh(xmlTemplate, "phraisonsocial", "EasyWorld - coding for fun pty");
    xmlTemplate = replacePh(xmlTemplate, "phEnv", "Production");
    xmlTemplate = replacePh(xmlTemplate, "phProjectName", "Production");
     xmlTemplate = replacePh(xmlTemplate, "phVersion", "1.0 beta");
    xmlTemplate = replacePh(xmlTemplate, "phProjectLeader", "Leonardo Correa");
    
//   
    xmlTemplate = replacePh(xmlTemplate, "phDateTime", new Date().toString());
    

    
    InputStream fileInputStream = new ByteArrayInputStream(xmlTemplate.getBytes());
   
    
	return fileInputStream;
}
	private static String replacePh(String base, String placeHolder, String value) {
        if(!base.contains(placeHolder)) {
            //don't want to use log now because I want to keep it simple...
            System.out.println("### WARN: couldn't find the place holder: " + placeHolder);
            return base;
        }        
        return base.replace(placeHolder, value);
    }

}