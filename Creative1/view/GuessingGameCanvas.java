package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GuessingGameCanvas extends JPanel{

    public static int WIDTH = 500;
    public static int HEIGHT = 500;


    private GuessingGamePanel panel;

    public GuessingGameCanvas(GuessingGamePanel panel) {
        this.panel = panel;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.black);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // ready to play
        GuessingGamePanel.GameState state = panel.getGameState();
        if (state == GuessingGamePanel.GameState.READY) {
            g2.setColor(Color.yellow);
            Font currentFont = new Font("Courier New", Font.BOLD, 30);
            g2.setFont(currentFont);
            g2.drawString("Press <New> to Start", 70, 150);
        } else {

            if (state == GuessingGamePanel.GameState.GAMEOVER) {
                g2.setColor(Color.red);
                Font currentFont = new Font("Courier New", Font.BOLD, 30);
                g2.setFont(currentFont);
                g2.drawString("YOU LOST !!!", 150, 160);
                g2.setColor(Color.blue);
                g2.drawString("Press <New> to Start", 100, 240);
            }
            else if (state == GuessingGamePanel.GameState.WINNER) {
                g2.setColor(Color.green);
                Font currentFont = new Font("Courier New", Font.BOLD, 30);
                g2.setFont(currentFont);
                g2.drawString("WINNER!!!", 150, 160);
                g2.setColor(Color.blue);
                g2.drawString("Press <New> to Start", 100, 240);
            } else if (state == GuessingGamePanel.GameState.DRAW) {
                g2.setColor(Color.yellow);
                Font currentFont = new Font("Courier New", Font.BOLD, 30);
                g2.setFont(currentFont);
                g2.drawString("" + panel.getGuessingGame().getNum(), 150, 160);
            } else {
                Font currentFont = new Font("Courier New", Font.BOLD, 30);
                g2.setColor(Color.black);
                g2.drawString("" + panel.getGuessingGame().getNum(), 150, 160);
            g2.setColor(Color.blue);
            g2.setFont(currentFont); 
            }
        }
    }
}
