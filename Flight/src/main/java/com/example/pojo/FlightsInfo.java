package com.example.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "flightsInfo")
public class FlightsInfo implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "flight_infoid")
	private FlightInfo flightInfo;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "airline_id")
	private AirlineInfo airline;
}