package views;

import controllers.AllCardsListener;
import models.Card;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.ArrayList;

public class AllCards extends JPanel {

    public AllCards(Frame frame) {
        GridLayout layout = new GridLayout(3, 9);
        layout.setHgap(30);
        layout.setVgap(30);
        setLayout(layout);

        ArrayList<models.Card> deck = Card.getDeck();

        for (Card card : deck) {
            views.Card c = new views.Card(card);
            c.addActionListener(new AllCardsListener(frame, card));
            add(c);
        }

        AllCardsListener allCardsListener = new AllCardsListener(frame);
        // Back to menu button
        JButton backBtn = new JButton("Retour vers le menu");
        backBtn.setActionCommand("back");
        backBtn.addActionListener(allCardsListener);

        add(backBtn);

    }
}
