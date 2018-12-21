package com.example.pavan.RailBooking.service;

import java.util.Optional;

import com.example.pavan.RailBooking.model.Passenger;

public interface PassengerService {
	
	public Passenger reservation(Passenger pass); 
	
	public Optional<Passenger> viewStatus(String pnr);
	
	public Optional<Passenger> Cancellation(String pnr);
}
