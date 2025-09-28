package com.udemyJava.course.services;

import com.udemyJava.course.entities.Order;
import com.udemyJava.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }
    public Order findById(Long id){
        return orderRepository.findById(id).get();
    }
    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }
    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }

}
