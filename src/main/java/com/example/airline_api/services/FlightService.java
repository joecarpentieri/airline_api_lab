package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

//    ADD DETAILS OF A NEW FLIGHT
    public void addFlightDetails(Flight flight){
        flightRepository.save(flight);
    }

//    DISPLAY ALL FLIGHTS
    public List<Flight> displayAllFlights(){
        return flightRepository.findAll();
    }

//    DISPLAY SPECIFIC FLIGHT'S DETAILS
    public Flight displayFlightById(Long flightId){
        return flightRepository.findById(flightId).get();
    }

}
