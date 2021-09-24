package model;

import java.util.Random;

public class GuessingGame {
    private int[] numberToFind = new int[10];
    private int guessNum;
    private int num;
    private int score = 1;

    public GuessingGame() {
        for (int i = 0; i < numberToFind.length; i++) {
        numberToFind[i] = generateNum();
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int generateNum() {
        Random r = new Random();
        return r.nextInt(10);
    }

    public int[] getKey() {
        return numberToFind;
    }

    public int getNumFound() {
        return guessNum;
    }

    public int getNum() {
        String numString = "";
        for (int i = 0; i < score; i++) {
            numString += numberToFind[i];
            num = Integer.parseInt(numString);
        }
        return num;
    }
}
