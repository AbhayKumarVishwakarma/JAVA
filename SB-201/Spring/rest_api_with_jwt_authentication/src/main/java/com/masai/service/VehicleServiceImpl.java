package com.masai.service;

import com.masai.component.MyComponent;
import com.masai.exception.CustomerException;
import com.masai.exception.VehicleException;
import com.masai.model.Customer;
import com.masai.model.Vehicle;
import com.masai.repository.CustomerRepository;
import com.masai.repository.VehicleRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MyComponent component;

    @Override
    public Vehicle addVehicle(Vehicle vehicle, Integer cusId) throws CustomerException, VehicleException {
        Customer customer = customerRepository.findById(cusId).orElseThrow(() -> new CustomerException("Not found any customer with id: " + cusId));
        if(vehicle == null) throw new VehicleException("Not found any vehicle, Please provide valid Vehicle!");
        customer.getVehicleList().add(vehicle);
        vehicle.setCustomer(customer);
        customerRepository.save(customer);
        return vehicle;
    }

    @Override
    public List<Vehicle> getAllVehicle() throws VehicleException, CustomerException {
        String username = component.getCurrentUsername();
        Optional<Customer> opt = customerRepository.findByEmail(username);
        Customer c = opt.get();
        System.out.println(c);


        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()) throw new VehicleException("Not found any vehicle!");
        return vehicleList;
    }

    @Override
    public Vehicle getVehicleByID(Integer vId) throws VehicleException, CustomerException {
//        Vehicle vehicle = vehicleRepository.findById(vId).orElseThrow(() -> new ValidationException("Not found any vehicle with id: " + vId));
//        Customer customer = vehicle.getCustomer();

        return vehicleRepository.findById(vId).orElseThrow(() -> new ValidationException("Not found any vehicle with id: " + vId));
    }

    @Override
    public Vehicle updateVehicleByID(Integer vId, Vehicle v) throws VehicleException, CustomerException {
        Vehicle vehicle = vehicleRepository.findById(vId).orElseThrow(() -> new ValidationException("Not found any vehicle with id: " + vId));
        vehicle.setName(v.getName());
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle deleteVehicleByID(Integer vId) throws VehicleException, CustomerException {
        Vehicle vehicle = vehicleRepository.findById(vId).orElseThrow(() -> new ValidationException("Not found any vehicle with id: " + vId));
        vehicleRepository.delete(vehicle);
        return vehicle;
    }
}
