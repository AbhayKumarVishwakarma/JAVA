package com.masai.service;

import com.masai.exception.CarException;
import com.masai.exception.MechanicException;
import com.masai.model.Car;
import com.masai.model.Mechanic;
import com.masai.repository.CarRepository;
import com.masai.repository.MechanicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MechanicServiceImpl implements MechanicService{

    @Autowired
    private MechanicRepository mechanicRepository;

    @Autowired
    private CarRepository carRepository;

    @Override
    public Mechanic createMechanic(Mechanic mechanic, Integer carId) throws CarException {
        Car car = carRepository.findById(carId).orElseThrow( () -> new CarException("Not find any car with id: " + carId));
        car.getMechanicList().add(mechanic);
        mechanic.getCarList().add(car);
        return mechanicRepository.save(mechanic);
    }

    @Override
    public Mechanic mechanicById(Integer mechanicId) throws MechanicException {
        return mechanicRepository.findById(mechanicId).orElseThrow( () -> new MechanicException("Not found any mechanic with id: " + mechanicId));
    }
}
