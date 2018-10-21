package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DateTimeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testToString() {
		DateTime date = new DateTime(2002, 7, 12, 19, 00);
		String dateString = "2002-07-12 19:00";
		assertEquals(date.toString(), dateString);
	}

	@Test
	public void testDateTimeString() {
		String date = "1999-04-13 11:30";
		DateTime dateCompare = new DateTime(date);
		assertEquals(date, dateCompare.toString());
	}

}
