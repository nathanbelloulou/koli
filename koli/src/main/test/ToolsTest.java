import java.text.ParseException;
import java.util.Calendar;

import javax.validation.constraints.AssertTrue;

import org.domotyk.koli.analyzer.Tools;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ToolsTest {

	Calendar cal = Calendar.getInstance();
	Calendar calExpeted = Calendar.getInstance();

	@Test
	public void analyseDateSimple() {

		cal.set(2011, Calendar.AUGUST, 10);
		calExpeted.set(2011, Calendar.AUGUST, 12);
		assertEquals("Result", calExpeted.getTime(),
				Tools.dateMaxOfColisRecieve(Tools.getJourFerieFr(), cal.getTime()));

	}

	@Test
	public void analyseDateAvecWK() {

		cal.set(2011, Calendar.AUGUST, 19);
		calExpeted.set(2011, Calendar.AUGUST, 23);
		assertEquals("Result", calExpeted.getTime(),
				Tools.dateMaxOfColisRecieve(Tools.getJourFerieFr(), cal.getTime()));
	}

	@Test
	public void analyseDateAvecJourFerieEtWK() {

		cal.set(2011, Calendar.AUGUST, 12);
		calExpeted.set(2011, Calendar.AUGUST, 17);
		assertEquals("Result", calExpeted.getTime(),
				Tools.dateMaxOfColisRecieve(Tools.getJourFerieFr(), cal.getTime()));
	}
	
	@Test
	public void analyseDate() throws ParseException {

	
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, 1);
		Calendar calendar2 = Calendar.getInstance();
		
		
		assertEquals("Result", true,Tools.compareDate(calendar.getTime(),calendar2.getTime()));
	}
	
	@Test
	public void analyseDateMax() {

		cal.set(2011, Calendar.AUGUST, 12);
		calExpeted.set(2011, Calendar.SEPTEMBER, 12);
		assertEquals("Result", calExpeted.getTime(),
				Tools.dateMaxOfColisAnalyze(Tools.getJourFerieFr(), cal.getTime()));
	}
	@Test
	public void analyseDateMax2() {

		cal.set(2011, Calendar.OCTOBER, 6);
		calExpeted.set(2011, Calendar.NOVEMBER, 4);
		assertEquals("Result", calExpeted.getTime(),
				Tools.dateMaxOfColisAnalyze(Tools.getJourFerieFr(), cal.getTime()));
	}
	@Test
	public void analyseDateMax3() {

		cal.set(2011, Calendar.OCTOBER, 5);
		calExpeted.set(2011, Calendar.NOVEMBER, 4);
		assertEquals("Result", calExpeted.getTime(),
				Tools.dateMaxOfColisAnalyze(Tools.getJourFerieFr(), cal.getTime()));
	}
	@Test
	public void analyseDateMax4() {

		cal.set(2011, Calendar.OCTOBER, 7);
		calExpeted.set(2011, Calendar.NOVEMBER, 8);

		assertEquals(false,Tools.colisAnalizable(Tools.getJourFerieFr(),cal.getTime(),calExpeted.getTime()));
	}
	@Test
	public void analyseDateMax5() {

		cal.set(2011, Calendar.NOVEMBER,8);
		calExpeted.set(2011, Calendar.OCTOBER, 5);
		assertEquals(true,Tools.colisAnalizable(Tools.getJourFerieFr(),cal.getTime(),calExpeted.getTime()));
	}
}
