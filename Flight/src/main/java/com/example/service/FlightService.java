package com.example.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pojo.Flight;
//import com.example.pojo.SearchFlight;
import com.example.repository.FlightRepository;

@Service
public class FlightService {

	@Autowired
	private FlightRepository flightRepository;

//	public Iterable<Flight> findAllFlights() {
//		return flightRepository.findAll();
//	}

	public List<Flight> getAllFlights() {
		return flightRepository.findAll();
	}

	public Flight saveFlight(Flight flight) {
		return flightRepository.save(flight);
	}

	public Flight updateFlight(Flight flight, Integer id) {
		flight.setId(id);
		return flightRepository.save(flight);
	}

	public String deleteFlight(Integer id) {

		System.out.println("dtl starting");
		Optional<Flight> flight = flightRepository.findById(id);
		Flight fly = flight.get();
		String num = fly.getFlightNumber();
		flightRepository.delete(flight.get());
		System.out.println("Deleted flight number is: " + num);
		return num;
	}

	public Optional<Flight> findFlightById(Integer id) {

		Optional<Flight> flight = flightRepository.findById(id);
		return Optional.ofNullable(flight.get());
	}

	public Stream<Flight> findByOriginAndFlightDate(String origin, LocalDate flightDate) {
		return flightRepository.findByOriginAndFlightDate(origin, flightDate);
		// Flight flight2 = flight1.get();
		// return flight2;
	}
	
	public List<Flight> search1(String airline, LocalDate flightDate) {

		//SearchFlight searchFlight = new SearchFlight(flightDate, origin);
		List<Flight> flights = flightRepository.findByAirlineAndFlightDate(airline, flightDate);

		return flights;
	}
	
	
	public List<Flight> search2(LocalDate flightDate, String origin) {

		
		List<Flight> flights = flightRepository.findByFlightDateAndOrigin(flightDate,origin);

		return flights;
	}

	public List<Flight> search3(LocalDate flightDate, String origin, String destination) {


		List<Flight> flights = flightRepository.findByFlightDateAndOriginAndDestination(flightDate, origin, destination);

		return flights;

		
	}
	
	public List<Flight> search4(String flightNumber, String origin, String destination) {

		

		List<Flight> flights = flightRepository.findByFlightNumberAndOriginAndDestination(flightNumber, origin, destination);

		return flights;
	}
}




//Stream<Flight> searchReasults = flights.stream()
		// .filter(flight -> flight.getInventory().getCount() >=
		// searchFlight.getNumberOfPassengers());

		/*
		 * List<Flight> searchReasults = flights.stream() .filter(flight ->
		 * flight.getInventory().getCount() >= searchFlight.getNumberOfPassengers())
		 * .collect(Collectors.toList());
		 */
