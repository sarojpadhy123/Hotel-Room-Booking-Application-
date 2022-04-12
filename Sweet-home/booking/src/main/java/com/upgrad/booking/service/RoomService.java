package com.upgrad.booking.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.upgrad.booking.model.BookingInfoEntity;
import com.upgrad.booking.model.BookingInfoVO;

/**
 * service layer for the room
 *
 */

@Service
public interface RoomService {
	
	public Integer calculatePrice(Integer noOfRooms, Integer noOfDays);
	
	public ArrayList<String> createRandomRoomNumbers(Integer count);
	
	public BookingInfoEntity convertToBookingEntity(BookingInfoVO bookingInfoVO);
	
	public BookingInfoEntity auditBookingInfo(BookingInfoEntity bookingInfoEntity);

	public BookingInfoEntity updateBookingInfo(Integer bookingId, Integer transactionId);
	
	public BookingInfoEntity findBookingInfo(Integer bookingId);
}
