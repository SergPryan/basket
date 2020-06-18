package com.example.controllers;

import com.example.diagrams.Diagram5;
import com.example.diagrams.Diagram6;
import com.example.diagrams.Diagram7;
import com.example.diagrams.InternetDiagram;
import com.example.entity.Person;
import com.example.entity.UserData;
import com.example.service.DataService;
import com.example.service.QuestionService;
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
        person = dataService.add(person);
        InternetDiagram internetDiagram = dataService.getInternetDiagram();
        person.setInternetDiagram(internetDiagram);

        Diagram5 diagram5 = dataService.getDiagram5();
        person.setDiagram5(diagram5);

        Diagram6 diagram6 = dataService.getDiagram6();
        person.setDiagram6(diagram6);

        Diagram7 diagram7 = dataService.getDiagram7();
        person.setDiagram7(diagram7);

        dataService.add(person);
        return ResponseEntity.ok().body(person);
    }

    @GetMapping("/result")
    public List<Person> result() {
        return dataService.getData();
    }
}
