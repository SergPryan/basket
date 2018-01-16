package com.example.controllers;

import com.example.commons.Utils;
import com.example.entity.Order;
import com.example.entity.Product;
import com.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    OrderRepository orderRepository;

    @PostMapping("/add")
    public ResponseEntity addInBasket(@RequestBody Product product, HttpServletRequest request){
        Order order = Utils.getOrderInSession(request);
        order.getList().add(product);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteInBasket(@RequestBody Product product, HttpServletRequest request){
        Order order = Utils.getOrderInSession(request);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll(HttpServletRequest request){
        Order order = Utils.getOrderInSession(request);
        Order order1 = new Order();
        Product product1 =new Product();
        product1.setName("beer");
        product1.setPrice(100);
        product1.setId(1L);
        Product product2 =new Product();
        product2.setName("vodka");
        product2.setPrice(300);
        product2.setId(2L);

        order1.getList().add(product1);
        order1.getList().add(product2);

        order1.setFullName("test1");
        order1.setTelephone("12312321");
        orderRepository.create(order1);
        return new ResponseEntity<>(order.getList(),HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity createOrder(HttpServletRequest request, @RequestBody Order order){
        System.out.println("create order");
        System.out.println(order.getFullName());
        System.out.println(order.getTelephone());
        order.setList(Utils.getOrderInSession(request).getList());
        return new ResponseEntity(HttpStatus.OK);

    }
}
