/*package test;

import model.HangmanGame;

public class HangmanTest {
    
    public static void main(String[] args) {

        HangmanGame h1 = new HangmanGame();

        ballStrikeCountCheck(1, 2, 3, 1, 6, 5, 0, 1);
        ballStrikeCountCheck(2, 1, 3, 6, 1, 5, 0, 1);
        ballStrikeCountCheck(1, 2, 3, 8, 6, 3, 0, 1);
        ballStrikeCountCheck(1, 2, 3, 8, 1, 0, 1, 0);
        ballStrikeCountCheck(1, 2, 3, 2, 0, 8, 1, 0);
        ballStrikeCountCheck(1, 2, 3, 3, 0, 8, 1, 0);
        ballStrikeCountCheck(1, 2, 3, 3, 1, 8, 2, 0);
        ballStrikeCountCheck(1, 2, 3, 1, 2, 3, 0, 3);
    }

    private static boolean ballStrikeCountCheck(int k0, int k1, int k2, int g0, int g1, int g2, int balls, int strikes) {
        HangmanGame b = new HangmanGame(k0, k1, k2);
        b.setGuess(0, g0);
        b.setGuess(1, g1);
        b.setGuess(2, g2);
        b.computeBallsStrikes();
        if (b.getBallCount() == balls && b.getStrikeCount() == strikes) {
            return true;
        } else {
            String keys = "" + k0 + k1 + k2;
            String guesses = "" + g0 + g1 + g2;
            System.out.println("Key: " + keys + " Guess: " + guesses + " Incorrect count");
            System.out.println("Balls: " + b.getBallCount() + " Strikes: " + b.getStrikeCount());
            return false;
        }
    }

    private static boolean checkKey(int[] key) {
        if (key[0] == key[1] || key[0] == key[2] || key[1] == key[2])
            return false;
        else
            return true;
    }
}
*/
