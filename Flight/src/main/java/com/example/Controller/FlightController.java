
package com.example.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.Flight;
import com.example.service.FlightService;

@RestController
@RequestMapping("/Flight")
public class FlightController {

	@Autowired
	private FlightService flightservice;

	@GetMapping("/getAllFlights")
	public List<Flight> getAllFlights() {
		return flightservice.getAllFlights();
	}

	@PostMapping("/saveFlight")
	public Flight saveFlight(@RequestBody Flight flight) {
		return flightservice.saveFlight(flight);
	}

	@PutMapping("/updateFlight/{id}")
	public Flight updateFlightById(@RequestBody Flight flight, @PathVariable("id") Integer id) {
		return flightservice.updateFlight(flight, id);

	}

	@DeleteMapping("/deleteFlight/{id}")
	public String deleteFlight(@PathVariable("id") Integer id) {
		return flightservice.deleteFlight(id);
	}

	@GetMapping("/findOneInAll/{id}")
	public Optional<Flight> findFlightInAll(@PathVariable("id") Integer id) {
		return flightservice.findFlightById(id);
	}

	@GetMapping("/Search/airline={airlineId}/date={flightDate}")
	public List<Flight> listAll1(@PathVariable("airlineId") String airlineId,
			@PathVariable("flightDate") String flightDate) {
		List<Flight> flights = flightservice.search1(airlineId, LocalDate.parse(flightDate));
		return flights;
	}

	@GetMapping("/Search/flightdate={flightDate}/origin={origin}")
	public List<Flight> listAll2(@PathVariable("flightDate") String flightDate, @PathVariable("origin") String origin) {

		List<Flight> flights = flightservice.search2(LocalDate.parse(flightDate), origin);
		return flights;
	}

	@GetMapping("/Search/flightdate={flightDate}/origin={origin}/destination={destination}")
	public List<Flight> listAll3(@PathVariable("flightDate") String flightDate, @PathVariable("origin") String origin,
			@PathVariable("destination") String destination) {

		List<Flight> flights = flightservice.search3(LocalDate.parse(flightDate), origin, destination);
		return flights;
	}
	
	@GetMapping("/Search/flightNumber={flightNumber}/origin={origin}/destination={destination}")
	public List<Flight> listAll4(@PathVariable("flightNumber") String flightNumber, @PathVariable("origin") String origin,
			@PathVariable("destination") String destination) {

		List<Flight> flights = flightservice.search4(flightNumber, origin, destination);
		return flights;
	}

}



/*
 * @GetMapping("/Search") public List<Flight> listAll44(@RequestParam(required =
 * true) String flightDate, @RequestParam(name = "origin", defaultValue =
 * "null") String origin, @RequestParam()) {
 * 
 * List<Flight> flights = flightservice .search2(LocalDate.parse(flightDate),
 * origin); return flights; }
 */

/*
 * @RequestMapping("/book") public String
 * bookTicket(@RequestParam("flightNumber") String flightNumber) {
 * System.out.println("====> " + flightNumber); return null; }
 */
