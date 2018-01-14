package com.example.controllers;

import com.example.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {


    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll(){
        List<Product> result = new ArrayList<>();
        Product product = new Product();
        product.setName("name");
        product.setCount(10);
        result.add(product);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
