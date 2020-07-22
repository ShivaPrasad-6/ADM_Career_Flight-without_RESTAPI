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

import com.example.pojo.Fare;
import com.example.service.FareService;

@RestController
@RequestMapping("/Fare")
public class FareController {

	@Autowired
	private FareService fareservice;

	@RequestMapping("/getAllFares")
	public List<Fare> getAllFares() {
		return fareservice.allFares();
	}

	@PostMapping("/saveFare")
	public Fare saveFare(@RequestBody Fare flight) {
		return fareservice.saveFare(flight);
	}

	@PutMapping("/updateFlight/{fareId}")
	public Fare updateFareById(@RequestBody Fare fare, @PathVariable("id") Integer fareId) {
		return fareservice.updateFare(fare, fareId);

	}

	@DeleteMapping("/deleteFlight/{fareId}")
	public int deleteFare(@PathVariable("fareId") Integer fareId) {
		return fareservice.deleteFare(fareId);
	}

	@GetMapping("/findOneInAll/{fareId}")
	public Optional<Fare> findFareInAll(@PathVariable("fareId") Integer fareId) {
		return fareservice.findFareById(fareId);

	}

}
