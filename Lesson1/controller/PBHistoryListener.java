package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Coin;
import view.PiggyBankSimulator;

public class PBHistoryListener implements ActionListener{

    private PiggyBankSimulator panel;

    public PBHistoryListener(PiggyBankSimulator panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Coin> history = panel.getPiggyBank().getCoinHistory();
        int index = 0;
        String existingMesage = panel.getDisplay().getText();
        String message = "";
        if (history.size() > 0) {
            for (var coin: history) {
                message += ++index + ". " + coin + "\n";
            }
            panel.getDisplay().setText(existingMesage + "\nCoin Insert History\n" + message);
        }
        else {
            panel.getDisplay().setText(existingMesage + "\n" + "No coin insert history");
        }
    }
    
}
