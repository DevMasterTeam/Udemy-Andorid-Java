package character;

import java.util.Random;

/**
 * Classe abstrata que representa um personagem no jogo.
 * Define atributos básicos como vida, ataque e defesa, além de métodos para ataque e dano.
 */
public abstract class Character {

    /**
     * Quantidade de vida do personagem.
     */
    protected int health;

    /**
     * Poder de ataque do personagem.
     */
    protected int attack;

    /**
     * Poder de defesa do personagem.
     */
    protected int defense;

    /**
     * Construtor
     */
    public Character(int health, int attack, int defense) {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    /**
     * Método abstrato que deve ser implementado por subclasses para definir o ataque do personagem.
     */
    public abstract int attack();

    /**
     * Aplica dano ao personagem, considerando sua defesa.
     */
    public void receiveDamage(int damage) {
        Random random = new Random();

        // 25% de chance desviar do ataque
        if (random.nextDouble() < 0.25) {
            System.out.println(this + " esquivou do ataque!");
            return;
        }

        int damageTaken = Math.max(damage - defense, 0);
        health = Math.max(health - damageTaken, 0);
        System.out.println(this + " recebeu " + damageTaken + " de dano! Vida atual: " + health);
    }

    /**
     * Verifica se o personagem ainda está vivo.
     */
    public boolean isAlive() {
        return health > 0;
    }
}