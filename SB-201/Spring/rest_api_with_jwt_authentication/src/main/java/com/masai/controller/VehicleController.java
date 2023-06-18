package com.masai.controller;

import com.masai.model.Vehicle;
import com.masai.repository.VehicleRepository;
import com.masai.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/customer/{cusId}/vehicle")
    public ResponseEntity<Vehicle> createVehicleHandler(@Valid @RequestBody Vehicle vehicle, @PathVariable Integer cusId){
        Vehicle v = vehicleService.addVehicle(vehicle, cusId);
        return new ResponseEntity<>(v, HttpStatus.CREATED);
    }

    @GetMapping("/vehicles") //eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJNYXNhaSIsInN1YiI6IkpXVCBUb2tlbiIsInVzZXJuYW1lIjoiYW5raXRAZ21haWwuY29tIiwiYXV0aG9yaXRpZXMiOiJST0xFX0FETUlOIiwiaWF0IjoxNjg3MDU1MzI5LCJleHAiOjE2ODcxNDE3Mjl9.c-BHCN4XKzMwMlV-1xfFvUyIIOahlWHXjXnDZRPUXTo
    public ResponseEntity<List<Vehicle>> viewAllVehicleHandler(){
        List<Vehicle> vehicleList = vehicleService.getAllVehicle();
        System.out.println(vehicleList);
        return new ResponseEntity<>(vehicleList, HttpStatus.OK);
    }

    @GetMapping("/vehicle/{vId}")
    public ResponseEntity<Vehicle> searchVehicleHandler(@PathVariable Integer vId){
        Vehicle vehicle = vehicleService.getVehicleByID(vId);
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }

    @PutMapping("/vehicle/{vId}")
    public ResponseEntity<Vehicle> updateVehicleHandler(@PathVariable Integer vId, @RequestBody Vehicle v){
        Vehicle vehicle = vehicleService.updateVehicleByID(vId,v);
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }

    @DeleteMapping("/vehicle/{vId}")
    public ResponseEntity<Vehicle> deleteVehicleHandler(@PathVariable Integer vId){
        Vehicle vehicle = vehicleService.deleteVehicleByID(vId);
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }

}
