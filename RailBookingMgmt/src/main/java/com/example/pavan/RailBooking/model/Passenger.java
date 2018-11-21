package com.example.pavan.RailBooking.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Passenger {
	
	@Id
	@GenericGenerator(name = "sequence_id", strategy = "com.example.pavan.RailBooking.PnrGenerator.PNRGenerator")
	@GeneratedValue(generator = "sequence_id") 
	@Column(name="PNR")
	private String pnr;
	


	@ManyToOne
	@JoinColumn(name="TRAIN_NO",referencedColumnName="TRAIN_NO")
	private Trains train;
	

	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="JOURNEY_DATE")
	private LocalDate travelDate;
	



	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Passenger(String pnr, Trains train, String firstName, String lastName, String email, LocalDate travelDate) {
		super();
		this.pnr = pnr;
		this.train = train;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.travelDate = travelDate;
	}

	@Override
	public String toString() {
		return "Passenger [pnr=" + pnr + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", travelDate=" + travelDate + "]";
	}
	
	public Trains getTrain() {
		return train;
	}

	public void setTrain(Trains train) {
		this.train = train;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	




}
