package character;

public class Goblin extends Character {

    /**
     * Construtor
     */
    public Goblin(int health, int attack, int defense) {
        super(health, attack, defense);
    }

    @Override
    public int attack() {
        return attack;
    }

    @Override
    public String toString() {
        // Exercicio: Como melhorar para imprimir o nome do inimigo?
        return super.toString();
    }
}
