package com.example.controllers;

import com.example.diagrams.InternetDiagram;
import com.example.entity.Person;
import com.example.entity.UserData;
import com.example.service.DataService;
import com.example.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;
    private final DataService dataService;

    public QuestionController(QuestionService questionService, DataService dataService) {
        this.questionService = questionService;
        this.dataService = dataService;
    }


    @PostMapping("/create")
    public ResponseEntity<Person> createOrder(@RequestBody UserData userData) {
        Person person =  questionService.handleQestion(userData);
        dataService.add(person);
        InternetDiagram internetDiagram = dataService.getInternetDiagram(person);
        person.setInternetDiagram(internetDiagram);
        dataService.add(person);
        return ResponseEntity.ok().body(person);
    }

    @GetMapping("/result")
    public List<Person> result() {
        return dataService.getData();
    }
}
