package com.example.pavan.RailBooking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pavan.RailBooking.model.Trains;
import com.example.pavan.RailBooking.repository.RailRepository;
@Service("trainService")
public class TrainServiceImpl implements TrainService {

	@Autowired
	private RailRepository trainRepo;
	
	@Override
	public Trains addTrain(Trains train) {
		return trainRepo.save(train);
	}

	@Override
	public List<Trains> viewAll() {
		return (List<Trains>)trainRepo.findAll();
	}

	@Override
	public Optional<Trains> findTrain(int trainNo) {
		return (Optional<Trains>)trainRepo.findById(trainNo);
	}

	@Override
	public Optional<Trains> removeTrain(int trainNo) {
		Optional<Trains> train = trainRepo.findById(trainNo);
		trainRepo.deleteById(trainNo);
		return train ;
	}

	@Override
	public ArrayList<Trains> addAllTrains(ArrayList<Trains> trains) {
		
		return(ArrayList<Trains>) trainRepo.saveAll(trains);
	}

//	@Override
//	public Optional<Trains> updateTrainSeat(int trainNo) {
//		Optional<Trains> tra = findTrain(trainNo);
//		tra.
//		int seats = seats-1;
//		trainRepo.save(tra);
//		return tra;
//	}

}
