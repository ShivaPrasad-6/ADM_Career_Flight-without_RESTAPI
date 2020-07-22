package com.example.pojo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="flightInfo")
public class FlightInfo {
	
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "flight_infoid")
	@Id
	@GeneratedValue
	private long flightInfoid;
	private String flightNumber;
	private String flightType;
	private int numberofSeats;

}
