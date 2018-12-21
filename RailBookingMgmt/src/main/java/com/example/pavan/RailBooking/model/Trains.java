package com.example.pavan.RailBooking.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

@Entity
public class Trains {

	@javax.persistence.Id
	@GeneratedValue
	@Column(name="TRAIN_NO")
	private int Id;
	
	
	@Column(name="SEATS_AVAILABLE",nullable=true)
	private int seats;
	
	@Column(name="SOURCE_STATION",nullable=true)
	private String source;
	
	@Column(name="DESTINANTION_STATION",nullable=true)
	private String destination;
	
	@OneToMany(targetEntity=Passenger.class,cascade=CascadeType.DETACH)
//	@JoinColumn(name="TRAIN_NO",referencedColumnName="TRAIN_NO")
	private List<Passenger> passenger = new ArrayList<>();
	
	
//	@Column(name="DEPT_TIME")
//	private LocalDate depatureTime;
//	
//	@Column(name="ARRIVAL_TIME")
//	private LocalDate arrivalTime;
	
//	@Column(columnDefinition = "enum('SUN','MON','TUE','WED','THU','FRI','SAT')")
//	@Enumerated(EnumType.STRING)
//	private Data runDays;

	public List<Passenger> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}

	public Trains() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trains(int id, int seats, String source, String destination, LocalDate depatureTime, LocalDate arrivalTime) {
		super();
		Id = id;
		this.seats = seats;
		this.source = source;
		this.destination = destination;
//		this.depatureTime = depatureTime;
//		this.arrivalTime = arrivalTime;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

//	public LocalDate getDepatureTime() {
//		return depatureTime;
//	}
//
//	public void setDepatureTime(LocalDate depatureTime) {
//		this.depatureTime = depatureTime;
//	}
//
//	public LocalDate getArrivalTime() {
//		return arrivalTime;
//	}
//
//	public void setArrivalTime(LocalDate arrivalTime) {
//		this.arrivalTime = arrivalTime;
//	}

	@Override
	public String toString() {
		return "Trains [Id=" + Id + ", seats=" + seats + ", source=" + source + ", destination=" + destination
				+ " ]";
	};
	
}
