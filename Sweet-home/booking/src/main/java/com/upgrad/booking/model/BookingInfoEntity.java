/**
 * 
 */
package com.upgrad.booking.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;


/**
 * This is the booking information for the modelling i created the all the entiites requied and provided the getter/setters/constructor and constructor with no params
 *and the to String method as well next i will create the booking info
 */
@Entity
@Table(name = "booking")
public class BookingInfoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer bookingId;
	
	@Column(nullable = true)
	private Date fromDate;
	
	@Column(nullable = true)
	private Date toDate;
	
	@Column(nullable = true)
	private String aadharNumber;
	
	private Integer numOfRooms;
	
	private String roomNumbers;
	
	@Column(nullable = false)
	private Integer roomPrice;
	
	@Column(columnDefinition = "integer default 0")
	private Integer transactionId;
	
	@Column(nullable = true)
	@CreatedDate
	@Temporal(TemporalType.DATE)
	private Date bookedOn;

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
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

	public String getRoomNumbers() {
		return roomNumbers;
	}

	public void setRoomNumbers(String roomNumbers) {
		this.roomNumbers = roomNumbers;
	}

	public Integer getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(Integer roomPrice) {
		this.roomPrice = roomPrice;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Date getBookedOn() {
		return bookedOn;
	}

	public void setBookedOn(Date bookedOn) {
		this.bookedOn = bookedOn;
	}

	@Override
	public String toString() {
		return "BookingInfoEntity [bookingId=" + bookingId + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", aadharNumber=" + aadharNumber + ", numOfRooms=" + numOfRooms + ", roomNumbers=" + roomNumbers
				+ ", roomPrice=" + roomPrice + ", transactionId=" + transactionId + ", bookedOn=" + bookedOn + "]";
	}
	
	
}
