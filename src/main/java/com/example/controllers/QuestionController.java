package com.example.controllers;

import com.example.entity.Person;
import com.example.entity.UserData;
import com.example.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

//    @PostMapping("/add")
//    public ResponseEntity addInBasket(@RequestBody Product product, HttpServletRequest request){
//        Order order = Utils.getOrderInSession(request);
//        order.getList().add(product);
//        return new ResponseEntity(HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity deleteInBasket(@PathVariable("id") int id, HttpServletRequest request){
//
//        Order order = Utils.getOrderInSession(request);
//        Iterator<Product> iterator = order.getList().iterator();
//        while (iterator.hasNext()){
//            Product product =  iterator.next();
//            System.out.println(product.getId().intValue() + " " +id);
//            if(product.getId().intValue() == id){
//                iterator.remove();
//                break;
//            }
//        }
//        return new ResponseEntity(HttpStatus.OK);
//    }
//
//    @GetMapping("/all")
//    public ResponseEntity<List<Product>> getAll(HttpServletRequest request){
//        Order order = Utils.getOrderInSession(request);
//        return new ResponseEntity<>(order.getList(),HttpStatus.OK);
//
//    }

    @PostMapping("/create")
    public ResponseEntity<Person> createOrder(HttpServletRequest request, @RequestBody UserData userData){
        System.out.println(userData);
        Person person =  questionService.handleQestion(userData);
        return ResponseEntity.ok().body(person);

    }
}
