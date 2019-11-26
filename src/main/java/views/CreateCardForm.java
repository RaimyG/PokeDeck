package views;

import controllers.CreateCardListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.util.HashMap;

public class CreateCardForm extends JPanel {

    private JTextField nameField;
    private JTextField hpField;
    private JTextField firstAttackField;
    private JTextField firstAttackDamageField;
    private JTextField secondAttackField;
    private JTextField secondAttackDamageField;

    public CreateCardForm(Frame frame) {
        GridLayout layout = new GridLayout(0, 2);

        setLayout(layout);

        // First information (name)
        JLabel nameLabel = new JLabel("Nom du pokemon");
        nameField = new JTextField();
        add(nameLabel);
        add(nameField);

        // 2nd information (Health points)
        JLabel hpLabel = new JLabel("Points de vie du pokemon");
        hpField = new JTextField();
        add(hpLabel);
        add(hpField);

        // 3rd information (First attack name)
        JLabel firstAttackLabel = new JLabel("Première attaque");
        firstAttackField = new JTextField();
        add(firstAttackLabel);
        add(firstAttackField);

        // 4th information (First attack damage)
        JLabel firstAttackDamageLabel = new JLabel("Dommage de la première attaque");
        firstAttackDamageField = new JTextField();
        add(firstAttackDamageLabel);
        add(firstAttackDamageField);

        // 5th information (Second attack name)
        JLabel secondAttackLabel = new JLabel("Deuxième attaque");
        secondAttackField = new JTextField();
        add(secondAttackLabel);
        add(secondAttackField);

        // 6th information (Second attack damage)
        JLabel secondAttackDamageLabel = new JLabel("Dommage de la seconde attaque");
        secondAttackDamageField = new JTextField();
        add(secondAttackDamageLabel);
        add(secondAttackDamageField);

        // Listener
        CreateCardListener createCardListener = new CreateCardListener(frame, this);

        // Menu button
        JButton menuBtn = new JButton("Retour");
        menuBtn.setActionCommand("back");
        menuBtn.addActionListener(createCardListener);
        add(menuBtn);

        // Add card button
        JButton addBtn = new JButton("Créer la carte");
        addBtn.setActionCommand("create");
        addBtn.addActionListener(createCardListener);
        add(addBtn);

    }

    public HashMap<String, String> getFields() {
        HashMap<String, String> fields = new HashMap<String, String>();
        fields.put("name", nameField.getText());
        fields.put("hp", hpField.getText());
        fields.put("firstAttack", firstAttackField.getText());
        fields.put("firstAttackDamage", firstAttackDamageField.getText());
        fields.put("secondAttack", secondAttackField.getText());
        fields.put("secondAttackDamage", secondAttackDamageField.getText());
        return fields;
    }

    public void resetFields() {
        nameField.setText("");
        hpField.setText("");
        firstAttackField.setText("");
        firstAttackDamageField.setText("");
        secondAttackField.setText("");
        secondAttackDamageField.setText("");
    }
}
