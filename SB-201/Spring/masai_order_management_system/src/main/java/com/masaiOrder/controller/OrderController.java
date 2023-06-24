package com.masaiOrder.controller;

import com.masaiOrder.model.Item;
import com.masaiOrder.model.Order;
import com.masaiOrder.service.OrderedService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/masaiOrder")
public class OrderController {

    @Autowired
    private OrderedService orderService;

    @PostMapping("/orders")
    public ResponseEntity<Order> saveOrder(@Valid @RequestBody Order order){
        Order o = orderService.createOrder(order);
        return new ResponseEntity<>(o, HttpStatus.OK);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> viewAllOrder(){
        List<Order> orderList = orderService.allOrder();
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @GetMapping("/orders/{oId}")
    public ResponseEntity<Order> viewOrderById(@PathVariable Integer oId){
        Order order = orderService.orderById(oId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/orders/{oId}")
    public ResponseEntity<Order> updateOrderById(@RequestBody Item item, @PathVariable Integer oId){
        Order order = orderService.updateOrder(oId,item);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @DeleteMapping("/orders/{oId}")
    public ResponseEntity<Order> deleteOrderById(@PathVariable Integer oId){
        Order order = orderService.deleteOrder(oId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/orders/name")
    public ResponseEntity<List<Order>> viewAllOrderByCusName(@RequestParam String customerName){
        List<Order> orderList = orderService.allOrderByCustomerName(customerName);
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @GetMapping("/orders/date")
    public ResponseEntity<List<Order>> viewAllOrderByStrAndEndDate(@RequestParam String startDate, @RequestParam String endDate){
        List<Order> orderList = orderService.allOrderBetweenDate(LocalDate.parse(startDate),LocalDate.parse(endDate));
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @GetMapping("/orders/revenue")
    public ResponseEntity<Integer> viewRevenue(@RequestParam String startDate, @RequestParam String endDate){
        Integer revenue = orderService.totalRevenueOnDate(LocalDate.parse(startDate),LocalDate.parse(endDate));
        return new ResponseEntity<>(revenue, HttpStatus.OK);
    }

}
