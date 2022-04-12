/**
 * 
 */
package com.upgrad.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upgrad.payment.dao.TransactionDetailsDao;
import com.upgrad.payment.model.TransactionDetailsEntity;
import com.upgrad.payment.model.TransactionDetailsVO;

/**
 * implementation for the payment module
 *
 */
@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private TransactionDetailsDao transactionDetailsDao;

	@Override
	public TransactionDetailsEntity auditTransactionDetails(TransactionDetailsVO transactionDetailsVO) {
		TransactionDetailsEntity transactionDetailsEntity = new TransactionDetailsEntity();
		transactionDetailsEntity.setBookingId(transactionDetailsVO.getBookingId());
		transactionDetailsEntity.setCardNumber(transactionDetailsVO.getCardNumber());
		transactionDetailsEntity.setPaymentMode(transactionDetailsVO.getPaymentMode());
		transactionDetailsEntity.setUpiId(transactionDetailsVO.getUpiId());
		
		return transactionDetailsDao.save(transactionDetailsEntity);
	}

	@Override
	public TransactionDetailsEntity getTransactionDetails(int transactionId) {
		TransactionDetailsEntity transactionDetailsEntity = transactionDetailsDao.findById(transactionId).orElse(null);
		return transactionDetailsEntity;
	}
	
}
