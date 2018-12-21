package com.example.pavan.RailBooking.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pavan.RailBooking.model.Passenger;
import com.example.pavan.RailBooking.model.Trains;
import com.example.pavan.RailBooking.service.PassengerServiceImpl;
import com.example.pavan.RailBooking.service.TrainServiceImpl;

@RestController
public class RailController {

	private static final Logger log = LoggerFactory.getLogger(RailController.class);

	@Autowired
	private TrainServiceImpl trainService;

	@Autowired
	private PassengerServiceImpl passService;

	@PostMapping(path = "/booking")
	public ResponseEntity<Passenger> booking(@RequestBody Passenger pass) throws Exception {

		int trainNo = pass.getTrain().getId();
		String dest = pass.getTrain().getDestination();
		String source = pass.getTrain().getSource();

		Optional<Trains> t = searchTrain(trainNo);
		Trains tr = new Trains();
		tr.setId(trainNo);
		tr.setDestination(dest);
		tr.setSource(source);
		System.out.println(t);
		int availableSeat = t.get().getSeats();
		System.out.println("total seats :" + availableSeat);
		if (availableSeat > 0) {
			passService.reservation(pass);
			tr.setSeats(--availableSeat);
			updateTrain(tr, trainNo);
		}
		else {
			log.info("No Seats Available ",HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS );
		}

		return new ResponseEntity<Passenger>(HttpStatus.CREATED);
	}

	@GetMapping(path = "/booking/{pnr}")
	public Optional<Passenger> checkStatus(@PathVariable String pnr) {
		return passService.viewStatus(pnr);
	}

	@PostMapping(path = "/rail")
	public ResponseEntity<Trains> addTrain(@RequestBody Trains train) {
		return new ResponseEntity<Trains>(trainService.addTrain(train), HttpStatus.CREATED);
	}

	@GetMapping(path = "/rail")
	public ResponseEntity<List<Trains>> trailList() {
		return new ResponseEntity<List<Trains>>(trainService.viewAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/rail/{trainId}")
	public Optional<Trains> searchTrain(@PathVariable int trainId) {
		return trainService.findTrain(trainId);
	}

	@DeleteMapping(path = "/rail/{trainId}")
	public Optional<Trains> deleteTrain(@PathVariable int trainId) {
		return trainService.removeTrain(trainId);
	}

	@PostMapping(path = "/rails")
	public ResponseEntity<ArrayList<Trains>> add(@RequestBody ArrayList<Trains> trains) throws Exception {
		return new ResponseEntity<ArrayList<Trains>>(trainService.addAllTrains(trains), HttpStatus.CREATED);
	}

	@PutMapping(path = "/rail")
	public Optional<Trains> updateTrain(@RequestBody Trains train, @PathVariable int trainId) {
		trainService.addTrain(train);
		return null;

	}

	@PutMapping(path = "/passenger")
	public Optional<Trains> updatePassenger(@RequestBody Passenger pass, @PathVariable int trainId) {
		passService.reservation(pass);
		return null;

	}
}
