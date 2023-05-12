package com.demo.dao;

import com.demo.modul.Customer;

public interface DNA_WifiDAO {
    Customer findCustomerById(int id) ;
    String saveCustomer(Customer Customer);
    String deleteCustomerById(int id) ;
    String updatePrice(int new_price,int id);
    // Replacing the existing price with the new price for the particular customer
    // having given id

    String recharge(int data_Gb,int id);
    // Add the data_Gb to the older data_Gb for the particular customer
    // having given id
}
