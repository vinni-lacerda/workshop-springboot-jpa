package com.udemyJava.course.resources;

import com.udemyJava.course.entities.Order;
import com.udemyJava.course.services.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderResource {
    private final OrderService orderService;

    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders() {
        List<Order> list = orderService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id){
       Order obj = orderService.findById(id);
       return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public Order saveOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    }

    @DeleteMapping
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }

}
