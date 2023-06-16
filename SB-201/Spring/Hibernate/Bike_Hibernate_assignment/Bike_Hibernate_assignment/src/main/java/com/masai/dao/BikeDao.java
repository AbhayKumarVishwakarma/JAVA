package com.masai.dao;

import java.util.*;

import com.masai.exception.BikeException;
import com.masai.model.Bike;

public interface BikeDao {
    public String crateBike(Bike bike);
    public String updateBike(String id, Bike bike) throws BikeException;
    public String deleteBike(String id) throws BikeException;
    public Bike viewBikeById(String id) throws BikeException;
    public List<Bike> searchByPriceRange(Integer str, Integer end) throws BikeException;
    public List<Bike> sortByPriceDesc() throws BikeException;
    public List<Bike> distinctBrands() throws BikeException;
}
