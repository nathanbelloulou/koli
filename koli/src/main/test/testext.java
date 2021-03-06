import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.util.StringTokenizer;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import word.api.interfaces.IDocument;
import word.utils.TestUtils;
import word.utils.Utils;
import word.w2004.elements.Paragraph;
import word.w2004.elements.Table;
import word.w2004.elements.tableElements.TableEle;
import word.*;


public class testext {

	
	
	
	public void analyseDateSimple() throws Exception {
		
		BufferedReader entree = new BufferedReader(new FileReader ("contrat.doc"));
		BufferedWriter sorti = new BufferedWriter(new FileWriter ("contrKat.doc"));
		String ligne = entree.readLine();
		
		while (ligne != null) {	
				
			if(ligne.contains("societeClient ,"))
				System.out.println(ligne);
					sorti.write(ligne);
			
			ligne = entree.readLine();
		} 
		entree.close();
	 sorti.close();
	    }
	
	@Test
    public void testTemplate() {
        String xmlTemplate = Utils.readFile("test/ReleaseNotesTemplate.xml");
        
        xmlTemplate = replacePh(xmlTemplate, "phCompanyName", "EasyWorld - coding for fun pty");
        xmlTemplate = replacePh(xmlTemplate, "phEnv", "Production");
        xmlTemplate = replacePh(xmlTemplate, "phProjectName", "Production");
         xmlTemplate = replacePh(xmlTemplate, "phVersion", "1.0 beta");
        xmlTemplate = replacePh(xmlTemplate, "phProjectLeader", "Leonardo Correa");
        
//        Table tbl = new Table();
//        tbl.addTableEle(TableEle.TH, "Jira Number", "Description");
//
//        tbl.addTableEle(TableEle.TD, "J2W-1234", "Read Templates nicelly");
//        tbl.addTableEle(TableEle.TD, "J2W-9999", "Make Java2word funky!!!");
//
//        xmlTemplate = replacePh(xmlTemplate, "phTableIssues", tbl.getContent());
//        
//        Paragraph p01 = Paragraph.with("1) Stop the server").create();
//        Paragraph p02 = Paragraph.with("2) Run the script to deploy the app xxx").create();
//        Paragraph p03 = Paragraph.with("3) Start the server").create();
//        Paragraph p04 = Paragraph.with("4) Hope for the best").create();
//        
//        String instructions = p01.getContent() + p02.getContent() + p03.getContent() + p04.getContent();
//        
//        //Workaround: phInstructions is already inside a 'text' fragment. 
//        //If you know the template, you can remove the whole element and add all Paragraphs
//        //* Table above doesn't need workaround because table can be normally inside a paragraph.
//        xmlTemplate = replacePh(xmlTemplate, "<w:t>phInstructions</w:t>", instructions); 
//        
        xmlTemplate = replacePh(xmlTemplate, "phDateTime", new Date().toString());
        
        File fileObj = new File("testnb.doc");

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(fileObj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        writer.println(xmlTemplate);
        writer.close();
      
    }
	private String replacePh(String base, String placeHolder, String value) {
        if(!base.contains(placeHolder)) {
            //don't want to use log now because I want to keep it simple...
            System.out.println("### WARN: couldn't find the place holder: " + placeHolder);
            return base;
        }        
        return base.replace(placeHolder, value);
    }
	@Test
	  public void testTemplate2() {
        String xmlTemplate = Utils.readFile("modeles/test.xml");
        
        xmlTemplate = replacePh(xmlTemplate, "phraisonsocial", "EasyWorld - coding for fun pty");
        xmlTemplate = replacePh(xmlTemplate, "phEnv", "Production");
        xmlTemplate = replacePh(xmlTemplate, "phProjectName", "Production");
         xmlTemplate = replacePh(xmlTemplate, "phVersion", "1.0 beta");
        xmlTemplate = replacePh(xmlTemplate, "phProjectLeader", "Leonardo Correa");
        
//        Table tbl = new Table();
//        tbl.addTableEle(TableEle.TH, "Jira Number", "Description");
//
//        tbl.addTableEle(TableEle.TD, "J2W-1234", "Read Templates nicelly");
//        tbl.addTableEle(TableEle.TD, "J2W-9999", "Make Java2word funky!!!");
//
//        xmlTemplate = replacePh(xmlTemplate, "phTableIssues", tbl.getContent());
//        
//        Paragraph p01 = Paragraph.with("1) Stop the server").create();
//        Paragraph p02 = Paragraph.with("2) Run the script to deploy the app xxx").create();
//        Paragraph p03 = Paragraph.with("3) Start the server").create();
//        Paragraph p04 = Paragraph.with("4) Hope for the best").create();
//        
//        String instructions = p01.getContent() + p02.getContent() + p03.getContent() + p04.getContent();
//        
//        //Workaround: phInstructions is already inside a 'text' fragment. 
//        //If you know the template, you can remove the whole element and add all Paragraphs
//        //* Table above doesn't need workaround because table can be normally inside a paragraph.
//        xmlTemplate = replacePh(xmlTemplate, "<w:t>phInstructions</w:t>", instructions); 
//        
        xmlTemplate = replacePh(xmlTemplate, "phDateTime", new Date().toString());
        
        File fileObj = new File("testnb2.doc");

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(fileObj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        writer.println(xmlTemplate);
        writer.close();
      
    }
	
}
