package com.masaiOrder.repository;

import java.time.LocalDate;
import java.util.*;

import com.masaiOrder.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    @Query("SELECT o FROM Order o WHERE o.orderDate BETWEEN ?1 AND ?2")
    List<Order> findByOrderDateBetween(LocalDate startDate, LocalDate endDate);

    @Query("SELECT o FROM Order o WHERE o.orderDate = ?1")
    List<Order> findByDate(LocalDate date);
}
