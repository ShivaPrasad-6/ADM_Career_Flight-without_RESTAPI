package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pojo.BookingRecord;

@Repository
public interface BookingRecordRepository extends CrudRepository<BookingRecord, Long>{
	
	List<BookingRecord> findAll();

}
