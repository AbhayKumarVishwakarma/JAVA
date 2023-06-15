package com.masai.service;

import com.masai.exception.CarException;
import com.masai.exception.MechanicException;
import com.masai.model.Mechanic;

public interface MechanicService {
    public Mechanic createMechanic(Mechanic mechanic, Integer carId) throws CarException;
    public Mechanic mechanicById(Integer mechanicId) throws MechanicException;
}
