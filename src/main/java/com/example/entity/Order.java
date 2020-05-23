package com.example.entity;

public class Order {
    private String name;
    private String age;
    private String sex;
    private String napravlenie;
    private String category;
    private Object data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNapravlenie() {
        return napravlenie;
    }

    public void setNapravlenie(String napravlenie) {
        this.napravlenie = napravlenie;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", napravlenie='" + napravlenie + '\'' +
                ", category='" + category + '\'' +
                ", data=" + data +
                '}';
    }
}
