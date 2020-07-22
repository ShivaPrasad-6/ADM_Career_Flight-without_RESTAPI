
package com.example.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pojo.Flight;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Integer> {



	List<Flight> findAll();

	Stream<Flight> findByOriginAndFlightDate(String origin, LocalDate flightDate);

	public List<Flight> findByFlightDateAndOriginAndDestination(LocalDate flightDate, String origin,
			String destination);

	public List<Flight> findByFlightNumberAndOriginAndDestination(String flightNumber, String origin,
			String destination);

	public List<Flight> findByFlightDateAndOrigin(LocalDate flightDate, String origin);

	@Query("from Flight f, FlightInfo fI, FlightsInfo fsI, AirlineInfo aI where f.flightInfo = fI.flightInfoid and f.flightDate = :flightDate and fI.flightInfoid = fsI.flightInfo and fsI.airline = aI.airlineId and aI.nameOfAirline =:airline")
	public List<Flight> findByAirlineAndFlightDate(String airline, LocalDate flightDate);
}






/*
 * public List<Flight> findByFlightDateAndOriginAndDestination(LocalDate
 * flightDate, String origin, String destination);
 * 
 * public Flight findByFlightNumberAndFlightDateAndFlightTime(String
 * flightNumber, LocalDate flightDate, LocalTime flightTime);
 */