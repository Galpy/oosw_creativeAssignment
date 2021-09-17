package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class HangmanCanvas extends JPanel{

    public static int WIDTH = 500;
    public static int HEIGHT = 500;

    private int health = 5;

    private HangmanPanel panel;

    public HangmanCanvas(HangmanPanel panel) {
        this.panel = panel;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.black);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // ready to play
        HangmanPanel.GameState state = panel.getGameState();
        if (state == HangmanPanel.GameState.READY) {
            g2.setColor(Color.yellow);
            Font currentFont = new Font("Courier New", Font.BOLD, 30);
            g2.setFont(currentFont);
            g2.drawString("Press <New> to Start", 70, 150);
        } else {

            if (state == HangmanPanel.GameState.GAMEOVER) {
                g2.setColor(Color.red);
                Font currentFont = new Font("Courier New", Font.BOLD, 30);
                g2.setFont(currentFont);
                g2.drawString("Game Over", 150, 160);
            }
            g2.setColor(Color.blue);
            Font currentFont = new Font("Courier New", Font.BOLD, 30);
            g2.setFont(currentFont);
            // draw balls
            g2.drawString("Lives: " + health, 200, 50);
            for (int i = 0; i < 5; i++) {
                if (i < health)
                    g2.fillRect(i * 80 + 70, 100, 50, 50);
                else
                    g2.drawRect(i * 80 + 70, 100, 50, 50);
            }
        }
    }
    
    public void setHealthCount(int health) {
        this.health = health;
    }
}
