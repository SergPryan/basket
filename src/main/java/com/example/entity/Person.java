package com.example.entity;

public class Person {
    private UserData userData;
    private int gadjets;
    private int internet;
    private int messenger;
    private int gaming;
    private int fisiology;

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

    @Override
    public String toString() {
        return "Person{" +
                "userData=" + userData +
                ", gadjets=" + gadjets +
                ", internet=" + internet +
                ", messenger=" + messenger +
                ", gaming=" + gaming +
                ", fisiology=" + fisiology +
                '}';
    }
}
