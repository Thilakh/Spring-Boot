package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Request.Request;
import com.example.demo.model.FlightBooking;
import com.example.demo.service.FlightService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/flightticketbooking")

public class FlightController {
    @Autowired
    FlightService service;

    public FlightController(FlightService service) {
        this.service = service;
    }

    @PostMapping("/signup")
    public FlightBooking SavingData(@RequestBody Request e) {
        return service.creation(e.getObj());
    }

    @GetMapping("/profile")
    public List<FlightBooking> detailsprinting() {
        return service.DataPrinting();
    }

    // @GetMapping("/profile/{userid}")
    // public getMedicineById(@PathVariable int userid){
    // Medicine medicine=medicineService.getMedicineById(userid);
    // if(medicine!=null){
    // return new ResponseEntity<>(medicine,HttpStatus.OK);
    // }
    // else{
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
    @GetMapping("/profilespage/{pageno}/{pagesize}")
    public List<FlightBooking> getpage(@PathVariable int pageno, @PathVariable int pagesize) {
        return service.pagination(pageno, pagesize);
    }

    @PutMapping("/profileupdate/{userid}")
    public FlightBooking dataupdating(@PathVariable int userid, @RequestBody FlightBooking flight) {
        return service.update(userid, flight);
    }

    @GetMapping("/sorting/{username}")
    public List<FlightBooking> sortedlist(@PathVariable String username) {
        return service.sortingbyname(username);
    }

    @DeleteMapping("/profiledelete/{userid}")
    public Boolean delete(@PathVariable int userid) {
        return service.delete(userid);
    }

}
