package com.example.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.FlightInfo;
import com.example.service.FlightInfoService;

@RestController
@RequestMapping("/FlightInfo")
public class FlightInfoController {
	
	@Autowired
	private FlightInfoService flightinfoservice;

	@GetMapping("/getAllFlightsInfo")
	public List<FlightInfo> getAllFlights() {
		return flightinfoservice.findAllFlightInfo();
	}

	@PostMapping("/saveFlightInfo")
	public FlightInfo saveFlightInfo(@RequestBody FlightInfo flight) {
		return flightinfoservice.saveFlightInfo(flight);
	}

//	@PutMapping("/updateFlightInfo/{id}")
//
//	public FlightInfo updateFlightInfoById(@RequestBody FlightInfo flight, @PathVariable("id") Long flightInfoId) {
//		return flightinfoservice.updateFlightInfo(flight, flightInfoId);
//
//	}

	@DeleteMapping("/deleteFlightInfo/{id}")
	public String deleteFlightInfo(@PathVariable("flightInfoId") Long flightInfoId) {
		return flightinfoservice.deleteFlightInfo(flightInfoId);
	}
	
	@GetMapping("/findOneInAll/{id}")
	public Optional<FlightInfo> findFlightInfoInAll(@PathVariable("flightInfoId") Long flightInfoId)
	{
		return flightinfoservice.findFlightInfoById(flightInfoId);
		
	}

}
