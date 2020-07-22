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

import com.example.pojo.AirlineInfo;
import com.example.service.AirlineInfoService;

@RestController
@RequestMapping("/AirlineInfo")
public class AirlineInfoController {

	@Autowired
	private AirlineInfoService airlineservice;

	@RequestMapping("/getAllAirlines")
	public List<AirlineInfo> getAllAirlineInfo() {
		return airlineservice.airlineInfo();
	}

	@PostMapping("/saveAirline")
	public AirlineInfo saveAirlineInfo(@RequestBody AirlineInfo airlineInfo) {
		return airlineservice.saveAirlineInfo(airlineInfo);
	}

	@PutMapping("/updateAirlines/{airlineId}")
	public AirlineInfo updateAirlineInfoById(@RequestBody AirlineInfo airlineInfo,
			@PathVariable("airlineId") Long airlineId) {
		return airlineservice.updateAirlineInfo(airlineInfo, airlineId);

	}

	@DeleteMapping("/deleteAirlines/{airlineId}")
	public String deleteAirlineInfo(@PathVariable("fareId") Long airlineId) {
		return airlineservice.deleteAirlineInfo(airlineId);
	}

	@GetMapping("/findOneInAll/{airlineId}")
	public Optional<AirlineInfo> findAirlineInfoInAll(@PathVariable("airlineId") Long airlineId) {
		return airlineservice.findAirlineInfoById(airlineId);

	}

}
