/**
 * 
 */
package com.upgrad.booking.model;

/**
 * Booking info
 *
 */
public class BookingInfoVO {

	private String fromDate;
	
	private String toDate;
	
	private String aadharNumber;
	
	private Integer numOfRooms;

	

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public Integer getNumOfRooms() {
		return numOfRooms;
	}

	public void setNumOfRooms(Integer numOfRooms) {
		this.numOfRooms = numOfRooms;
	}
	
	
}
