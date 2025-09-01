package com.ecom.controller;

import com.ecom.client.ProductClient;
import com.ecom.client.UserClient;
import com.ecom.dto.OrderRequestDTO;
import com.ecom.dto.OrderResponseDTO;
import com.ecom.dto.ProductDto;
import com.ecom.dto.UserDto;
import com.ecom.entity.Order;
import com.ecom.entity.OrderItem;
import com.ecom.enums.OrderStatus;
import com.ecom.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;
    private final UserClient userClient;
    private final ProductClient productClient;

    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        UserDto user = userClient.getUserById(orderRequestDTO.getUserId());
        Order order = Order.builder()
                .userId(user.getId())
                .orderDate(LocalDateTime.now())
                .status(OrderStatus.PENDING)
                .build();

        List<OrderItem> orderItemList = new ArrayList<>();
        for(int i = 0; i < orderRequestDTO.getProductId().size(); i++) {
            ProductDto product = productClient.getSingleProduct(orderRequestDTO.getProductId().get(i));
            orderItemList.add(OrderItem.builder()
                    .order(order)
                    .productId(product.getId())
                    .quantity(orderRequestDTO.getQty().get(i))
                    .priceAtOrder(product.getPrice())
                    .build()
            );
        }
        order.setOrderItems(orderItemList);
        return ResponseEntity.ok(service.createOrder(order));
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getAllOrders() {
        return ResponseEntity.ok(service.getAllOrder());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getOrderById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        service.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
