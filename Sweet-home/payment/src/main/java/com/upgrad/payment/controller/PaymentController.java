/**
 * 
 */
package com.upgrad.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upgrad.payment.model.TransactionDetailsEntity;
import com.upgrad.payment.model.TransactionDetailsVO;
import com.upgrad.payment.service.TransactionService;

/**
 * Controller for the payment
 *
 */

@RestController
@RequestMapping("/payment/")
public class PaymentController {

	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/transaction")
	public ResponseEntity<Integer> makeTransaction(@RequestBody TransactionDetailsVO tranDetailsVO){
		TransactionDetailsEntity transactionDetailsEntity = transactionService.auditTransactionDetails(tranDetailsVO);
		ResponseEntity<Integer> responseEntity = new ResponseEntity<Integer>(transactionDetailsEntity.getTransactionId(),HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/transaction/{transactionId}")
	public ResponseEntity<TransactionDetailsEntity> getTransactionDetails(@PathVariable("transactionId") Integer transactionId) {
		TransactionDetailsEntity transactionDetailsEntity = transactionService.getTransactionDetails(transactionId);
		ResponseEntity<TransactionDetailsEntity> responseEntity = new ResponseEntity<TransactionDetailsEntity>(transactionDetailsEntity,HttpStatus.OK);
		return responseEntity;
	}
}
