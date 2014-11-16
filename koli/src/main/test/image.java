



import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.InputStream;
import org.domotyk.koli.analyzer.Tools;
import org.junit.Test;


public class image {

	
	
	@Test
	public void analyseDateSimple() throws Exception {

		
		InputStream ips=new FileInputStream("8L86375980543.png"); 

		assertEquals("Result", "dd",Tools.determineTypeCaractered(ips));

	}
}
