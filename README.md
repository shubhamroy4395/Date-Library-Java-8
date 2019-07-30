# Date-Library-Java-8

This library is used to convert the instance of Java Date to new Java 8 Date and Time API
 -- 
 Method Explanations:

### public static LocalDate dateToLocalDate(Date date)
  This method is used to convert the date instance to its LocalDate equivalent.

### public static LocalDateTime dateToLocalDateTime(Date date)
 This method is used to convert the date instance to its LocalDateTime equivalent.
 
### public static String convertDate(String inputDate, String fromFormat, String toFormat)
This method is used to convert the date from one format to another. It takes 3 string parameters.
The first is the date, the second is the current format of the date and the third is the target format you want to convert it to.

### public static XMLGregorianCalendar getXMLGregorianCalendar(String date, String format)
This is one of the trickiest conversions. It takes the XMLGregorianCalendar instanceand converts its LocalDateTime counterpart and then reconverts it to XMLGregorianCalendar.

### public static LocalDateTime getTimeToLocalDate(long time)
This method converts the long timestamp of Java Date to LocalDateTime.

### public static Date getTimeToDate(long time)
This method converts the long timestamp of Java Date to LocalDateTime and back to Date

## Known Bugs
For LocalDateTime, the converted date and time lags a little behind LocalDateTime.now() in seconds and milliseconds parameters.
