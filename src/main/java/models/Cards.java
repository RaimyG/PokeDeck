package models;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Cards {

    private String filename = "data.json";

    public Cards() {
    }

    public void create(Map<String, String> fields) {
        JSONObject card = new JSONObject(fields);
        JSONArray cards = new JSONArray();

        cards.add(card);

        JSONObject main = new JSONObject();
        main.put("cards", cards);

        // writing the JSONObject into a file(data.json)
        try {
            FileWriter fileWriter = new FileWriter("data.json");
            fileWriter.write(main.toJSONString());
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static JSONArray getCards() {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try {
            FileReader reader = new FileReader("data.json");
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject cardsObject = (JSONObject) obj;
            JSONArray cards = (JSONArray) cardsObject.get("cards");

            return cards;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
