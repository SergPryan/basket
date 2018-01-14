package com.example.controllers;

import com.example.commons.Utils;
import com.example.entity.Order;
import com.example.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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

}
