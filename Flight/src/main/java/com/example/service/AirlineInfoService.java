package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pojo.AirlineInfo;
import com.example.repository.AirlineInfoRepository;

@Service
public class AirlineInfoService {
	
	@Autowired
	private AirlineInfoRepository airlineinforepository;
	
	public List<AirlineInfo> airlineInfo() {
		return airlineinforepository.findAll();
	}
	
	public AirlineInfo saveAirlineInfo(AirlineInfo airlineId) {
		return airlineinforepository.save(airlineId);
	}

	public AirlineInfo updateAirlineInfo(AirlineInfo airlineInfo, Long airlineId) {
		airlineInfo.setAirlineId(airlineId);
		return airlineinforepository.save(airlineInfo);
	}

	public String deleteAirlineInfo(Long airlineId) {

		System.out.println("dtl starting");
		Optional<AirlineInfo> airlineInfo = airlineinforepository.findById(airlineId);
		AirlineInfo fly = airlineInfo.get();
		String num = fly.getNameOfAirline();
		airlineinforepository.delete(airlineInfo.get());
		System.out.println("Deleted flight number is: " + num);
		return num;
	}

	public Optional<AirlineInfo> findAirlineInfoById(Long airlineId) {

		Optional<AirlineInfo> airlineInfo = airlineinforepository.findById(airlineId);
		return Optional.ofNullable(airlineInfo.get());
	}
}
