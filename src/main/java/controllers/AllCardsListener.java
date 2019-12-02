package controllers;

import models.Card;
import models.PokemonCard;
import views.EditPokemonCardForm;
import views.Frame;
import views.Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AllCardsListener implements ActionListener {

    private Frame frame;
    private Card card;

    public AllCardsListener(Frame frame, models.Card card) {
        this.frame = frame;
        this.card = card;
    }

    public AllCardsListener(Frame frame) {
        this.frame = frame;
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
            frame.setContentPane(new EditPokemonCardForm(frame,(PokemonCard) card));
            frame.revalidate();
        }
    }
}
