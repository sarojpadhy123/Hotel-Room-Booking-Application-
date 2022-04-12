/**
 * 
 */
package com.upgrad.booking.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * method for validating the date
 *
 */
public class BookingUtils {

	public static int calculateDays(String fromDate, String toDate) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate startDate = LocalDate.parse(fromDate, dtf);
		LocalDate endDate = LocalDate.parse(toDate, dtf);
		int days = (int) ChronoUnit.DAYS.between(startDate, endDate);
		return days;
	}
	
	
}
