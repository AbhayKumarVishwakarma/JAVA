package com.masai.service;

import com.masai.exception.CarException;
import com.masai.exception.ModalException;
import com.masai.model.Car;
import com.masai.model.Modal;
import com.masai.repository.CarRepository;
import com.masai.repository.ModalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ModalRepository modalRepository;

    @Override
    public Car createCar(Car car, Integer modalId) throws ModalException {
        Modal modal = modalRepository.findById(modalId).orElseThrow( () -> new ModalException("Not find any modal with id: " + modalId));
        car.setModal(modal);
        modal.getCarList().add(car);
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(Integer carId, Car c) throws CarException {
        Car car = carRepository.findById(carId).orElseThrow( () -> new CarException("Not find any car with id: " + carId));
        if(c.getRegistrationNumber() != null) car.setRegistrationNumber(c.getRegistrationNumber());
        if(c.getMfgYear() != 0) car.setMfgYear(c.getMfgYear());
        return carRepository.save(car);
    }

    @Override
    public Car deleteCar(Integer carId) throws CarException {
        Car car = carRepository.findById(carId).orElseThrow( () -> new CarException("Not find any car with id: " + carId));
        carRepository.delete(car);
        return car;
    }

    @Override
    public Car carById(Integer carId) throws CarException {
        return carRepository.findById(carId).orElseThrow( () -> new CarException("Not find any car with id: " + carId));
    }

    @Override
    public List<Car> allCar() throws CarException {
        List<Car> carList = carRepository.findAll();
        if(carList.isEmpty()) throw new CarException("Not found any car!");
        return carList;
    }
}
