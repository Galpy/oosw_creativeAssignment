package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.PiggyBankSimulator;

public class PBStatsListener implements ActionListener{

    private PiggyBankSimulator panel;

    public PBStatsListener(PiggyBankSimulator panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int nickels = 0;
        int dimes = 0;
        int quarters = 0;
        for (var coin: panel.getPiggyBank().getCoinHistory()) {
            switch (coin.getValue()) {
                case 5: ++nickels; break;
                case 10: ++dimes; break;
                case 25: ++ quarters; break;
            }
        }
        String existingMessage = panel.getDisplay().getText();
        existingMessage += "\nCoin Stats\n";
        String message = "";
        panel.getDisplay().setText(existingMessage + "Nickels: " + nickels + "\nDimes: " + dimes + "\nQuarters: " + quarters);
    }
    
}
