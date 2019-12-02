package models;

public class PokemonCard extends Card {
    private int hp;
    private Attack[] attacks = new Attack[2];

    /**
     * Create new Pokemon Card
     *
     * @param id      card's id
     * @param name    pokemon's name
     * @param hp      pokemon's Health points
     * @param attacks Array of pokemon's attacks
     */
    public PokemonCard(int id, String name, int hp, Attack[] attacks) {
        super(id, "pokemon", name);
        this.hp = hp;
        this.attacks = attacks;
        deck.add(this);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
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
