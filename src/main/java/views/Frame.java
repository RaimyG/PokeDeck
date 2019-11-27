package views;

import models.Card;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Frame extends JFrame {

    private Menu menu;

    public Frame() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(null,
                        "Êtes-vous sûr de vouloir quitter ?", "Fermeture",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    Card.saveCards();
                    System.exit(0);
                }
            }
        });

        menu = new Menu(this);

        setContentPane(menu);
        //add(menu);
    }
}
