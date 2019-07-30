package dateToLocalDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public final class DateLocalDate {
	


	public static void main(String[] args) {
		Date date1 = new Date();
		XMLGregorianCalendar date = getXMLGregorianCalendar("2008-05-21 15:35","yyyy-MM-dd HH:mm");
		System.out.println(date);
		System.out.println("local date is "+dateToLocalDate(date1));
		System.out.println(getTimeToLocalDate(date1.getTime()));
		System.out.println(convertDate("2019-07-29","yyyy-MM-dd","dd-MM-yyyy"));

	}
	
	//convert date to localdate
	public static LocalDate dateToLocalDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	//convert date to localdatetime
	public static LocalDateTime dateToLocalDateTime(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
	
	//convert one format of date to another
	public static String convertDate(String inputDate, String fromFormat, String toFormat) {
		LocalDate localDate = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern(fromFormat));
		return localDate.format(DateTimeFormatter.ofPattern(toFormat));
	}
	
	//take the XMLGregorianCalendar instance, convert that to LocalDate and return it again as XMLGregorianCalendar
	public static XMLGregorianCalendar getXMLGregorianCalendar(String date, String format) {
		XMLGregorianCalendar xmlCalender = null;
		try {
			LocalDateTime localDate = LocalDateTime.parse(date, DateTimeFormatter.ofPattern(format));
			GregorianCalendar calender = GregorianCalendar.from(localDate.atZone(ZoneId.systemDefault()));
			xmlCalender = DatatypeFactory.newInstance().newXMLGregorianCalendar(calender);
			xmlCalender.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
			
		} catch (DatatypeConfigurationException ex) {
		}
		return xmlCalender;
	}

	//convert from long time to LocalDatetime
	public static LocalDateTime getTimeToLocalDate(long time) {
		return convertToLocalDatefromTimeStamp(time);
	}
	
	//convert from long time to LocalDatetime and return as date
	public static Date getTimeToDate(long time) {
		return Date.from(convertToLocalDatefromTimeStamp(time).atZone(ZoneId.systemDefault()).toInstant());
	}
	
	public static LocalDateTime convertToLocalDatefromTimeStamp(long time) {
		Date date = new Date(time);
		 return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
	}

}
