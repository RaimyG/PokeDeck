package controllers;

import models.Cards;
import views.CreateCardForm;
import views.Frame;
import views.Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class CreateCardListener implements ActionListener {
    private Frame frame;
    private Cards card;
    private CreateCardForm createCardForm;

    public CreateCardListener(Frame frame, CreateCardForm createCardForm) {
        this.frame = frame;
        this.createCardForm = createCardForm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        // Back to menu
        if ("back".equals(actionCommand)) {
            frame.getContentPane().removeAll();
            frame.setContentPane(new Menu(frame));
            frame.revalidate();
        }
        // Write new card in file
        else if ("create".equals(actionCommand)) {
            Map<String, String> fields = createCardForm.getFields();
            Cards card = new Cards();
            card.create(fields);

            // Reset fields
            createCardForm.resetFields();
        }
    }
}
