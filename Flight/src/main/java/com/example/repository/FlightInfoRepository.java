package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pojo.FlightInfo;

@Repository
public interface FlightInfoRepository extends CrudRepository<FlightInfo, Long>{
	
	List<FlightInfo> findAll();

}
