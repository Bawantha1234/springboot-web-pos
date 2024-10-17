package com.example.demo.dto.impl;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDto implements OrderStatus {
     private String orderId;
    private String orderDate;
    private List<Item> itemId;
    private double orderQty;

}
