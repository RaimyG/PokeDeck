package views;

import controllers.MenuListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class Menu extends JPanel {

    private JButton createBtn;
    private JButton showBtn;
    private JButton exitBtn;

    public Menu(Frame frame) {
        createBtn = new JButton("Ajouter une carte");
        showBtn = new JButton("Voir toutes mes cartes");
        exitBtn = new JButton("Quitter");

        GridLayout gridLayout = new GridLayout(3, 0);
        MenuListener menuListener = new MenuListener(frame);

        gridLayout.setVgap(20);

        createBtn.addActionListener(menuListener);
        showBtn.addActionListener(menuListener);
        exitBtn.addActionListener(menuListener);

        createBtn.setActionCommand("create");
        showBtn.setActionCommand("show");
        exitBtn.setActionCommand("exit");

        setLayout(gridLayout);
        add(createBtn);
        add(showBtn);
        add(exitBtn);

    }
}
