package com.example.diagrams;

public class InternetDiagram {
    private int internetUsed;
    private int internetNotUsed;
    private int gameUsed;
    private int gameNotUsed;

    public int getInternetUsed() {
        return internetUsed;
    }

    public void setInternetUsed(int internetUsed) {
        this.internetUsed = internetUsed;
    }

    public int getInternetNotUsed() {
        return internetNotUsed;
    }

    public void setInternetNotUsed(int internetNotUsed) {
        this.internetNotUsed = internetNotUsed;
    }

    public int getGameUsed() {
        return gameUsed;
    }

    public void setGameUsed(int gameUsed) {
        this.gameUsed = gameUsed;
    }

    public int getGameNotUsed() {
        return gameNotUsed;
    }

    public void setGameNotUsed(int gameNotUsed) {
        this.gameNotUsed = gameNotUsed;
    }

    @Override
    public String toString() {
        return "InternetDiagram{" +
                "internetUsed=" + internetUsed +
                ", internetNotUsed=" + internetNotUsed +
                ", gameUsed=" + gameUsed +
                ", gameNotUsed=" + gameNotUsed +
                '}';
    }
}
