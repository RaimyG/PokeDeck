package views;

import controllers.EditPokemonCardListener;
import models.Card;
import models.PokemonCard;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.util.HashMap;

public class EditPokemonCardForm extends JPanel {

    private JTextField numField;
    private JTextField nameField;
    private JTextField hpField;
    private JList typeList;
    private JTextField firstAttackField;
    private JTextField firstAttackDamageField;
    private JTextField secondAttackField;
    private JTextField secondAttackDamageField;

    public EditPokemonCardForm(Frame frame, PokemonCard card) {
        GridLayout layout = new GridLayout(0, 2);

        System.out.println();

        setLayout(layout);

        // Card's ID
        JLabel numLabel = new JLabel("Numéro de la carte");
        numField = new JTextField(String.valueOf(card.getId()));
        add(numLabel);
        add(numField);

        // First information (name)
        JLabel nameLabel = new JLabel("Nom du pokemon");
        nameField = new JTextField(card.getName());
        add(nameLabel);
        add(nameField);

        // (Health points)
        JLabel hpLabel = new JLabel("Points de vie du pokemon");
        hpField = new JTextField(String.valueOf(card.getHp()));
        add(hpLabel);
        add(hpField);

        // (Type)
        JLabel typeLabel = new JLabel("Type du pokémon");
        JScrollPane scrollPane = new JScrollPane();
        typeList = new JList(Card.getTypes());
        typeList.setSelectedValue(card.getTypePokemon(), true);
        scrollPane.setViewportView(typeList);
        add(typeLabel);
        add(scrollPane);

        // (First attack name)
        JLabel firstAttackLabel = new JLabel("Première attaque");
        firstAttackField = new JTextField(card.getAttacks()[0].getName());
        add(firstAttackLabel);
        add(firstAttackField);

        // (First attack damage)
        JLabel firstAttackDamageLabel = new JLabel("Dommage de la première attaque");
        firstAttackDamageField = new JTextField(String.valueOf(card.getAttacks()[0].getDamage()));
        add(firstAttackDamageLabel);
        add(firstAttackDamageField);

        // (Second attack name)
        JLabel secondAttackLabel = new JLabel("Deuxième attaque");
        secondAttackField = new JTextField(card.getAttacks()[1].getName());
        add(secondAttackLabel);
        add(secondAttackField);

        // (Second attack damage)
        JLabel secondAttackDamageLabel = new JLabel("Dommage de la seconde attaque");
        secondAttackDamageField = new JTextField(String.valueOf(card.getAttacks()[1].getDamage()));
        add(secondAttackDamageLabel);
        add(secondAttackDamageField);

        // Listener
        EditPokemonCardListener editPokemonCardListener = new EditPokemonCardListener(frame, card, this);

        // Delete card button
        JButton deleteBtn = new JButton("Supprimer la carte");
        deleteBtn.setActionCommand("delete");
        deleteBtn.addActionListener(editPokemonCardListener);
        add(deleteBtn);

        // Add card button
        JButton addBtn = new JButton("Sauvegarder");
        addBtn.setActionCommand("save");
        addBtn.addActionListener(editPokemonCardListener);
        add(addBtn);

        // Back button
        JButton menuBtn = new JButton("Retour");
        menuBtn.setActionCommand("back");
        menuBtn.addActionListener(editPokemonCardListener);

    }

    public HashMap<String, String> getFields() {
        HashMap<String, String> fields = new HashMap<String, String>();
        fields.put("id", numField.getText());
        fields.put("name", nameField.getText());
        fields.put("hp", hpField.getText());
        fields.put("typePokemon", typeList.getSelectedValue().toString());
        fields.put("firstAttack", firstAttackField.getText());
        fields.put("firstAttackDamage", firstAttackDamageField.getText());
        fields.put("secondAttack", secondAttackField.getText());
        fields.put("secondAttackDamage", secondAttackDamageField.getText());
        return fields;
    }
}
