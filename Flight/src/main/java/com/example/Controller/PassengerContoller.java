package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.Passenger;
import com.example.service.PassengerService;



@RestController
@RequestMapping("/Passenger")
public class PassengerContoller {
	
	@Autowired
	private PassengerService passengerservice;
	
	@RequestMapping("/getAllPassengers")
	public List<Passenger> getAllPssenegrs() {
		return passengerservice.allPassengers();
	}
	
}
