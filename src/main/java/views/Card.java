package views;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

public class Card extends JButton {

    public Card(models.Card card) {
        super(card.getName());
        setBorder(BorderFactory.createLineBorder(Color.RED, 2,true));
        setOpaque(true);
    }
}
