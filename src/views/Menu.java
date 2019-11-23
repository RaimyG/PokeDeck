package views;

import controllers.MenuListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class Menu extends JPanel {

    private JButton btnCreate;
    private JButton btnEdit;
    private JButton btnExit;

    public Menu() {
        btnCreate = new JButton("Ajouter une carte");
        btnEdit = new JButton("Modifier une carte");
        btnExit = new JButton("Quitter");

        GridLayout gridLayout = new GridLayout(3, 1);
        MenuListener menuListener = new MenuListener();

        gridLayout.setVgap(20);

        btnCreate.addActionListener(menuListener);
        btnEdit.addActionListener(menuListener);
        btnExit.addActionListener(menuListener);

        btnCreate.setActionCommand("create");
        btnEdit.setActionCommand("edit");
        btnExit.setActionCommand("exit");

        setLayout(gridLayout);
        add(btnCreate);
        add(btnEdit);
        add(btnExit);

    }
}
