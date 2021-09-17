package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.HangmanKeyListener;
import model.HangmanGame;

public class HangmanPanel {

    public enum GameState {
        READY, PLAYING, GAMEOVER
    }

    private JFrame window;
    private HangmanCanvas canvas;
    private JTextField gameKeyField = new JTextField();
    private JTextField guessField = new JTextField();
    private JButton[] letterButtons;
    private final int FIRST_CHAR=97;
    private JButton newButton = new JButton("New");
    private GameState gameState = GameState.READY;

    private HangmanGame hangman;

    public HangmanPanel(JFrame window) {
        this.window = window;
    }

    public void init() {
        Container cp = window.getContentPane();

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2, 1));
        northPanel.add(gameKeyField);
        northPanel.add(guessField);
        gameKeyField.setEditable(false);
        guessField.setEditable(false);

        cp.add(BorderLayout.NORTH, northPanel);

        canvas = new HangmanCanvas(this);
        cp.add(BorderLayout.CENTER, canvas);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(4, 7));

        HangmanKeyListener keyListener = new HangmanKeyListener(this);

        letterButtons = new JButton[26];
        for (int i = 0; i < 26; i++) {
            letterButtons[i] = new JButton(Character.toChars(FIRST_CHAR+i)[0] + "");
            southPanel.add(letterButtons[i]);
            letterButtons[i].addActionListener(keyListener);
        }

        newButton.addActionListener(keyListener);
        southPanel.add(newButton);
        cp.add(BorderLayout.SOUTH, southPanel);

        for (var b: letterButtons) {
            b.setEnabled(false);
        }
    }
    
    public HangmanGame getHangmanGame() {
        return hangman;
    }

    public JFrame getWindow() {
        return window;
    }

    public HangmanCanvas getCanvas() {
        return canvas;
    }

    public JTextField getGameKeyField() {
        return gameKeyField;
    }

    public JTextField getGuessField() {
        return guessField;
    }

    public JButton[] getLetterButtons() {
        return letterButtons;
    }

    public JButton getNewButton() {
        return newButton;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState state) {
        this.gameState = state;
    }

    public HangmanGame getHangman() {
        return hangman;
    }

    public void setHangman(HangmanGame hangman) {
        this.hangman = hangman;
    }
}
