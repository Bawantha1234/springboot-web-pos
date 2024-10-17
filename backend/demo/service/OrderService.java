package com.example.demo.service;

public interface OrderService {
    void saveOrder(OrderDto orderDTO);
    List<OrderDto> getAllOrder();
    ItemStatus getOrder(String orderId);
    void deleteItem(String oderId);
    void updateItem(String orderId, ItemDto orderDTO);
    String generateOrderId(); // Add this method to the interfa
}
