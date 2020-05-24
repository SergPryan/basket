package com.example.controllers;

import com.example.diagrams.InternetDiagram;
import com.example.entity.Person;
import com.example.entity.UserData;
import com.example.service.DataService;
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

    @Autowired
    DataService dataService;

    @PostMapping("/create")
    public ResponseEntity<Person> createOrder(HttpServletRequest request, @RequestBody UserData userData){
        System.out.println(userData);
        Person person =  questionService.handleQestion(userData);
        dataService.add(person);
        InternetDiagram internetDiagram = dataService.getInternetDiagram(person);
        person.setInternetDiagram(internetDiagram);
        return ResponseEntity.ok().body(person);
    }
}
