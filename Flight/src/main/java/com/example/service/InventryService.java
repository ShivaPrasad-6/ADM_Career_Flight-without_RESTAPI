package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pojo.Inventry;
import com.example.repository.InventryRepository;

@Service
public class InventryService {
	
	@Autowired
	private InventryRepository inventryRepository;
	
	public List<Inventry> allInventories() {
		return inventryRepository.findAll();
	}
	
	public Inventry saveFare(Inventry inventry) {
		return inventryRepository.save(inventry);
	}

	public Inventry updateInventory(Inventry inventry, Integer inventoryId) {
		inventry.setInventoryId(inventoryId);
		return inventryRepository.save(inventry);
	}

	public int deleteInventory(Integer inventoryId) {

		System.out.println("dtl starting");
		Optional<Inventry> inventry = inventryRepository.findById(inventoryId);
		Inventry inv = inventry.get();
		int ID = inv.getInventoryId();
		inventryRepository.delete(inventry.get());
		System.out.println("Deleted flight number is: " + ID);
		return ID;
	}

	public Optional<Inventry> findFareById(Integer inventoryId) {

		Optional<Inventry> fare = inventryRepository.findById(inventoryId);
		return Optional.ofNullable(fare.get());
	}

}
