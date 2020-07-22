package com.example.pojo;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="BookingRecord")
public class BookingRecord {
	
	@Id
	@GeneratedValue
	private long bookingId;
	private LocalTime bookingDate;
	private String destination;
	private double fare;
	private LocalDate flightDate;
	private String flightNumber;
	private LocalTime flightTime;
	private String origin;
	private String status;
 	
}
