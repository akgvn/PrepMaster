package com.work.prepmaster;

public class ListviewModel {

    private String userName;
    private String score;

    public ListviewModel(String userName, String score) {
        super();
        this.userName = userName;
        this.score = score;
    }

    @Override
    public String toString() {
        return userName + " : " + score;
    }

    public String getUserName() {
        return userName;
    }

    public String getScore() {
        return score;
    }

    public void setText(String userName, String score) {
        this.userName = userName;
        this.score = score;
    }
}
