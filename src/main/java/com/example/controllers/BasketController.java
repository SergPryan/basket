package com.example.controllers;

import com.example.commons.Utils;
import com.example.entity.Order;
import com.example.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/basket")
public class BasketController {

    @PostMapping("/add")
    public ResponseEntity addInBasket(@RequestBody Product product, HttpServletRequest request){
        Order order = Utils.getOrderInSession(request);
        order.getList().add(product);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteInBasket(@RequestBody Product product, HttpServletRequest request){
        Order order = Utils.getOrderInSession(request);
//        order.getList().forEach();
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll(HttpServletRequest request){
        Order order = Utils.getOrderInSession(request);
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
