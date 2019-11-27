package controllers;

import views.Card;
import views.EditCardForm;
import views.Frame;
import views.Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AllCardsListener implements ActionListener {

    private Frame frame;
    private Card card;

    public AllCardsListener(Frame frame) {
        this.frame = frame;
    }

    public AllCardsListener(Card card) {
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
            frame.setContentPane(new EditCardForm(frame, card));
            frame.revalidate();
        }
    }
}
