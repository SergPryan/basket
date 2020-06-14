package com.example.service;

import com.example.diagrams.Diagram5;
import com.example.diagrams.Diagram6;
import com.example.diagrams.Diagram7;
import com.example.diagrams.InternetDiagram;
import com.example.entity.Person;
import com.example.entity.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class DataService {
    private static List<Person> data = new ArrayList<>();

    public void add(Person person) {
        data.add(person);
    }

    public InternetDiagram getInternetDiagram() {
        int internetUsed = (int) data.stream().filter(e -> {
            Question question3 = e.getUserData().getData().stream().filter(question -> question.getId().equals("3") && question.getType().equals("internet")).findAny().get();
            List<String> q2 = (List<String>) question3.getValue();
            return q2.get(0).equals("1");
        }).count();
        int internetNotUsed = (int) data.stream().filter(e -> {
            Question question3 = e.getUserData().getData().stream().filter(question -> question.getId().equals("3") && question.getType().equals("internet")).findAny().get();
            List<String> q2 = (List<String>) question3.getValue();
            return !q2.get(0).equals("1");
        }).count();
        int gameUsed = (int) data.stream().filter(e -> {
            Question question3 = e.getUserData().getData().stream().filter(question -> question.getId().equals("3") && question.getType().equals("internet")).findAny().get();
            List<String> q2 = (List<String>) question3.getValue();
            return q2.get(3).equals("1");
        }).count();
        int gameNotUsed = (int) data.stream().filter(e -> {
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

    public Diagram5 getDiagram5() {
        Diagram5 diagram5 = new Diagram5();
        AtomicInteger q1 = new AtomicInteger(0);
        AtomicInteger q2 = new AtomicInteger(0);
        AtomicInteger q3 = new AtomicInteger(0);
        AtomicInteger q4 = new AtomicInteger(0);
        AtomicInteger q5 = new AtomicInteger(0);
        AtomicInteger q6 = new AtomicInteger(0);

        data.forEach(e -> {
            Question question2 = e.getUserData().getData().stream().filter(question -> question.getId().equals("2") && question.getType().equals("karantin"))
                    .findAny().get();
            if (question2.getValue().equals("1")) {
                q1.getAndIncrement();
            }
            if (question2.getValue().equals("2")) {
                q2.getAndIncrement();
            }
            if (question2.getValue().equals("3")) {
                q3.getAndIncrement();
            }
            if (question2.getValue().equals("4")) {
                q4.getAndIncrement();
            }
            if (question2.getValue().equals("5")) {
                q5.getAndIncrement();
            }
            if (question2.getValue().equals("6")) {
                q6.getAndIncrement();
            }
        });
        diagram5.setQ1(q1.get());
        diagram5.setQ2(q2.get());
        diagram5.setQ3(q3.get());
        diagram5.setQ4(q4.get());
        diagram5.setQ5(q5.get());
        diagram5.setQ6(q6.get());
        return diagram5;
    }

    public Diagram6 getDiagram6() {
        Diagram6 diagram6 = new Diagram6();
        AtomicInteger q1 = new AtomicInteger(0);
        AtomicInteger q2 = new AtomicInteger(0);
        AtomicInteger q3 = new AtomicInteger(0);
        AtomicInteger q4 = new AtomicInteger(0);
        AtomicInteger q5 = new AtomicInteger(0);

        data.forEach(e -> {
            Question question2 = e.getUserData().getData().stream().filter(question -> question.getId().equals("3") && question.getType().equals("karantin"))
                    .findAny().get();
            if (question2.getValue().equals("1")) {
                q1.getAndIncrement();
            }
            if (question2.getValue().equals("2")) {
                q2.getAndIncrement();
            }
            if (question2.getValue().equals("3")) {
                q3.getAndIncrement();
            }
            if (question2.getValue().equals("4")) {
                q4.getAndIncrement();
            }
            if (question2.getValue().equals("5")) {
                q5.getAndIncrement();
            }
        });
        diagram6.setQ1(q1.get());
        diagram6.setQ2(q2.get());
        diagram6.setQ3(q3.get());
        diagram6.setQ4(q4.get());
        diagram6.setQ5(q5.get());
        return diagram6;
    }

    public Diagram7 getDiagram7() {
        Diagram7 diagram7 = new Diagram7();
        AtomicInteger q1 = new AtomicInteger(0);
        AtomicInteger q2 = new AtomicInteger(0);
        AtomicInteger q3 = new AtomicInteger(0);
        AtomicInteger q4 = new AtomicInteger(0);

        data.forEach(e -> {
            Question question2 = e.getUserData().getData().stream().filter(question -> question.getId().equals("4") && question.getType().equals("karantin"))
                    .findAny().get();
            if (question2.getValue().equals("1")) {
                q1.getAndIncrement();
            }
            if (question2.getValue().equals("2")) {
                q2.getAndIncrement();
            }
            if (question2.getValue().equals("3")) {
                q3.getAndIncrement();
            }
            if (question2.getValue().equals("4")) {
                q4.getAndIncrement();
            }
        });
        diagram7.setQ1(q1.get());
        diagram7.setQ2(q2.get());
        diagram7.setQ3(q3.get());
        diagram7.setQ4(q4.get());
        return diagram7;
    }
}
