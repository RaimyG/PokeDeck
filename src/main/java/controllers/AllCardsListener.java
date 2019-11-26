package controllers;

import models.Cards;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import views.Card;
import views.CardEditForm;
import views.Frame;
import views.Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class AllCardsListener implements ActionListener {

    private Frame frame;
    JSONObject card;

    public AllCardsListener(Frame frame, JSONObject card) {
        this.frame = frame;
        this.card = card;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        // Back to menu
        if ("back".equals(actionCommand)) {
            frame.getContentPane().removeAll();
            frame.setContentPane(new Menu(frame));
            frame.revalidate();
        } else {
            frame.getContentPane().removeAll();
            frame.setContentPane(new CardEditForm(frame, card));
            frame.revalidate();
        }
    }
}
