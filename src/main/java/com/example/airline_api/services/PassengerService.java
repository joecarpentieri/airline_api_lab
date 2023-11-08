package com.example.airline_api.services;

import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

//    add new passenger
    public void addNewPassenger(Passenger passenger){
        passengerRepository.save(passenger);
    }

//    find all passengers
    public List<Passenger> findAllPassengers(){
        return passengerRepository.findAll();
    }

//    find passenger by id
    public Passenger findPassengerById(Long passengerId){
        return passengerRepository.findById(passengerId).get();
    }

    //

}
