/**
 * This is my controller
 */
package com.upgrad.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.upgrad.booking.model.BookingInfoEntity;
import com.upgrad.booking.model.BookingInfoVO;
import com.upgrad.booking.model.TransactionDetailsVO;
import com.upgrad.booking.service.RoomService;



@RestController
@RequestMapping("/hotel/")
public class BookRoomsController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private RoomService roomService;
	
	
	@PostMapping("/booking")
	public ResponseEntity<BookingInfoEntity> bookRooms(@RequestBody BookingInfoVO bookingInfoVO){
		ResponseEntity<BookingInfoEntity> responseEntity;
		BookingInfoEntity bookingInfoEntity = roomService.convertToBookingEntity(bookingInfoVO);
		bookingInfoEntity = roomService.auditBookingInfo(bookingInfoEntity);
		responseEntity = new ResponseEntity<BookingInfoEntity>(bookingInfoEntity,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PostMapping("booking/{bookingId}/transaction")
	public ResponseEntity<BookingInfoEntity> makeAPayment(@PathVariable("bookingId") Integer bookingId,
			@RequestBody TransactionDetailsVO traDetailsVO) throws Exception {
		ResponseEntity<BookingInfoEntity> responseEntity;
		if (!traDetailsVO.getPaymentMode().equals("UPI") && !traDetailsVO.getPaymentMode().equals("CARD"))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid mode of payment");

		else if (roomService.findBookingInfo(bookingId) == null)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Booking Id");
		else {
			Integer transactionId = restTemplate.postForObject("http://payment-service/payment/transaction",
					traDetailsVO, Integer.class);
			BookingInfoEntity bookingInfoEntity = roomService.updateBookingInfo(bookingId, transactionId);
			responseEntity = new ResponseEntity<BookingInfoEntity>(bookingInfoEntity, HttpStatus.CREATED);
			String message = "Booking confirmed for user with aadhaar number: " + bookingInfoEntity.getAadharNumber()
					+ "    |    " + "Here are the booking details:    " + bookingInfoEntity.toString();
			System.out.println(message);
		}
		return responseEntity;
	}

}
