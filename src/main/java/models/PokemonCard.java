package models;

public class PokemonCard extends Card {
    private int hp;
    private Attack[] attacks = new Attack[2];

    public PokemonCard(String name, int hp,  Attack[] attacks) {
        super(name);
        this.hp = hp;
        this.attacks = attacks;
        cards.add(this);
    }

    @Override
    public String toString() {
        return  "----------------------------\n"+
                name + " | " + hp + " hp |\n" +
                attacks[0].getName()+ " | " + attacks[0].getDamage()+ " |\n" +
                attacks[1].getName()+ " | " + attacks[1].getDamage()+ " |\n" +
                "----------------------------";
    }
}
