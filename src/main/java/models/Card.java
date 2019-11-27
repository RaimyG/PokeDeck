package models;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Card {
    protected static ArrayList<Card> cards = new ArrayList<Card>();
    protected String name;

    public Card(String name) {
        this.name = name;
    }

    public static ArrayList<Card> getCards() {
        return cards;
    }

    public static void saveCards() {

        String json = new Gson().toJson(cards);
        try {
            FileWriter writer = new FileWriter("data.json");
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initializeCard() {
        Gson gson = new Gson();
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader("data.json"));
            cards = gson.fromJson(reader, ArrayList.class);
            cards.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public String getName() {
        return name;
    }
}
