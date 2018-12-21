package com.example.pavan.RailBooking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pavan.RailBooking.model.Trains;

@Repository("trainRepo")
public interface RailRepository extends CrudRepository<Trains, Integer> {


	

}
