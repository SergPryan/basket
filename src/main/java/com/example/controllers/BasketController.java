package com.example.controllers;

import com.example.commons.Utils;
import com.example.entity.Order;
import com.example.entity.Product;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity addInBasket(@RequestBody Product product, HttpServletRequest request){
        Order order = Utils.getOrderInSession(request);
        order.getList().add(product);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteInBasket(@PathVariable("id") int id, HttpServletRequest request){

        Order order = Utils.getOrderInSession(request);
        Iterator<Product> iterator = order.getList().iterator();
        while (iterator.hasNext()){
            Product product =  iterator.next();
            System.out.println(product.getId().intValue() + " " +id);
            if(product.getId().intValue() == id){
                iterator.remove();
                break;
            }
        }
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
        order.setList(Utils.getOrderInSession(request).getList());
        if(order.getList()==null){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        orderService.createOrder(order);
        order.getList().clear();
        return new ResponseEntity(HttpStatus.OK);

    }
}
