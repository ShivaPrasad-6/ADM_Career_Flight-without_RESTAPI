package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pojo.Fare;
import com.example.repository.FareRepository;

@Service
public class FareService {

	@Autowired
	private FareRepository farerepository;

	public List<Fare> allFares() {
		return farerepository.findAll();
	}

	public Fare saveFare(Fare fare) {
		return farerepository.save(fare);
	}

	public Fare updateFare(Fare fare, Integer fareId) {
		fare.setFareId(fareId);
		return farerepository.save(fare);
	}

	public int deleteFare(Integer fareId) {

		System.out.println("dtl starting");
		Optional<Fare> fare = farerepository.findById(fareId);
		Fare faree = fare.get();
		int ID = faree.getFareId();
		farerepository.delete(fare.get());
		System.out.println("Deleted flight number is: " + ID);
		return ID;
	}

	public Optional<Fare> findFareById(Integer fareId) {

		Optional<Fare> fare = farerepository.findById(fareId);
		return Optional.ofNullable(fare.get());
	}
}
