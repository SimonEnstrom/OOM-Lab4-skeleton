package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class TimeZoneTranslatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testShiftTimeZone() {
		DateTime today = new DateTime(2018, 10, 20, 20, 39, 15);
		DateTime tomorrow = new DateTime(2018, 10, 21, 02, 39, 15);
		today = TimeZoneTranslator.shiftTimeZone(today, 1, 7);
		assertEquals(today.toString(), tomorrow.toString());
		
	}
	//working?
	@Test
	public void testShiftTimeZone2() {
		DateTime sweden = new DateTime(2016, 1, 1, 06, 00, 00);
		sweden = TimeZoneTranslator.shiftTimeZone(sweden, 1, -8);
		DateTime us = new DateTime(2015, 12, 31, 21, 00, 00);
		assertEquals(sweden.toString(), us.toString());
	}
	@Test
	public void testShiftEventTimeZone() {
		DateTime startDate = new DateTime(2018, 10, 20, 14, 00, 00);
		DateTime endDate = new DateTime(2018, 10, 20, 16, 00, 00);
		DateTime checkStartDate = new DateTime(2018, 10, 20, 20, 00, 00);
		DateTime checkEndDate = new DateTime(2018, 10, 20, 22, 00, 00);
		Person Jonte = new Person("Jonte");
		Person Adam = new Person("Adam");
		Person Gunde = new Person("Gunde");
		Place Backyard = new Place("Backyard",60.0,27.0,40.0);
		Event party = new Event("party",
									startDate,
									endDate,
									new HashSet<>(Arrays.asList(Jonte, Adam, Gunde)),
									Backyard);
		party = TimeZoneTranslator.shiftEventTimeZone(party, TimeZone.CENTRAL_EUROPEAN_TIME, TimeZone.THAILAND);
		Event checkEvent = new Event("party",
										checkStartDate, 
										checkEndDate, 
										new HashSet<>(Arrays.asList(Jonte, Adam, Gunde)), 
										Backyard );
		assertEquals(party.toString(), checkEvent.toString());
	}

}
