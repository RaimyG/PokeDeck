package controllers;

import models.Attack;
import models.Card;
import models.PokemonCard;
import views.CreateCardForm;
import views.Frame;
import views.Menu;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class CreateCardListener implements ActionListener {
    private Frame frame;
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
        
        // Add new card in cards
        else if ("create".equals(actionCommand)) {
            Map<String, String> fields = createCardForm.getFields();
            try {
                int id = Integer.parseInt(fields.get("id"));
                String name = fields.get("name");
                int hp = Integer.parseInt(fields.get("hp"));
                Attack attack1 = new Attack(fields.get("firstAttack"), Integer.parseInt(fields.get("firstAttackDamage")));
                Attack attack2 = new Attack(fields.get("secondAttack"), Integer.parseInt(fields.get("secondAttackDamage")));
                new PokemonCard(id, name, hp, new Attack[]{attack1, attack2});
                createCardForm.resetFields();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Erreur : " + ex.getMessage());
            }
        }
    }
}
