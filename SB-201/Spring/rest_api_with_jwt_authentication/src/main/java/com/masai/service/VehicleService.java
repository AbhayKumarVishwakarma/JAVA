package com.masai.service;

import com.masai.exception.CustomerException;
import com.masai.exception.VehicleException;
import com.masai.model.Vehicle;

import java.util.List;

public interface VehicleService {
    public Vehicle addVehicle(Vehicle vehicle, Integer cusId) throws CustomerException, VehicleException;
    public List<Vehicle> getAllVehicle() throws VehicleException, CustomerException;
    public Vehicle getVehicleByID(Integer vId) throws VehicleException, CustomerException;
    public Vehicle updateVehicleByID(Integer vId, Vehicle v) throws VehicleException, CustomerException;
    public Vehicle deleteVehicleByID(Integer vId) throws VehicleException, CustomerException;
}