package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pojo.AirlineInfo;

@Repository
public interface AirlineInfoRepository extends CrudRepository<AirlineInfo, Long> {

	List<AirlineInfo> findAll();
}
