package com.example.service;

import com.example.entity.Order;
import com.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    OrderRepository orderRepository;

    public Order createOrder(Order order){
//        order = orderRepository.create(order);
        return order;
    }

}
