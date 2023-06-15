package com.masai.controller;

import com.masai.model.Car;
import com.masai.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/carC")
    public ResponseEntity<Car> createCarHandler(@RequestBody Car car, @RequestParam Integer modalId){
        Car c = carService.createCar(car, modalId);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @PutMapping("/carU/{carId}")
    public ResponseEntity<Car> updateCarHandler(@RequestBody Car car, @PathVariable Integer carId){
        Car c = carService.updateCar(carId, car);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @DeleteMapping("/carD/{carId}")
    public ResponseEntity<Car> deleteCarHandler(@PathVariable Integer carId){
        Car c = carService.deleteCar(carId);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @GetMapping("/car/{carId}")
    public ResponseEntity<Car> viewCarHandler(@PathVariable Integer carId){
        Car c = carService.carById(carId);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @GetMapping("/carAll")
    public ResponseEntity<List<Car>> allCarHandler(){
        List<Car> c = carService.allCar();
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

}
