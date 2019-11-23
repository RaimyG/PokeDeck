package views;

import javax.swing.JFrame;

public class Frame extends JFrame {

    private Menu menu;

    public Frame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        menu = new Menu();
        add(menu);
    }
}
