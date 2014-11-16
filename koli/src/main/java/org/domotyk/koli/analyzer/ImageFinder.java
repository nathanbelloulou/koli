package org.domotyk.koli.analyzer;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.domotyk.koli.analyzer.Constant;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.ObjectFindingVisitor;

public class ImageFinder {

	private String IdColis = null;
	private String URLimage = null;
	private String URLDate = null;
private ByteArrayOutputStream target;
	public ImageFinder(String idColi) {

		setIdColis(idColi);
		initialisation();
	}

	public void setIdColis(String idColis) {
		IdColis = idColis;
	}

	public String getIdColi() {
		return IdColis;
	}

	/*
	 * Recherche l'url de l'image
	 */
	private void initialisation() {
		//System.out.println(Calendar.getInstance().getTime());
		Parser parser;
		try {
			parser = new Parser(Constant.ADDESSE_SITE_COLIS + IdColis);
			ObjectFindingVisitor visitor = new ObjectFindingVisitor(
					ImageTag.class);
			// parse la page
			parser.visitAllNodesWith(visitor);
			Node[] links = visitor.getTags();
			// reccuperation l'url de l'etat
			ImageTag imageTag = (ImageTag) links[Constant.NUM_IMA_ETAT];
			// System.out.println(imageTag.getImageURL());
			setURLimage(imageTag.getImageURL());
			// reccuperation l'url de la date
			imageTag = (ImageTag) links[Constant.NUM_IMA_DATE];

			setURLDate(imageTag.getImageURL());

		} catch (final ParserException e) {
			System.out.println("parsing  de la page KO");

		}

	}

	public String getCodeOfColisLabel() throws Exception {

		URL urltest = new URL(URLimage);
		InputStream fileIn = urltest.openStream();
		 target = new ByteArrayOutputStream();
		BufferedOutputStream fileOut = new BufferedOutputStream(target);
		int b = 0;
		while ((b = fileIn.read()) != -1) {
			fileOut.write(b);
		}
		fileOut.flush();
		fileOut.close();
		fileIn.close();
		return Tools.bytesToMD5(target.toByteArray());

	}

	public Date getdate() throws Exception {

		List<String> date = null;
		URL url = null;
		InputStream fileIn = null;
		InputStream fileIn2 = null;
		BufferedImage b = null;
		List<Integer> dimension = null;
		int dim_carac = 0;

		date = new ArrayList<String>();
		url = new URL(URLDate);
		fileIn = url.openStream();
		fileIn2 =url.openStream();
		saveImage(fileIn);
		b = ImageIO.read(fileIn);
		fileIn.close();
		// determine le type de caratere
		if (Tools.determineTypeCaractere(fileIn2)) {
			dimension = Constant.DIMENSION;
			dim_carac = Constant.DIMENSION_CARAC;
		} else {
			dimension = Constant.DIMENSION2;
			dim_carac = Constant.DIMENSION2_CARAC;
		}

		for (Integer next : dimension) {
		
			BufferedImage bc = b.getSubimage(next, 0, dim_carac, 13);
			ByteArrayOutputStream bas = new ByteArrayOutputStream();
			ImageIO.write(bc, "PNG", bas);

			byte[] data = bas.toByteArray();
			date.add(Tools.bytesToMD5(data));
		}

		return Tools.stringToGetDate(date);

	}

	public String saveImage() throws IOException {
	

			String strFilePath = IdColis + ".png";
			
			FileOutputStream fos = new FileOutputStream(strFilePath);
 fos.write(target.toByteArray());
		 ImageIO.createImageOutputStream(target);
//		  
		       fos.close(); 
		       return strFilePath;

	}
	
	public File saveImage(InputStream fileIn) {
		try {

			String name = IdColis +1+ ".png";
			File target = new File(name);
			BufferedOutputStream fileOut;

			fileOut = new BufferedOutputStream(new FileOutputStream(target));

			int b = 0;

			while ((b = fileIn.read()) != -1) {
				fileOut.write(b);
			}
			fileOut.flush();
			fileOut.close();

			fileIn.close();
			return target;
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public void setURLimage(String uRLimage) {
		URLimage = uRLimage;
	}

	public String getURLimage() {
		return URLimage;
	}

	public void setURLDate(String url) {
		URLDate = url;
	}

	public String getURLDate() {
		return URLDate;
	}

}
