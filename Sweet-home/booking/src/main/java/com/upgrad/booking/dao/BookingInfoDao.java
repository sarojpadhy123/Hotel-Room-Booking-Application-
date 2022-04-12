package com.upgrad.booking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upgrad.booking.model.BookingInfoEntity;

// Dao repository
@Repository
public interface BookingInfoDao extends JpaRepository<BookingInfoEntity, Integer>{

}
