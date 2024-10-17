package com.example.demo.entity.impl;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order")
public class Order {
    @Id
    private String orderId;
    private String orderDate;
    @OneToMany(mappedBy = "order")
    private List<Item> itemId;
    private double orderQty;
}

