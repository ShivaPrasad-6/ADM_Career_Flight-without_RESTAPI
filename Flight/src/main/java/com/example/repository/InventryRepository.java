package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pojo.Inventry;

@Repository
public interface InventryRepository extends CrudRepository<Inventry, Integer> {
	
	List<Inventry> findAll();

}
