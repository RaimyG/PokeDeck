package models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.util.Map;

public class Card {

    public Card() {}

    public void create(Map<String, String> fields) {
        JSONObject card = new JSONObject(fields);
        JSONArray cards = new JSONArray();

        cards.put(card);

        JSONObject main = new JSONObject();
        main.put("cards", cards);

        // writing the JSONObject into a file(data.json)
        try {
            FileWriter fileWriter = new FileWriter("data.json");
            fileWriter.write(main.toString());
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
