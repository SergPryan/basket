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
        data.add(test());
        return data;
    }

    public Person test() {
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
}
