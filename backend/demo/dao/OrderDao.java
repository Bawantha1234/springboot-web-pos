package com.example.demo.dao;

import com.example.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
@Repository
public interface OrderDao extends JpaRepository<Order, String> {

    // Custom query to find the last order ID
    @Query(value = "SELECT o.orderId FROM Order o ORDER BY o.orderId DESC LIMIT 1", nativeQuery = true)
    String findLastOrderId();
}

