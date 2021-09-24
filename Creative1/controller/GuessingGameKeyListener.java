package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import model.GuessingGame;
import view.GuessingGamePanel;

public class GuessingGameKeyListener implements ActionListener{

    private GuessingGamePanel panel;

    public GuessingGameKeyListener(GuessingGamePanel panel) {
        this.panel = panel;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        System.out.println(button.getText());
        if (button == panel.getNewButton()) {
            var guessingGame = new GuessingGame();
            panel.setGuessingGame(guessingGame);
            panel.setGameState(GuessingGamePanel.GameState.DRAW);
            int[] key = guessingGame.getKey();
            String keyString = "";
            String guessField = "";
            for (int i = 0; i < guessingGame.getScore(); i++) {
                keyString += key[i];
            }
            panel.getGameKeyField().setText(keyString);
            panel.getGuessField().setText("" + guessField);
            // enable letter buttons
            for (var b: panel.getLetterButtons()) {
                b.setEnabled(true);
            } 
            panel.getCanvas().repaint(); 
        } else if (button == panel.getEnterButton()) {
            panel.setGameState(GuessingGamePanel.GameState.DRAW);
            panel.getCanvas().repaint();
            GuessingGame guessingGame = panel.getGuessingGame();
            JTextField guessField = panel.getGuessField();
            int[] key = guessingGame.getKey();
            int numKey = guessingGame.getNum();
            String cheatString = "";
            int guessNum = Integer.parseInt(guessField.getText());
            panel.getCanvas().repaint();
                if (guessNum == numKey) {
                    if (guessingGame.getScore() == 10) {
                        panel.setGameState(GuessingGamePanel.GameState.WINNER);
                        for (var b: panel.getLetterButtons()) {
                            b.setEnabled(false);
                        }
                        panel.getCanvas().repaint();
                }
                    guessingGame.setScore(guessingGame.getScore()+1);
                    for (int j = 0; j < guessingGame.getScore(); j++) {
                        cheatString += key[j];
                    }
                    panel.getGameKeyField().setText(cheatString); 
                    
            } else {
                    panel.setGameState(GuessingGamePanel.GameState.GAMEOVER);
                    for (var b: panel.getLetterButtons()) {
                        b.setEnabled(false);
                    }
                    panel.getCanvas().repaint();
                }
                panel.getGuessField().setText("");
            System.out.println(guessNum);
            
    }else {
        panel.setGameState(GuessingGamePanel.GameState.PLAYING);
        panel.getCanvas().repaint();
            //letter buttons

            JTextField guessField = panel.getGuessField();
            String guessString = guessField.getText();
            String n = button.getText();
            guessString += n;
           
            panel.getGuessField().setText(guessString);
            
            
            }
        }
    }



    

