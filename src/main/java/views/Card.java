package views;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class Card extends JButton {

    public Card(String name) {
        super(name);
        setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        setBackground(Color.WHITE);
        setOpaque(true);
    }
}
