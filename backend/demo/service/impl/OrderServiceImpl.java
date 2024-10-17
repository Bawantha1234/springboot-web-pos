package com.example.demo.service.impl;

import com.example.demo.dao.OrderDao;
import com.example.demo.dto.ItemDto;
import com.example.demo.dto.OrderDto;
import com.example.demo.dto.ItemStatus;
import com.example.demo.entity.Order;
import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.service.OrderService;
import com.example.demo.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveOrder(OrderDto orderDTO) {
        Order order = mapping.toOrderEntity(orderDTO);
        orderDao.save(order);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderDao.findAll();
        return mapping.toOrderDtoList(orders);
    }

    @Override
    public ItemStatus getOrder(String orderId) {
        Optional<Order> order = orderDao.findById(orderId);
        if (order.isPresent()) {
            return mapping.toItemStatus(order.get());
        } else {
            throw new OrderNotFoundException("Order with ID " + orderId + " not found.");
        }
    }

    @Override
    public void deleteOrder(String orderId) {
        if (orderDao.existsById(orderId)) {
            orderDao.deleteById(orderId);
        } else {
            throw new OrderNotFoundException("Order with ID " + orderId + " not found.");
        }
    }

    @Override
    public void updateOrder(String orderId, ItemDto orderDTO) {
        Optional<Order> existingOrder = orderDao.findById(orderId);
        if (existingOrder.isPresent()) {
            Order order = existingOrder.get();
            // Update order fields
            order.setOrderDetails(orderDTO.getOrderDetails());
            orderDao.save(order);
        } else {
            throw new OrderNotFoundException("Order with ID " + orderId + " not found.");
        }
    }

    @Override
    public String generateOrderId() {
        String lastOrderId = orderDao.findLastOrderId();
        if (lastOrderId == null || lastOrderId.isEmpty()) {
            return "ODI-001";
        }

        int lastId = Integer.parseInt(lastOrderId.split("-")[1]);
        lastId += 1;

        return String.format("ODI-%03d", lastId);
    }
}
