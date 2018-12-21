package com.example.pavan.RailBooking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.pavan.RailBooking.model.Trains;

public interface TrainService {
	
	public Trains addTrain(Trains train); 
	
	public Trains updTrain(Trains train); 
	
	public List<Trains> viewAll(); 
	
	public Optional<Trains> findTrain(int trainNo); 
	
	public Optional<Trains> removeTrain(int trainNo); 
	
	public ArrayList<Trains> addAllTrains(ArrayList<Trains> trains); 
	
//	public Optional<Trains> updateTrainSeat(int trainNo);
}
