package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import model.HangmanGame;
import view.HangmanPanel;

public class HangmanKeyListener implements ActionListener{

    private HangmanPanel panel;
    private int clicks = 0;

    public HangmanKeyListener(HangmanPanel panel) {
        this.panel = panel;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        System.out.println(button.getText());
        if (button == panel.getNewButton()) {
            var hangman = new HangmanGame();
            panel.setHangman(hangman);
            panel.setGameState(HangmanPanel.GameState.PLAYING);
            String key = hangman.getKey();
            String guessField = "";
            panel.getGameKeyField().setText(key);
            for (int i = 0; i < hangman.getKey().length(); i++) {
                guessField += ". ";

            }
            panel.getGuessField().setText(guessField);
            // enable letter buttons
            for (var b: panel.getLetterButtons()) {
                b.setEnabled(true);
            }
            panel.getCanvas().setHealthCount(5);
            panel.getCanvas().repaint(); 
        } else {
            //letter buttons
            button.setEnabled(false);

            JTextField guessField = panel.getGuessField();

            HangmanGame hangman = panel.getHangman();
            String n = button.getText();
            String key = hangman.getKey();
                
            
            
           // hangman.setGuess(clicks, n.charAt(0) - '0');
            clicks++;

            if (clicks == 26) {
                int health = hangman.getHealthCount();
                if (health == 0) {
                    panel.setGameState(HangmanPanel.GameState.GAMEOVER);
                    for (var b: panel.getLetterButtons()) {
                        b.setEnabled(false);
                    }
                } else {
                    // enable all letter buttons
                    for (var b: panel.getLetterButtons()) {
                        b.setEnabled(true);
                    } 
                } 

                clicks = 0;
                panel.getCanvas().repaint();
            }
        }
    }
}
    

