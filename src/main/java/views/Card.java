package views;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class Card extends JButton {

    public Card(models.Card card) {
        super(card.getName());
        setBackground(new Color(153, 0, 0));
        setForeground(Color.WHITE);
        setFont(new Font("Arial", Font.BOLD, 20));
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2,true));
        setOpaque(true);
    }
}
