package models;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Card {
    private static String[] types = {
        "Acier",
        "Combat",
        "Dragon",
        "Eau",
        "Electrik",
        "Fée",
        "Feu",
        "Glace",
        "Insecte",
        "Normal",
        "Plante",
        "Poison",
        "Psy",
        "Roche",
        "Sol",
        "Spectre",
        "Ténèbres",
        "Vol"
    };
    protected static ArrayList<Card> deck = new ArrayList<Card>();
    protected int id;
    protected String type;
    protected String name;

    public Card(int id, String type, String name) {
        this.id = id;
        this.type = type;
        this.name = name;
    }

    public static ArrayList<Card> getDeck() {
        return deck;
    }

    /**
     * Save the deck of cards in a json file
     */
    public static void saveDeck() {
        String json = new Gson().toJson(deck);
        try {
            FileWriter writer = new FileWriter("data.json");
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initialize the deck of cards by reading the json file
     */
    public static void initializeDeck() {
        Gson gson = new Gson();
        BufferedReader bufferedReader = null;
        try {
            // Read file
            bufferedReader = new BufferedReader(new FileReader("data.json"));
            JsonElement tree = new JsonParser().parse(bufferedReader);
            if (!tree.isJsonNull()) {
                JsonArray array = tree.getAsJsonArray();
                // Create new card foreach found element in json
                for (JsonElement card : array) {
                    JsonObject json = card.getAsJsonObject();

                    // Create pokemon card
                    if (json.get("type").getAsString().equals("pokemon")) {
                        int id = json.get("id").getAsInt();
                        String name = json.get("name").getAsString();
                        int hp = json.get("hp").getAsInt();
                        String typePokemon = json.get("typePokemon").getAsString();

                        // Prepare first attack data
                        JsonElement attack1json = json.get("attacks").getAsJsonArray().get(0);
                        String attack1name = attack1json.getAsJsonObject().get("name").getAsString();
                        int attack1dmg = attack1json.getAsJsonObject().get("damage").getAsInt();
                        Attack attack1 = new Attack(attack1name, attack1dmg);

                        // Prepare 2nd attack data
                        JsonElement attack2json = json.get("attacks").getAsJsonArray().get(1);
                        String attack2name = attack2json.getAsJsonObject().get("name").getAsString();
                        int attack2dmg = attack2json.getAsJsonObject().get("damage").getAsInt();
                        Attack attack2 = new Attack(attack2name, attack2dmg);

                        new PokemonCard(id, name, hp, typePokemon, new Attack[]{attack1, attack2});

                    } else {
                        System.out.println("Not pokemon card");
                    }

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static String[] getTypes() {
        return types;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
