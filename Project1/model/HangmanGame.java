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
    private String guess;
    private char[] wordFound;
    private ArrayList<String> letters = new ArrayList<>();

    public HangmanGame() {
        wordToFind = generateKey();
    }

    public void enter(String c) {
        if (!letters.contains(c)) {
            
            if (wordToFind.contains(c)) {
                int index = wordToFind.indexOf(c);

                while (index >= 0) {
                    wordFound[index] = c.charAt(0);
                    index = wordToFind.indexOf(c, index + 1);
                }
            } else {
                healthCount--;
            }

            letters.add(c);
        }
    }

    public int getHealthCount() {
        return healthCount;
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
