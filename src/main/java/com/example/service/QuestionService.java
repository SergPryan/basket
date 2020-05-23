package com.example.service;

import com.example.entity.Question;
import com.example.entity.UserData;
import com.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    @Autowired
    OrderRepository orderRepository;

    public UserData createOrder(UserData userData) {
//        order = orderRepository.create(order);
        return userData;
    }

    public void handleQestion(UserData userData) {
        List<Question> gadjets = userData.getData().stream().filter(e -> e.getType().equals("gadjet")).collect(Collectors.toList());
        int gadjet = checkGajets(gadjets);
        List<Question> internets = userData.getData().stream().filter(e -> e.getType().equals("gadjet")).collect(Collectors.toList());
        int internet = checkInternet(internets);

    }

    private int checkInternet(List<Question> internets) {
        Question question1 = internets.stream().filter(e -> e.getId().equals("1")).findAny().get();
        int result = 0;
        if (question1.getValue().equals("1")) {
            result += 2;
        }
        if (question1.getValue().equals("3")) {
            result += 1;
        }
        Question question2 = internets.stream().filter(e -> e.getId().equals("2")).findAny().get();
        if (question2.getValue().equals("1")) {
            result += 2;
        }
        if (question2.getValue().equals("2")) {
            result += 1;
        }

        Question question3 = internets.stream().filter(e -> e.getId().equals("3")).findAny().get();
        List<String> q2 = (List<String>) question3.getValue();
        int q2a = (int) q2.stream().filter(e -> e.equals("1")).count();
        int q2b = (int) q2.stream().filter(e -> e.equals("2")).count();
        result += q2a * 2 + q2b;

        Question question4 = internets.stream().filter(e -> e.getId().equals("4")).findAny().get();
        Boolean[] arr = (Boolean[]) question4.getValue();
        if (arr[0]) {
            result += 2;
        }
        if (arr[1]) {
            result += 1;
        }
        if (arr[2]) {
            result += 2;
        }
        if (arr[3]) {
            result += 1;
        }
        if (arr[4]) {
            result += 2;
        }
        return result;
    }

    private int checkGajets(List<Question> gadjets) {
        Question question2 = gadjets.stream().filter(e -> e.getId().equals("2")).findAny().get();
        List<String> q2 = (List<String>) question2.getValue();
        int q2a = (int) q2.stream().filter(e -> e.equals("2")).count();
        int q2b = (int) q2.stream().filter(e -> e.equals("3")).count();
        int result = q2a + q2b * 2;

        Question question3 = gadjets.stream().filter(e -> e.getId().equals("3")).findAny().get();
        if (question3.getValue().equals("1")) {
            result += 2;
        }
        Question question4 = gadjets.stream().filter(e -> e.getId().equals("4")).findAny().get();
        if (question4.getValue().equals("1") || question4.getValue().equals("3")) {
            result += 1;
        }
        if (question4.getValue().equals("4")) {
            result += 2;
        }

        Question question5 = gadjets.stream().filter(e -> e.getId().equals("5")).findAny().get();
        if (question5.getValue().equals("1")) {
            result += 2;
        }
        if (question5.getValue().equals("3")) {
            result += 1;
        }

        Question question6 = gadjets.stream().filter(e -> e.getId().equals("6")).findAny().get();
        if (question6.getValue().equals("1")) {
            result += 1;
        }
        if (question6.getValue().equals("3")) {
            result += 2;
        }

        Question question7 = gadjets.stream().filter(e -> e.getId().equals("7")).findAny().get();
        if (question7.getValue().equals("1")) {
            result += 2;
        }
        if (question7.getValue().equals("3")) {
            result += 1;
        }

        return result;
    }
}
