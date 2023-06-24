package com.masaiOrder.service;

import com.masaiOrder.component.MyComponent;
import com.masaiOrder.exception.CustomerException;
import com.masaiOrder.exception.OrderException;
import com.masaiOrder.model.Customer;
import com.masaiOrder.model.Item;
import com.masaiOrder.model.Order;
import com.masaiOrder.repository.CustomerRepository;
import com.masaiOrder.repository.OrderRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderedService{
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MyComponent component;


    @Override
    public Order createOrder(Order order) throws CustomerException {
        if(order == null) throw new OrderException("Not find any order");
        String email = component.getCurrentUsername();
        Customer customer = customerRepository.findByEmail(email).orElseThrow(() -> new CustomerException("Customer Not found with Email: " + email));
        order.setCustomer(customer);
        customer.getOrderList().add(order);
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Integer oId, Item item) throws OrderException {
        Order order = orderRepository.findById(oId).orElseThrow(() -> new OrderException("Not find any order with id: " + oId));
        order.setItem(item);
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order deleteOrder(Integer oId) throws OrderException {
        Order order = orderRepository.findById(oId).orElseThrow(() -> new OrderException("Not find any order with id: " + oId));
        orderRepository.delete(order);
        return order;
    }

    @Override
    public List<Order> allOrder() throws OrderException {
        List<Order> orderList = orderRepository.findAll();
        if(orderList.isEmpty()) throw new OrderException("Not found any order");
        return orderList;
    }

    @Override
    public Order orderById(Integer oId) throws OrderException {
        Order order = orderRepository.findById(oId).orElseThrow(() -> new OrderException("Not find any order with id: " + oId));
        return order;
    }

    @Override
    public List<Order> allOrderByCustomerName(String customerName) throws OrderException, CustomerException {
        Customer customer = customerRepository.findByName(customerName);
        if(customer != null) throw new CustomerException("Not found any customer with id: " + customerName);
        List<Order> orderList = customer.getOrderList();
        if(orderList.isEmpty()) throw new OrderException("Not find any order");
        return orderList;
    }

    @Override
    public List<Order> allOrderBetweenDate(LocalDate str, LocalDate end) throws OrderException {
        List<Order> orderList = orderRepository.findByOrderDateBetween(str, end);
        if(orderList.isEmpty()) throw new OrderException("Not find any order between " + str + " and " + end);
        return orderList;
    }

    @Override
    public Integer totalRevenueOnDate(LocalDate str, LocalDate end) throws OrderException {
        List<Order> orderList = orderRepository.findByOrderDateBetween(str, end);
        if(orderList.isEmpty()) throw new OrderException("Not find any order between " + str + " and " + end);
        Integer total = 0;
        for(Order o : orderList) total += o.getItem().getPrice();
        return total;
    }
}
