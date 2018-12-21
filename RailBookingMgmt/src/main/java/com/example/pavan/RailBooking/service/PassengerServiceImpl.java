package com.example.pavan.RailBooking.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pavan.RailBooking.model.Passenger;
import com.example.pavan.RailBooking.repository.BookingRepository;

@Service("passService")
public class PassengerServiceImpl implements PassengerService {
//	private Trains train = new Trains();
//	
//	private TrainServiceImpl trServ = new TrainServiceImpl();
	
	private static final Logger log = LoggerFactory.getLogger(PassengerServiceImpl.class);


	@Autowired
	private BookingRepository bookingRepo;
	
	@Override
	public Passenger reservation(Passenger pass) {
		
//		pass.setTrain(train);
		bookingRepo.save(pass);
		log.info("Reservation confirmed for :"+pass.getLastName()+" "+pass.getFirstName());
		log.info("passenger's PNR no =" +pass.getPnr());
		return pass;
	}

	@Override
	public Optional<Passenger> viewStatus(String pnr) {
		log.info("searching passengers travel details for PNR: "+pnr);
		return bookingRepo.findById(pnr);
		
	}

	@Override
	public Optional<Passenger> Cancellation(String pnr) {
		Optional<Passenger> pass = bookingRepo.findById(pnr);
		bookingRepo.deleteById(pnr);;
		return pass;
	}

}
