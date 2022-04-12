/**
 * 
 */
package com.upgrad.booking.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upgrad.booking.dao.BookingInfoDao;
import com.upgrad.booking.model.BookingInfoEntity;
import com.upgrad.booking.model.BookingInfoVO;
import com.upgrad.booking.util.BookingUtils;

/**
 * implementations of the room service layer provided the logic for the room price calculation
 *
 */

@Service
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	private BookingInfoDao bookingInfoDao;

	@Override
	public Integer calculatePrice(Integer noOfRooms, Integer noOfDays) {
		return 1000 * noOfRooms * noOfDays;
	}

	@Override
	public ArrayList<String> createRandomRoomNumbers(Integer count) {
		Random rand = new Random();                
        int upperBound = 100;                
        ArrayList<String>numberList = new ArrayList<String>();                

       for (int i=0; i<count; i++)             
           numberList.add(String.valueOf(rand.nextInt(upperBound)));                           

         return numberList;
	}
	
	@Override
	public BookingInfoEntity convertToBookingEntity(BookingInfoVO bookingInfoVO) {
		BookingInfoEntity bookingInfoEntity = new BookingInfoEntity();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = null,endDate = null;
		try {
			 startDate = formatter.parse(bookingInfoVO.getFromDate());
			 endDate = formatter.parse(bookingInfoVO.getToDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		bookingInfoEntity.setFromDate(startDate);
		bookingInfoEntity.setToDate(endDate);
		bookingInfoEntity.setAadharNumber(bookingInfoVO.getAadharNumber());
		bookingInfoEntity.setNumOfRooms(bookingInfoVO.getNumOfRooms());
		ArrayList<String> rooms = createRandomRoomNumbers(bookingInfoVO.getNumOfRooms());
		bookingInfoEntity.setRoomNumbers(rooms.toString());
		int noOfDays = BookingUtils.calculateDays(bookingInfoVO.getFromDate(), bookingInfoVO.getToDate());
		int price = calculatePrice(bookingInfoVO.getNumOfRooms(),noOfDays);
		bookingInfoEntity.setRoomPrice(price);
		bookingInfoEntity.setTransactionId(0);
		bookingInfoEntity.setBookedOn(new Date());
		return bookingInfoEntity;
	}

	@Override
	public BookingInfoEntity auditBookingInfo(BookingInfoEntity bookingInfoEntity) {
		return bookingInfoDao.save(bookingInfoEntity);
		
	}

	@Override
	public BookingInfoEntity updateBookingInfo(Integer bookingId, Integer transactionId) {
		BookingInfoEntity bookingInfoEntity = bookingInfoDao.findById(bookingId).orElse(null);
		bookingInfoEntity.setTransactionId(transactionId);
		bookingInfoDao.save(bookingInfoEntity);
		return bookingInfoEntity;
	}

	@Override
	public BookingInfoEntity findBookingInfo(Integer bookingId) {
		BookingInfoEntity bookingInfoEntity = bookingInfoDao.findById(bookingId).orElse(null);
		return bookingInfoEntity;
	}
	
	

}
