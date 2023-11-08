package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

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

//    CANCEL A FLIGHT BY ID
    public void cancelFlight(Long id){
        flightRepository.deleteById(id);
    }

//    ADD PASSENGER TO FLIGHT
    @Transactional
    public Passenger addPassengerToFlight(Long flightId, Long passengerId) {
        Flight flight = flightRepository.findById(flightId).get();
        Passenger passenger = passengerRepository.findById(passengerId).get();
        flight.addPassengers(passenger);
        flightRepository.save(flight);
        return passenger;
   }

}
