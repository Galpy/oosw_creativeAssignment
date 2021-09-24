package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.GuessingGameKeyListener;
import model.GuessingGame;

public class GuessingGamePanel {

    public enum GameState {
        READY, PLAYING, GAMEOVER, WINNER, DRAW
    }

    private JFrame window;
    private GuessingGameCanvas canvas;
    private JTextField gameKeyField = new JTextField();
    private JTextField guessField = new JTextField();
    private JButton[] letterButtons;
    private JButton enterButton = new JButton("Enter");
    private JButton newButton = new JButton("New");
    private GameState gameState = GameState.READY;

    private GuessingGame guessingGame;

    public GuessingGamePanel(JFrame window) {
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
        canvas = new GuessingGameCanvas(this);
        cp.add(BorderLayout.CENTER, canvas);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(4, 7));

        GuessingGameKeyListener keyListener = new GuessingGameKeyListener(this);

        letterButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            letterButtons[i] = new JButton("" + i);
            southPanel.add(letterButtons[i]);
            letterButtons[i].addActionListener(keyListener);
        }

        newButton.addActionListener(keyListener);
        southPanel.add(newButton);
        enterButton.addActionListener(keyListener);
        southPanel.add(enterButton);
        cp.add(BorderLayout.SOUTH, southPanel);

        for (var b: letterButtons) {
            b.setEnabled(false);
        }
    }
    
    public GuessingGame getHangmanGame() {
        return guessingGame;
    }

    public JFrame getWindow() {
        return window;
    }

    public GuessingGameCanvas getCanvas() {
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

    public JButton getEnterButton() {
        return enterButton;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState state) {
        this.gameState = state;
    }

    public GuessingGame getGuessingGame() {
        return guessingGame;
    }

    public void setGuessingGame(GuessingGame guessingGame) {
        this.guessingGame = guessingGame;
    }
}
