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

    @Autowired
    QuestionService questionService;

    @Autowired
    DataService dataService;

    @PostMapping("/create")
    public ResponseEntity<Person> createOrder(@RequestBody UserData userData) {
//        Person person =  questionService.handleQestion(userData);
//        dataService.add(person);
//        InternetDiagram internetDiagram = dataService.getInternetDiagram(person);
//        person.setInternetDiagram(internetDiagram);

        Person person = test();

        return ResponseEntity.ok().body(person);
    }

    private Person test() {
        Person person = new Person();
        person.setGaming(5);
        person.setGadjets(5);
        person.setInternet(5);
        person.setMessenger(5);
        person.setFisiology(5);
        person.setKarantin(5);
        InternetDiagram diagram = new InternetDiagram();
        diagram.setInternetUsed(5);
        diagram.setInternetNotUsed(5);
        diagram.setGameUsed(5);
        diagram.setGameNotUsed(5);
        person.setInternetDiagram(diagram);

        person.setRecomendation("recccccccccccccccccc");
        return person;
    }

    @GetMapping("/result")
    public List<Person> result(@RequestBody UserData userData) {
        return dataService.getData();
    }
}
