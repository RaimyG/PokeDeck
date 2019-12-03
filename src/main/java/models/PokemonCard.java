package models;

public class PokemonCard extends Card {
    private int hp;
    private String typePokemon;
    private Attack[] attacks = new Attack[2];

    /**
     * Create new pokemon card
     *
     * @param id card id
     * @param name pokemon name
     * @param hp health points
     * @param typePokemon pokemon type
     * @param attacks pokemon attacks
     */
    public PokemonCard(int id, String name, int hp, String typePokemon, Attack[] attacks) {
        super(id, "pokemon", name);
        this.hp = hp;
        this.typePokemon = typePokemon;
        this.attacks = attacks;
        deck.add(this);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getTypePokemon() {
        return typePokemon;
    }

    public void setTypePokemon(String typePokemon) {
        this.typePokemon = typePokemon;
    }

    public Attack[] getAttacks() {
        return attacks;
    }

    @Override
    public String toString() {
        return "----------------------------\n" +
                name + " | " + hp + " hp |\n" +
                attacks[0].getName() + " | " + attacks[0].getDamage() + " |\n" +
                attacks[1].getName() + " | " + attacks[1].getDamage() + " |\n" +
                "----------------------------";
    }
}
