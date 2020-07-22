package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pojo.FlightInfo;
import com.example.repository.FlightInfoRepository;

@Service
public class FlightInfoService {

	@Autowired
	private FlightInfoRepository flightinfoRepository;

	public List<FlightInfo> findAllFlightInfo() {
		return flightinfoRepository.findAll();
	}

	public FlightInfo saveFlightInfo(FlightInfo flightinfo) {
		return flightinfoRepository.save(flightinfo);
	}

	/*
	 * public FlightInfo updateFlightInfo(FlightInfo flightinfo, Long flightInfoid)
	 * { flightinfo.setFlightsInfo(flightInfoid); return
	 * flightinfoRepository.save(flightinfo); }
	 */
	public String deleteFlightInfo(Long flightInfoid) {

		System.out.println("dtl starting");
		Optional<FlightInfo> flightinfo = flightinfoRepository.findById(flightInfoid);
		FlightInfo fly = flightinfo.get();
		String num = fly.getFlightNumber();
		flightinfoRepository.delete(flightinfo.get());
		System.out.println("Deleted flight number is: " + num);
		return num;
	}

	public Optional<FlightInfo> findFlightInfoById(Long flightInfoid) {

		Optional<FlightInfo> flight = flightinfoRepository.findById(flightInfoid);
		return Optional.ofNullable(flight.get());
	}

	
}
