package views;

import controllers.AllCardsListener;
import models.Cards;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class AllCards extends JPanel {
    private JButton backBtn;
    private AllCardsListener allCardsListener;

    public AllCards(Frame frame) {
        setLayout(new GridLayout(2, 2));


        // Add all cards in frame
        JSONArray cards = Cards.getCards();
        JSONParser jsonParser = new JSONParser();
        for (Object o : cards) {
            Object cardParse = null;
            try {
                cardParse = jsonParser.parse(o.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            JSONObject cardObject = (JSONObject) cardParse;
            Card card = new Card((String) cardObject.get("name"));
            allCardsListener = new AllCardsListener(frame, cardObject);
            card.addActionListener(allCardsListener);
            add(card);
        }

        // Back to menu button
        backBtn = new JButton("Retour vers le menu");
        backBtn.setActionCommand("back");
        backBtn.addActionListener(allCardsListener);

        add(backBtn);

    }
}
