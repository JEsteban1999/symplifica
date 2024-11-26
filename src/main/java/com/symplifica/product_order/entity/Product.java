package com.symplifica.product_order.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private String price;

    @Column(name = "current_stock")
    private Integer currentStock;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders = new ArrayList<>();
}
