package controllers;

import models.PokemonCard;
import views.AllCards;
import views.EditPokemonCardForm;
import views.Frame;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class EditPokemonCardListener implements ActionListener {

    PokemonCard card;
    private Frame frame;
    private EditPokemonCardForm editPokemonCardForm;

    public EditPokemonCardListener(Frame frame, PokemonCard card, EditPokemonCardForm editPokemonCardForm) {
        this.frame = frame;
        this.card = card;
        this.editPokemonCardForm = editPokemonCardForm;
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
            HashMap<String, String> fields = editPokemonCardForm.getFields();
            try {
                card.setId(Integer.parseInt(fields.get("id")));
                card.setName(fields.get("name"));
                card.setHp(Integer.parseInt(fields.get("hp")));
                card.getAttacks()[0].setName(fields.get("firstAttack"));
                card.getAttacks()[0].setDamage(Integer.parseInt(fields.get("firstAttackDamage")));
                card.getAttacks()[1].setName(fields.get("secondAttack"));
                card.getAttacks()[1].setDamage(Integer.parseInt(fields.get("secondAttackDamage")));
                frame.getContentPane().removeAll();
                frame.setContentPane(new AllCards(frame));
                frame.revalidate();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Oops, il ya un problème");
            }
        }
    }
}
