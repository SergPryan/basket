package com.example.service;

import com.example.entity.Person;
import com.example.entity.Question;
import com.example.entity.UserData;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    public Person handleQestion(UserData userData) {
        Person person = new Person();
        person.setUserData(userData);
        List<Question> gadjets = userData.getData().stream().filter(e -> e.getType().equals("gadjet")).collect(Collectors.toList());
        int gadjet = checkGajets(gadjets);
        person.setGadjets(gadjet);

        List<Question> internets = userData.getData().stream().filter(e -> e.getType().equals("internet")).collect(Collectors.toList());
        int internet = checkInternet(internets);
        person.setInternet(internet);

        List<Question> messengers = userData.getData().stream().filter(e -> e.getType().equals("messenger")).collect(Collectors.toList());
        int messenger = checkMessenger(messengers);
        person.setMessenger(messenger);

        List<Question> gamings = userData.getData().stream().filter(e -> e.getType().equals("gaming")).collect(Collectors.toList());
        int gaming = checkGaming(gamings);
        person.setGaming(gaming);

        List<Question> fisiologys = userData.getData().stream().filter(e -> e.getType().equals("fisiology")).collect(Collectors.toList());
        int fisiology = checkFisiology(fisiologys);
        person.setFisiology(fisiology);

        List<Question> karantins = userData.getData().stream().filter(e -> e.getType().equals("karantin")).collect(Collectors.toList());
        int karantin = checkKarantin(karantins);
        person.setKarantin(karantin);

        StringBuilder sb = new StringBuilder();
        sb.append("Рекомендации:");
        sb.append("Использовние гаджетов - ");
        if (gadjet <= 7) {
            sb.append("Нет зависимости");
        }
        if (gadjet <= 15 && gadjet >= 8) {
            sb.append("Тенденция к зависимости");
        }
        if (gadjet > 15) {
            sb.append("Зависимость");
        }
        sb.append("<br>");

        sb.append("Использование интернета - ");
        if (internet <= 7) {
            sb.append("Нет зависимости");
        }
        if (internet <= 15 && internet >= 8) {
            sb.append("Тенденция к зависимости");
        }
        if (internet > 15) {
            sb.append("Зависимость");
        }
        sb.append("<br>");

        sb.append("Использование мессенджеров - ");
        if (messenger <= 3) {
            sb.append("Нет зависимости");
        }
        if (messenger <= 6 && messenger >= 4) {
            sb.append("Тенденция к зависимости");
        }
        if (messenger > 6) {
            sb.append("Зависимость");
        }
        sb.append("<br>");

        sb.append("Гейминг - ");
        if (gaming <= 9) {
            sb.append("Нет зависимости");
        }
        if (gaming <= 19 && gaming >= 10) {
            sb.append("Тенденция к зависимости");
        }
        if (gaming > 20) {
            sb.append("Зависимость");
        }
        sb.append("<br>");
        if (fisiology <= 11 && gaming >= 6) {
            sb.append("У Вас наблюдается ухудшение общего самочувствия, вызванное, в том числе, виртуальными технологиями");
        }
        if (fisiology > 12) {
            sb.append("Ваш организм сильно подвержен вредному влиянию от чрезмерного использования технологий. ");
        }
        sb.append("<br>");
        person.setRecomendation(sb.toString());
        return person;

    }

    private int checkKarantin(List<Question> karantins) {
        int result = 0;
        Question question1 = karantins.stream().filter(e -> e.getId().equals("1")).findAny().get();
        List<String> q1 = (List<String>) question1.getValue();
        q1.remove(6);
        int q1a = (int) q1.stream().filter(e -> e.equals("1")).count();
        int q1b = (int) q1.stream().filter(e -> e.equals("2")).count();
        result += q1a * 2 + q1b;

        Question question2 = karantins.stream().filter(e -> e.getId().equals("2")).findAny().get();
        if(question2.getValue()!= null){
            if (question2.getValue().equals("2")) {
                result += 1;
            }
            if (question2.getValue().equals("5")) {
                result += 2;
            }
        }
        Question question3 = karantins.stream().filter(e -> e.getId().equals("3")).findAny().get();
        if (question3.getValue() != null) {
            if (question3.getValue().equals("1")) {
                result += 1;
            }
            if (question3.getValue().equals("3")) {
                result += 2;
            }
        }
        return result;
    }

    private int checkFisiology(List<Question> fisiologys) {
        int result = 0;
        Question question1 = fisiologys.stream().filter(e -> e.getId().equals("1")).findAny().get();
        if (question1.getValue() != null && question1.getValue().equals("2")) {
            result += 2;
        }
        Question question2 = fisiologys.stream().filter(e -> e.getId().equals("2")).findAny().get();
        boolean[] arr = ignoreNull((List<Boolean>) question2.getValue());
        if (arr[0]) {
            result += 1;
        }
        if (arr[1]) {
            result += 1;
        }
        if (arr[2]) {
            result += 1;
        }
        if (arr[3]) {
            result += 2;
        }
        if (arr[4]) {
            result += 2;
        }
        if (arr[5]) {
            result += 1;
        }
        if (arr[6]) {
            result += 2;
        }
        Question question3 = fisiologys.stream().filter(e -> e.getId().equals("3")).findAny().get();
        boolean[] arr3 = ignoreNull((List<Boolean>) question3.getValue());
        if (arr3[0]) {
            result += 2;
        }
        if (arr3[1]) {
            result += 2;
        }
        if (arr3[3]) {
            result += 1;
        }

        Question question4 = fisiologys.stream().filter(e -> e.getId().equals("4")).findAny().get();
        if (question4.getValue() != null) {
            if (question4.getValue().equals("2")) {
                result += 2;
            }
            if (question4.getValue().equals("3")) {
                result += 2;
            }
        }
        Question question5 = fisiologys.stream().filter(e -> e.getId().equals("5")).findAny().get();
        if (question5.getValue() != null) {
            if (question5.getValue().equals("2")) {
                result += 1;
            }
            if (question5.getValue().equals("3")) {
                result += 2;
            }
        }
        Question question6 = fisiologys.stream().filter(e -> e.getId().equals("6")).findAny().get();
        if (question6.getValue() != null) {
            if (question6.getValue().equals("1")) {
                result += 2;
            }
            if (question6.getValue().equals("2")) {
                result += 1;
            }
        }
        return result;
    }

    private int checkGaming(List<Question> gamings) {
        int result = 0;
        Question question1 = gamings.stream().filter(e -> e.getId().equals("1")).findAny().get();
        if (question1.getValue() != null) {
            if (question1.getValue().equals("2")) {
                result += 1;
            }
            if (question1.getValue().equals("3")) {
                result += 2;
            }
            if (question1.getValue().equals("4")) {
                result += 2;
            }
        }
        Question question2 = gamings.stream().filter(e -> e.getId().equals("2")).findAny().get();
        if (question2.getValue() != null) {
            if (question2.getValue().equals("1")) {
                result += 1;
            }
            if (question2.getValue().equals("2")) {
                result += 1;
            }
            if (question2.getValue().equals("3")) {
                result += 2;
            }
        }
        Question question3 = gamings.stream().filter(e -> e.getId().equals("3")).findAny().get();
        List<String> q2 = (List<String>) question3.getValue();
        int q2a = (int) q2.stream().filter(e -> e.equals("1")).count();
        int q2b = (int) q2.stream().filter(e -> e.equals("2")).count();
        result += q2a * 2 + q2b;


        Question question4 = gamings.stream().filter(e -> e.getId().equals("4")).findAny().get();
        if (question4.getValue() != null) {
            if (question4.getValue().equals("1")) {
                result += 2;
            }
            if (question4.getValue().equals("2")) {
                result += 1;
            }
        }
        Question question5 = gamings.stream().filter(e -> e.getId().equals("5")).findAny().get();
        if (question5.getValue() != null) {
            if (question5.getValue().equals("3")) {
                result += 1;
            }
            if (question5.getValue().equals("4")) {
                result += 2;
            }
        }
        Question question6 = gamings.stream().filter(e -> e.getId().equals("6")).findAny().get();
        if (question6.getValue() != null) {
            if (question6.getValue().equals("2")) {
                result += 1;
            }
            if (question6.getValue().equals("3")) {
                result += 2;
            }
            if (question6.getValue().equals("4")) {
                result += 2;
            }
        }


        Question question7 = gamings.stream().filter(e -> e.getId().equals("7")).findAny().get();
        if (question7.getValue() != null) {
            if (question7.getValue().equals("1")) {
                result += 2;
            }
            if (question7.getValue().equals("2")) {
                result += 2;
            }
        }
        Question question8 = gamings.stream().filter(e -> e.getId().equals("8")).findAny().get();
        if (question8.getValue() != null) {
            if (question8.getValue().equals("1")) {
                result += 2;
            }
            if (question8.getValue().equals("2")) {
                result += 1;
            }
        }
        Question question9 = gamings.stream().filter(e -> e.getId().equals("9")).findAny().get();
        if (question9.getValue() != null) {
            if (question9.getValue().equals("1")) {
                result += 2;
            }
            if (question9.getValue().equals("2")) {
                result += 2;
            }
            if (question9.getValue().equals("4")) {
                result += 1;
            }
            if (question9.getValue().equals("5")) {
                result += 1;
            }
        }
        return result;
    }

    private int checkMessenger(List<Question> messengers) {
        int result = 0;
        Question question2 = messengers.stream().filter(e -> e.getId().equals("2")).findAny().get();
        if (question2.getValue()!= null && question2.getValue().equals("2")) {
            result += 2;
        }

        Question question3 = messengers.stream().filter(e -> e.getId().equals("3")).findAny().get();
        if(question3.getValue()!= null){
            if (question3.getValue().equals("1")) {
                result += 2;
            }
            if (question3.getValue().equals("2")) {
                result += 2;
            }
            if (question3.getValue().equals("3")) {
                result += 1;
            }
        }
        Question question4 = messengers.stream().filter(e -> e.getId().equals("4")).findAny().get();
        if(question4.getValue()!= null){
            if (question4.getValue().equals("2")) {
                result += 1;
            }
            if (question4.getValue().equals("3")) {
                result += 2;
            }
            if (question4.getValue().equals("4")) {
                result += 1;
            }
        }
        Question question5 = messengers.stream().filter(e -> e.getId().equals("5")).findAny().get();
        if(question5.getValue()!= null){
            if (question5.getValue().equals("1")) {
                result += 2;
            }
            if (question5.getValue().equals("2")) {
                result += 1;
            }
        }
        return result;
    }

    private int checkInternet(List<Question> internets) {
        Question question1 = internets.stream().filter(e -> e.getId().equals("1")).findAny().get();
        int result = 0;
        if (question1.getValue() != null) {
            if (question1.getValue().equals("1")) {
                result += 2;
            }
            if (question1.getValue().equals("3")) {
                result += 1;
            }
        }
        Question question2 = internets.stream().filter(e -> e.getId().equals("2")).findAny().get();
        if (question2.getValue() != null) {
            if (question2.getValue().equals("1")) {
                result += 2;
            }
            if (question2.getValue().equals("2")) {
                result += 1;
            }
        }

        Question question3 = internets.stream().filter(e -> e.getId().equals("3")).findAny().get();
        List<String> q2 = (List<String>) question3.getValue();
        int q2a = (int) q2.stream().filter(e -> e.equals("1")).count();
        int q2b = (int) q2.stream().filter(e -> e.equals("2")).count();
        result += q2a * 2 + q2b;

        Question question4 = internets.stream().filter(e -> e.getId().equals("4")).findAny().get();
        boolean[] arr = ignoreNull((List<Boolean>) question4.getValue());
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

    private boolean[] ignoreNull(List<Boolean> value) {
        List<Boolean> list = value.stream().map(e -> {
            if (e == null) {
                return false;
            } else {
                return e;
            }
        }).collect(Collectors.toList());
        boolean[] result = new boolean[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
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
        if (question3.getValue() != null && question3.getValue().equals("1")) {
            result += 2;
        }
        Question question4 = gadjets.stream().filter(e -> e.getId().equals("4")).findAny().get();
        if (question4.getValue() != null) {
            if (question4.getValue().equals("1") || question4.getValue().equals("3")) {
                result += 1;
            }
            if (question4.getValue().equals("4")) {
                result += 2;
            }
        }
        Question question5 = gadjets.stream().filter(e -> e.getId().equals("5")).findAny().get();
        if (question5.getValue() != null) {
            if (question5.getValue().equals("1")) {
                result += 2;
            }
            if (question5.getValue().equals("3")) {
                result += 1;
            }
        }
        Question question6 = gadjets.stream().filter(e -> e.getId().equals("6")).findAny().get();
        if (question6.getValue() != null) {
            if (question6.getValue().equals("1")) {
                result += 1;
            }
            if (question6.getValue().equals("3")) {
                result += 2;
            }
        }
        Question question7 = gadjets.stream().filter(e -> e.getId().equals("7")).findAny().get();
        if (question7.getValue() != null) {
            if (question7.getValue().equals("1")) {
                result += 2;
            }
            if (question7.getValue().equals("3")) {
                result += 1;
            }
        }
        return result;
    }
}
