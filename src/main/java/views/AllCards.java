package views;

import controllers.AllCardsListener;
import models.Card;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.ArrayList;

public class AllCards extends JPanel {

    public AllCards(Frame frame) {
        setLayout(new GridLayout(3, 3));

        ArrayList<models.Card> cards = Card.getCards();

        for (Card card : cards) {
            System.out.println(card);
            add(new views.Card(card));
        }

        AllCardsListener allCardsListener = new AllCardsListener(frame);
        // Back to menu button
        JButton backBtn = new JButton("Retour vers le menu");
        backBtn.setActionCommand("back");
        backBtn.addActionListener(allCardsListener);

        add(backBtn);

    }
}
