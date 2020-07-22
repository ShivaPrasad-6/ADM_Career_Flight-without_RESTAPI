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
@Table(name = "passenger")
public class Passenger {

	@Id
	@GeneratedValue
	private long passengerId;
	private String emailAddress;
	private String firstName;
	private String gender;
	private String lastName;
	private long mobileNumber;
	private long bookingId;

}
