package com.work.prepmaster;

public class ResponseScore {

    private String arr[][];
    public ResponseScore(String arr[][]) {
        this.arr = arr;
    }
    public String[][] getScore() {
        return arr;
    }

}
