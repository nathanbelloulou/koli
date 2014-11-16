package org.domotyk.koli.analyzer;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.InputStream;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.imageio.ImageIO;



public class Tools {

	public static synchronized String bytesToMD5(byte[] bytesOfImages) throws Exception {
		String code = "";
		MessageDigest msgDigest;
		msgDigest = MessageDigest.getInstance("MD5");
		msgDigest.update(bytesOfImages);
		byte[] digest = msgDigest.digest();
		for (int i = 0; i < digest.length; ++i) {
			int value = digest[i];
			if (value < 0) {
				value += 256;
			}

			code = code + Integer.toHexString(value) + "";
		}

		return code;
	}

	public static synchronized Date  dateMaxOfColisRecieve(List<Date> jourFerie,
			Date dateToAnalyse) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(dateToAnalyse);
		int today = 0;
		int cpt = 0;
		int delaiDelivraison = 2;
		while (cpt < delaiDelivraison) {
			today = calendar.get(Calendar.DAY_OF_WEEK);
			if (today == GregorianCalendar.SATURDAY
					|| today == GregorianCalendar.SUNDAY
					|| jourFerie.contains(calendar.getTime())) {
			} else {

				cpt++;
			}
			calendar.add(Calendar.DAY_OF_MONTH, 1);

		}

		// if (dateToAnalyse. compareTo(calendar.getTime()))

		return calendar.getTime();

	}


//détermine la date de la dernier analyse possible dans le systeme d'archivage de la poste cad 1 mois
	public static synchronized Date dateMaxOfColisAnalyze(List<Date> jourFerie,
			Date dateToAnalyse) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(dateToAnalyse);
		calendar.add(Calendar.MONTH, 1);
		int today,com = 0;

		while(com==0){
			today = calendar.get(Calendar.DAY_OF_WEEK);
			if (today == GregorianCalendar.SATURDAY
					|| today == GregorianCalendar.SUNDAY
					|| jourFerie.contains(calendar.getTime())) {
				calendar.add(Calendar.DAY_OF_MONTH, -1);
			}


			else{com =1;
			}
		}
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.MILLISECOND, -1);
		return calendar.getTime();

	}
	//Détermine si la date est bien dans ans le délai d'analyse (1mois)
	public static synchronized boolean colisAnalizable(List<Date> jourFerie,
			Date dateToAnalyse,Date actual) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(dateMaxOfColisAnalyze(jourFerie, dateToAnalyse));
		System.out.println(dateToAnalyse+" max date analyse "+calendar.getTime()+" date du jour"+actual+actual.before(calendar.getTime()));
		return actual.before(calendar.getTime());
	}





	public static boolean compareDate(Date datePrevu, Date dateEffec)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateWithoutTime = sdf.parse(sdf.format(datePrevu));

		Date dateWithoutTimef = sdf.parse(sdf.format(dateEffec));

		if (dateWithoutTimef.getTime() > dateWithoutTime.getTime()) {
			return false;
		} else {
			return true;
		}
	}

	public static synchronized boolean determineTypeCaractere(InputStream fileIn) throws Exception{
		BufferedImage b = null;

		b = ImageIO.read(fileIn);

		BufferedImage bc = b.getSubimage(60, 0, 15, 13);
		ByteArrayOutputStream bas = new ByteArrayOutputStream();
		ImageIO.write(bc, "PNG", bas);
		byte[] data = bas.toByteArray();
		if (Constant.VALIDATEUR_TYPE_CARAC.equals(Tools.bytesToMD5(data))){
							System.out.println("type de caratere 2");
			return false;

		}else{

			return true;
		}
	}
	public static synchronized List<String> determineTypeCaractered(InputStream fileIn) throws Exception{
		BufferedImage b = null;

		b = ImageIO.read(fileIn);
		List<String> date = new ArrayList<String>();;



		List<Integer> dimension = Constant.DIMENSION2;
		int dim_carac = Constant.DIMENSION2_CARAC;
		BufferedOutputStream fileOut = null;
		for (Integer next : dimension) {
			File target = new File(next+".png");


			fileOut = new BufferedOutputStream(new FileOutputStream(target));
			BufferedImage bc = b.getSubimage(next, 0, dim_carac, 13);
			ByteArrayOutputStream bas = new ByteArrayOutputStream();
			ImageIO.write(bc, "PNG", fileOut);
			ImageIO.write(bc, "PNG", bas);
			byte[] data = bas.toByteArray();
			date.add(Tools.bytesToMD5(data));


			try {




				int bs = 0;

				while ((bs = fileIn.read()) != -1) {
					fileOut.write(bs);
				}
				fileOut.flush();
				fileOut.close();

				fileIn.close();

			} catch (IOException e) {

				e.printStackTrace();
			}


		}
		return date;
	}

	public static Date stringToGetDate(List<String> list) {
		String sDate = "";
		for (String chiffre : list) {
			if (Constant.mapNum.get(chiffre) != null) {
				sDate = sDate + Constant.mapNum.get(chiffre);
			} else {
				sDate = sDate + "0";

			}
		}
		//	System.out.println("--->"+ sDate);
		if ("00000000".equals(sDate)){
			//	System.out.println("--->"+ sDate);
			return null;
		}

		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
		ParsePosition pos = new ParsePosition(0);
		return new Date(formatter.parse(sDate, pos).getTime());
	}

	public static List<Date> getJourFerieFr() {
		List<Date> jours = new ArrayList<Date>();

		Calendar cal = Calendar.getInstance();
		// jour de l'an
		cal.set(cal.get(Calendar.YEAR), Calendar.JANUARY, 1);
		jours.add(cal.getTime());
		// jour 11 novembre
		cal.set(cal.get(Calendar.YEAR), Calendar.NOVEMBER, 1);
		jours.add(cal.getTime());
		// jour 1 novembre
		cal.set(cal.get(Calendar.YEAR), Calendar.NOVEMBER, 11);
		jours.add(cal.getTime());
		// jour 1 mai
		cal.set(cal.get(Calendar.YEAR), Calendar.MAY, 1);
		jours.add(cal.getTime());
		// jour 8 mai
		cal.set(cal.get(Calendar.YEAR), Calendar.MAY, 8);
		jours.add(cal.getTime());
		// jour 14 juillet
		cal.set(cal.get(Calendar.YEAR), Calendar.JULY, 14);
		jours.add(cal.getTime());
		// 15 aout
		cal.set(cal.get(Calendar.YEAR), Calendar.AUGUST, 15);
		jours.add(cal.getTime());

		return jours;

	}

}
