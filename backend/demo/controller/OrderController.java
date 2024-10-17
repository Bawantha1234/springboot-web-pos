package com.example.demo.controller;

import com.example.demo.dto.OrderDto;
import com.example.demo.dto.ItemDto;
import com.example.demo.dto.ItemStatus;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Create an order
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveOrder(@RequestBody OrderDto orderDto) {
        try {
            String orderId = orderService.generateOrderId();
            orderDto.setOrderId(orderId);
            orderService.saveOrder(orderDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Retrieve all orders
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    // Retrieve an order by ID
    @GetMapping(value = "/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemStatus> getOrderById(@PathVariable("orderId") String orderId) {
        try {
            ItemStatus order = orderService.getOrder(orderId);
            return new ResponseEntity<>(order, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update an order by ID
    @PutMapping(value = "/{orderId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateOrder(@PathVariable("orderId") String orderId, @RequestBody ItemDto orderDto) {
        try {
            orderService.updateOrder(orderId, orderDto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete an order by ID
    @DeleteMapping(value = "/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("orderId") String orderId) {
        try {
            orderService.deleteOrder(orderId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Generate a new order ID
    @GetMapping("/generateOrderId")
    public ResponseEntity<String> generateOrderId() {
        String orderId = orderService.generateOrderId();
        return new ResponseEntity<>(orderId, HttpStatus.OK);
    }
}
