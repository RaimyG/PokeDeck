package controllers;

import views.AllCards;
import views.Frame;
import views.Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditCardListener implements ActionListener {

    private Frame frame;

    public EditCardListener(Frame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        // Back to menu
        if ("back".equals(actionCommand)) {
            frame.getContentPane().removeAll();
            frame.setContentPane(new AllCards(frame));
            frame.revalidate();
        }
    }
}
