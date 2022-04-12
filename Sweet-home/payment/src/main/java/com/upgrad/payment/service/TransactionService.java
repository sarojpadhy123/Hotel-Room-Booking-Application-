/**
 * 
 */
package com.upgrad.payment.service;

import org.springframework.stereotype.Service;

import com.upgrad.payment.model.TransactionDetailsEntity;
import com.upgrad.payment.model.TransactionDetailsVO;

/**
 * Service repository annoted with @Service
 *
 */

@Service
public interface TransactionService {
	public TransactionDetailsEntity auditTransactionDetails(TransactionDetailsVO transactionDetailsVO);
	
	public TransactionDetailsEntity getTransactionDetails(int transactionId);
}
