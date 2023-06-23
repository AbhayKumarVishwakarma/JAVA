package com.masaiOrder.repository;

import java.time.LocalDate;
import java.util.*;

import com.masaiOrder.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order,Integer> {
//    public Order findByOrderID(Integer id);

    @Query("select o from order o where orderDate between ?1 and ?2")
    public List<Order> findBetweenDate(LocalDate str, LocalDate end);

    @Query("select o from order o where orderDate = ?1")
    public List<Order> findByDate(LocalDate date);
}
