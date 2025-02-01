package character;

public class Archer extends Character {

    /**
     * Construtor
     */
    public Archer(int health, int attack, int defense) {
        super(health, attack, defense);
    }

    @Override
    public int attack() {
        return attack;
    }

    @Override
    public String toString() {
        return "Arqueiro";
    }
}