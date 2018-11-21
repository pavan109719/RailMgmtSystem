package com.example.pavan.RailBooking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pavan.RailBooking.model.Passenger;

@Repository("bookingRepo")
public interface BookingRepository extends CrudRepository<Passenger, String> {

}
