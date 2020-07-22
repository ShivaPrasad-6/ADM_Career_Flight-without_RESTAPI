package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pojo.Passenger;

@Repository
public interface PassengerRepository extends CrudRepository<Passenger, Long>{
	
	List<Passenger> findAll();

}
