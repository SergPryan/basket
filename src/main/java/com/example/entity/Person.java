package com.example.entity;

import com.example.diagrams.Diagram5;
import com.example.diagrams.Diagram6;
import com.example.diagrams.Diagram7;
import com.example.diagrams.InternetDiagram;

public class Person {
    private UserData userData;
    private int gadjets;
    private int internet;
    private int messenger;
    private int gaming;
    private int fisiology;
    private int karantin;
    private InternetDiagram internetDiagram;
    private Diagram5 diagram5;
    private Diagram6 diagram6;
    private Diagram7 diagram7;
    private String recomendation;

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public int getGadjets() {
        return gadjets;
    }

    public void setGadjets(int gadjets) {
        this.gadjets = gadjets;
    }

    public int getInternet() {
        return internet;
    }

    public void setInternet(int internet) {
        this.internet = internet;
    }

    public int getMessenger() {
        return messenger;
    }

    public void setMessenger(int messenger) {
        this.messenger = messenger;
    }

    public int getGaming() {
        return gaming;
    }

    public void setGaming(int gaming) {
        this.gaming = gaming;
    }

    public int getFisiology() {
        return fisiology;
    }

    public void setFisiology(int fisiology) {
        this.fisiology = fisiology;
    }

    public InternetDiagram getInternetDiagram() {
        return internetDiagram;
    }

    public void setInternetDiagram(InternetDiagram internetDiagram) {
        this.internetDiagram = internetDiagram;
    }

    public int getKarantin() {
        return karantin;
    }

    public void setKarantin(int karantin) {
        this.karantin = karantin;
    }

    public String getRecomendation() {
        return recomendation;
    }

    public void setRecomendation(String recomendation) {
        this.recomendation = recomendation;
    }

    public Diagram5 getDiagram5() {
        return diagram5;
    }

    public void setDiagram5(Diagram5 diagram5) {
        this.diagram5 = diagram5;
    }

    public Diagram6 getDiagram6() {
        return diagram6;
    }

    public void setDiagram6(Diagram6 diagram6) {
        this.diagram6 = diagram6;
    }

    public Diagram7 getDiagram7() {
        return diagram7;
    }

    public void setDiagram7(Diagram7 diagram7) {
        this.diagram7 = diagram7;
    }

    @Override
    public String toString() {
        return "Person{" +
                "userData=" + userData +
                ", gadjets=" + gadjets +
                ", internet=" + internet +
                ", messenger=" + messenger +
                ", gaming=" + gaming +
                ", fisiology=" + fisiology +
                ", karantin=" + karantin +
                ", internetDiagram=" + internetDiagram +
                ", diagram5=" + diagram5 +
                ", diagram6=" + diagram6 +
                ", diagram7=" + diagram7 +
                ", recomendation='" + recomendation + '\'' +
                '}';
    }
}
