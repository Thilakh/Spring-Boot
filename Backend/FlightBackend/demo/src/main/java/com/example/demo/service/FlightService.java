package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FlightBooking;
import com.example.demo.repository.FlightRepo;

@Service
public class FlightService {
    @Autowired
    FlightRepo repo;

    public FlightService(FlightRepo repo) {
        this.repo = repo;
    }

    public FlightBooking creation(FlightBooking flight) {
        return repo.save(flight);
    }

    public List<FlightBooking> DataPrinting() {
        return repo.findAll();
    }

    public FlightBooking Id(int Userid) {
        return repo.findById(Userid).orElse(null);

    }

    public FlightBooking update(int Userid, FlightBooking flight) {
        FlightBooking obj = repo.findById(Userid).orElse(null);
        if (obj != null) {
            obj.setEmail(flight.getEmail());
            obj.setUsername(flight.getUsername());
            obj.setPassword(flight.getPassword());
            obj.setPhonenumber(flight.getPhonenumber());
            return repo.save(obj);
        }
        return flight;
    }

    public boolean delete(int Userid) {
        repo.deleteById(Userid);
        return true;
    }
}