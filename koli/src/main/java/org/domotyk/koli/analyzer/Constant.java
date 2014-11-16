package org.domotyk.koli.analyzer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constant {

	public static String ADDESSE_SITE_COLIS="http://www.colissimo.fr/portail_colissimo/suivre.do?colispart=";
	public static final Map<String, String> ColisEtat = new HashMap<String, String>();
	public static final Map<String, String> mapNum = new HashMap<String, String>();
/*
 * Etat possible
 */
	//Etat initialisation
	public static final String INI="INI";
	//en cours d'analyse
	public static final String PAN="PAN";
	//recu dans les temps
	public static final String RIT="RIT";
	//recu hore delai
	public static final String ROT="ROT";
	//perdu
	public static final String LOZ="LOZ";
    //En reclamation
	public static final String REC = "REC";
	//analyse en erreur ou nombre d'analyse supperieur
	public static final String ERR = "ERR";
	//Non analysable pour des causes de code invalide
	public static final String OUT = "OUT";
	//labelle inconnu
	public static final String UNL = "UNL";
	public static final String ECA = "ECA";	
	public static final String VALIDATEUR_TYPE_CARAC = "43b32edf5313de2af62d442d03847";
	/*
	 * Numero de l'iimage dans la page
	 */
public static int NUM_IMA_ETAT=8;
public static int NUM_IMA_DATE=7;
/*
 * Dimension d'un caractere
 */	
public static final	List<Integer> DIMENSION=new ArrayList<Integer>();
public static final	List<Integer> DIMENSION2=new ArrayList<Integer>();
public static final	List<String> VALIDCOLISTYPE=new ArrayList<String>();

public static int DIMENSION_CARAC=8;
public static int DIMENSION2_CARAC=7;
	  static {
		  
		  //Pour info il faut ignoré Les colis commençant par  : 8U, 8N, 8D, 8Y, 7M, CC, CK, 7B, 7C, CW, 8X, 8J, 8T, et 8Z ne sont 
		  VALIDCOLISTYPE.add("8V");
		  VALIDCOLISTYPE.add("8L");
		  VALIDCOLISTYPE.add("9A");
		  VALIDCOLISTYPE.add("9C");
		  VALIDCOLISTYPE.add("6A");
		  VALIDCOLISTYPE.add("6M");
		  VALIDCOLISTYPE.add("6K");
		  VALIDCOLISTYPE.add("6Q");
		  VALIDCOLISTYPE.add("6J");
		  VALIDCOLISTYPE.add("6H");
		  VALIDCOLISTYPE.add("6R");
		  VALIDCOLISTYPE.add("6W");
		  VALIDCOLISTYPE.add("6T");
		  VALIDCOLISTYPE.add("CY");
		  VALIDCOLISTYPE.add("CX");
		  VALIDCOLISTYPE.add("CD");
		  DIMENSION.add(0);
			DIMENSION.add(8);
			DIMENSION.add(20);
			DIMENSION.add(28);
			DIMENSION.add(40);
			DIMENSION.add(48);
			DIMENSION.add(56);
			DIMENSION.add(64);
			 DIMENSION2.add(0);
				DIMENSION2.add(7);
				DIMENSION2.add(17);
				DIMENSION2.add(24);
				DIMENSION2.add(34);
				DIMENSION2.add(41);
				DIMENSION2.add(48);
				DIMENSION2.add(55);
				
			

    	ColisEtat.put(INI, "Initialisé");
    	ColisEtat.put(PAN, "En analyse");
    	ColisEtat.put(REC, "reçu");
    	ColisEtat.put(RIT, "reçu dans les délais");
    	ColisEtat.put(ROT, "reçu hors délais");
    	ColisEtat.put(LOZ, "Perdu");
    	ColisEtat.put(ERR, "En erreur");
    	ColisEtat.put(UNL, "Libellé inconnu");
    	ColisEtat.put(ECA, "A réanalyse");
    	ColisEtat.put(OUT, "Analyse hors delai");
    	//attention il manque le 4 
    	mapNum.put("dfcc2ed3898da10b84df3638b636e38", "0");
    	mapNum.put("8c8a246dc38c4e931984a260cb609845", "1");
    	mapNum.put("f5a6f77d926fdf8a991dae337197", "2");
    	mapNum.put("70d3a749d3704daef1a531c63d7734b", "3");
    	mapNum.put("977b32fc967bc43e6429253ed747686", "4");
    	mapNum.put("c31ea2f274285f406a43e4f44da2c2b0", "5");
    	mapNum.put("43daef496c52cbef5f6d4640585981d9", "6");
    	mapNum.put("509ea2d705e4f43bf52119377b9fe8b", "7");
    	mapNum.put("684f34ef04d8b84c93899eb9e6d0d9", "8");
    	mapNum.put("379e545537efa7776b9e5088e080985a", "9");
    	mapNum.put("cbc426321ae8b77fa59257a07b2ea", "0");
    	mapNum.put("81f4f6f045fcb88d48ecc42b5a0a5", "1");
    	mapNum.put("8f22c2360f0df48a18c68fca1d4ff", "2");
    	mapNum.put("70d3a749d3704daef1a531c63d7734b", "3");
    	mapNum.put("977b32fc967bc43e6429253ed747686", "4");
    	mapNum.put("c31ea2f274285f406a43e4f44da2c2b0", "5");
    	mapNum.put("efebde11d51da32f55523de8d626bff", "6");
    	mapNum.put("e554e43468a6c3c686217de3dbc83cd", "7");
    	mapNum.put("556b6a23f5710b410f18850a05e9ac", "8");
    	mapNum.put("5e4bdceaa781f9326bb2b53a2090dd", "9");
    }
}
