package com.masai.controller;

import com.masai.model.Mechanic;
import com.masai.repository.MechanicRepository;
import com.masai.service.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MechanicController {

    @Autowired
    private MechanicService mechanicService;

    @PostMapping("/createM")
    public ResponseEntity<Mechanic> createMechanicHandler(@RequestBody Mechanic mechanic, @RequestParam Integer carId){
        Mechanic m = mechanicService.createMechanic(mechanic, carId);
        return new  ResponseEntity<Mechanic>(m,HttpStatus.OK);
    }

    @GetMapping("/create/{mId}")
    public ResponseEntity<Mechanic> viewMechanicHandler(@PathVariable Integer mId){
        Mechanic m = mechanicService.mechanicById(mId);
        return new  ResponseEntity<Mechanic>(m,HttpStatus.OK);
    }

}
