package com.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Product> list= new ArrayList<>();

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }
}
