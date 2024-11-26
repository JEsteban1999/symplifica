package com.symplifica.product_order.controller;

import com.symplifica.product_order.entity.Order;
import com.symplifica.product_order.entity.Product;
import com.symplifica.product_order.repository.OrderRepository;
import com.symplifica.product_order.repository.ProductRepository;
import com.symplifica.product_order.service.OrderService;
import com.symplifica.product_order.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final ProductService productService;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderController(OrderService orderService, ProductService productService,
                           ProductRepository productRepository, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.productService = productService;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public String listOrders(Model model) {
        model.addAttribute("orders", orderService.findAll());
        model.addAttribute("products", productService.getAllProducts());
        return "order/create-order.html";
    }

    @PostMapping
    public String createOrder(@RequestParam List<Integer> productIds) {
        List<Product> selectedProducts = productRepository.findAllById(productIds);

        if (selectedProducts.isEmpty()) {
            throw new IllegalArgumentException("No products selected for the order");
        }

        Order order = new Order();
        order.setProducts(new ArrayList<>(selectedProducts));
        orderRepository.save(order);

        return "redirect:/orders";
    }
}
