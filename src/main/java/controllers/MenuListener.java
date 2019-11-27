package controllers;

import models.Card;
import views.AllCards;
import views.CreateCardForm;
import views.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener {

    private Frame frame;

    public MenuListener(Frame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if ("exit".equals(actionCommand)) {
            Card.saveCards();
            System.exit(0);
        } else if ("create".equals(actionCommand)) {
            frame.getContentPane().removeAll();
            frame.setContentPane(new CreateCardForm(frame));
            frame.revalidate();
        } else if ("show".equals(actionCommand)) {
            frame.getContentPane().removeAll();
            frame.setContentPane(new AllCards(frame));
            frame.revalidate();
        }
    }
}
