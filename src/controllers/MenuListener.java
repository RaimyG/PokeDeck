package controllers;

import views.Menu;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener {

    public MenuListener() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "exit":
                System.exit(0);
                break;
            case "create":
                System.out.println("Création d'une carte");
                break;
        }
    }
}
