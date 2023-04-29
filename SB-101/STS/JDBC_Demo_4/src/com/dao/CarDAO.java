package com.dao;

import com.dto.CarDTO;
import com.exception.NoRecordFound;
import com.exception.SomeThingWentWrongException;

public interface CarDAO {
     public void addCar(CarDTO car) throws SomeThingWentWrongException;
     public void showAllInfromationAboutCar() throws SomeThingWentWrongException, NoRecordFound;
     public void updateCar(CarDTO car) throws SomeThingWentWrongException;
     public void deleteCar(String carId) throws SomeThingWentWrongException, NoRecordFound;
     public void showCompNameModel() throws SomeThingWentWrongException, NoRecordFound;
}
