package controllers;

import views.AllCards;
import views.EditCardForm;
import views.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditCardListener implements ActionListener {

    private Frame frame;
    private EditCardForm editCardForm;

    public EditCardListener(Frame frame, EditCardForm editCardForm) {
        this.frame = frame;
        this.editCardForm = editCardForm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        // Back to menu
        if ("back".equals(actionCommand)) {
            frame.getContentPane().removeAll();
            frame.setContentPane(new AllCards(frame));
            frame.revalidate();
        } else if ("save".equals(actionCommand)) {
            System.out.println("Carte sauvegardée (non, j'ai menti)");
        }
    }
}
