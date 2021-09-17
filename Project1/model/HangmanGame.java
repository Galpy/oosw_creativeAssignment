package model;

import java.util.ArrayList;
import java.util.Random;

public class HangmanGame {
    public static final String[] Words = {"communication",
        "science",
        "programming",
        "language",
        "difficulty",
        "artificial",
        "intelligence",
        "attempts",
        "screenshot",
        "baseball",
        "windows",
        "learning",
        "electronics",
        "beautiful",
        "internet",
        "database",
        "organization",
        "application",
        "network",
        "friendly",
        "validation",
        "attempts",
        "statistics",
        "physics",
        "chemistry",
        "engineering",
        "school",
        "industry",
        "revolution",
        "progress",
        "characters",
        "heavily",
        "graphics"};
    private int healthCount = 5;
    private String wordToFind;
    private char[] wordFound = new char[15];
    private ArrayList<String> letters = new ArrayList<>();

    public HangmanGame() {
        wordToFind = generateKey();
        for (int i = 0; i < wordToFind.length(); i++) {
            wordFound[i] = wordToFind.charAt(i);
        }
    }

    public int getHealthCount() {
        return healthCount;
    }

    public void setHealthCount(int health) {
        this.healthCount = health;
    }

    private String generateKey() {
        Random r = new Random();
        return Words[r.nextInt(Words.length)];
    }

    public String getKey() {
        return wordToFind;
    }

    public char[] getWordFound() {
        return wordFound;
    }
 
    public ArrayList<String> getLetters() {
        return letters;
    }
}
