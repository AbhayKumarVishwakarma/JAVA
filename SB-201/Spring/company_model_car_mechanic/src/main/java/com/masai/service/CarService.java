package com.masai.service;

import com.masai.exception.CarException;
import com.masai.exception.ModalException;
import com.masai.model.Car;

import java.util.List;

public interface CarService {
    public Car createCar(Car car, Integer modalId) throws ModalException;
    public Car updateCar(Integer carId, Car car) throws CarException;
    public Car deleteCar(Integer carId) throws CarException;
    public Car carById(Integer carId) throws CarException;
    public List<Car> allCar() throws CarException;
}
