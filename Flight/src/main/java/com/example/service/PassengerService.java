package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pojo.Passenger;
import com.example.repository.PassengerRepository;

@Service
public class PassengerService {
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	public List<Passenger> allPassengers() {
		return passengerRepository.findAll();
	}
	
	public Passenger saveFlight(Passenger passenger) {
		return passengerRepository.save(passenger);
	}

	public Passenger updateFlight(Passenger passenger, Integer passengerId) {
		passenger.setPassengerId(passengerId);
		return passengerRepository.save(passenger);
	}

	public long deletePassenger(Long passengerId) {
		
		System.out.println("dtl starting");
		Optional<Passenger> passenger = passengerRepository.findById(passengerId);
		Passenger pas = passenger.get();
		long num = pas.getPassengerId();
		passengerRepository.delete(passenger.get());
		System.out.println("Deleted flight number is: " +num);
		return num;
	}
	
	public Optional<Passenger> findPassengerById(Long id) {

		Optional<Passenger> passenger = passengerRepository.findById(id);
		return Optional.ofNullable(passenger.get());
	}

}
