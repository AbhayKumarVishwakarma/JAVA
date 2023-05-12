package com.masai.dao;

import com.masai.exception.NotFoundException;
import com.masai.modul.Item;
import com.masai.modul.Order;

import java.sql.Date;
import java.util.List;

public interface OrderDao {
    public void createOrder(Order order);
    public void createItem(Item item, int orderId) throws NotFoundException; //[Points: 0.5 ]**
            //- this method should create a item and associate with an order.

    public void createItems(List<Item> items, int orderId) throws NotFoundException;  //[Points: 1 ]**
            //- this method should create multiple item and associate with an order.

    public void getItem(int itemId) throws NotFoundException;  //[Points: 0.5 ]**
            //- This method should get item details along with the order details
            //- If the Item is not present then throw Item **Not Found Exception**

    public void getOrder(int orderId) throws NotFoundException; //[Points: 0.5 ]**
            //- This method should get order details along with the details of all the items associated with that order
            //- If the Order is not present then throw Order **Not Found Exception**

    public void getItems(Date inputDate) throws NotFoundException; //[Points: 1 ]**
            //- This method should get all item details whose delivery date is greater than inputDate.
            //- If there are no Items Whose delivery date greater than inputDate then print “All Items are expected to be deliver on time”.
}
