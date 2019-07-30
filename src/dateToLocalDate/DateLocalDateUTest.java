package dateToLocalDate;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
@RunWith(JUnit4.class)
public class DateLocalDateUTest {
	Date date = new Date();
	@Test
	public void testDateToLocalDate() {
		assertEquals(LocalDate.now(),DateLocalDate.dateToLocalDate(date));
	}

	@Test
	public void testConvertDate() {
		assertEquals("29-07-2019",DateLocalDate.convertDate("2019-07-29","yyyy-MM-dd","dd-MM-yyyy"));
	}
	
	@Test
	public void testDateToLocalDateTime() {
		assertEquals(LocalDateTime.now().withNano(0).withSecond(0),DateLocalDate.dateToLocalDateTime(date).withNano(0).withSecond(0));
	}
}
