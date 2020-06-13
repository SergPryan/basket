package com.example.service;

import com.example.diagrams.InternetDiagram;
import com.example.entity.Person;
import com.example.entity.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {
    private static List<Person> data = new ArrayList<>();

    public void add(Person person){
        data.add(person);
    }

    public InternetDiagram getInternetDiagram(Person person){
         int internetUsed  = (int) data.stream().filter(e-> {
             Question question3 = e.getUserData().getData().stream().filter(question -> question.getId().equals("3") && question.getType().equals("internet")).findAny().get();
             List<String> q2 = (List<String>) question3.getValue();
             return q2.get(0).equals("1");
         }).count();
        int internetNotUsed = (int) data.stream().filter(e-> {
            Question question3 = e.getUserData().getData().stream().filter(question -> question.getId().equals("3") && question.getType().equals("internet")).findAny().get();
            List<String> q2 = (List<String>) question3.getValue();
            return !q2.get(0).equals("1");
        }).count();
         int gameUsed = (int) data.stream().filter(e-> {
             Question question3 = e.getUserData().getData().stream().filter(question -> question.getId().equals("3") && question.getType().equals("internet")).findAny().get();
             List<String> q2 = (List<String>) question3.getValue();
             return q2.get(3).equals("1");
         }).count();
         int gameNotUsed = (int) data.stream().filter(e-> {
             Question question3 = e.getUserData().getData().stream().filter(question -> question.getId().equals("3") && question.getType().equals("internet")).findAny().get();
             List<String> q2 = (List<String>) question3.getValue();
             return !q2.get(3).equals("1");
         }).count();

        InternetDiagram diagram = new InternetDiagram();
        diagram.setGameNotUsed(gameNotUsed);
        diagram.setGameUsed(gameUsed);
        diagram.setInternetNotUsed(internetNotUsed);
        diagram.setInternetUsed(internetUsed);
        return diagram;
    }

    public List<Person> getData() {
        return data;
    }
}
