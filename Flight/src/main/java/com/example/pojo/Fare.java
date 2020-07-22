package com.example.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "fare")
public class Fare {
	
	@Id
	@GeneratedValue
	private int fareId;
	private double fareamount;
	private String currency;
	
}
