/**
 * 
 */
package com.upgrad.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upgrad.payment.model.TransactionDetailsEntity;

/**
 * Dao or Repository which connect to the database
 *
 */

@Repository
public interface TransactionDetailsDao extends JpaRepository<TransactionDetailsEntity, Integer>{

}
