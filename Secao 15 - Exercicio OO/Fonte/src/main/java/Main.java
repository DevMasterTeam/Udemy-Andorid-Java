import character.*;
import character.Character;
import utils.CharacterOptions;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Escolha do personagem hero
        Character hero = chooseCharacter();

        // Cria o inimigo
        Character enemy = createEnemy();

        // Inicia a batalha
        Battle.start(hero, enemy);

        // Sistema de jogo - Executa até que acabe a batalha
        Thread battleThread = new Thread(() -> {
            while (hero.isAlive() && enemy.isAlive()) {
                Battle.fight();
                sleep(2500);
            }
        });

        // Inicializa
        battleThread.start();
    }

    /**
     * Exibe um menu para o usuário escolher um personagem entre Arqueiro (A) e Mago (M).
     * O método garante que a entrada seja válida antes de retornar a escolha correspondente.
     */
    private static CharacterOptions getUserInputForCharacter() {
        Scanner scanner = new Scanner(System.in);
        String character;

        do {
            System.out.println("Escolha seu personagem: ");
            System.out.println("Arqueiro (A)");
            System.out.println("Mago (M)");
            character = scanner.nextLine().trim().toLowerCase();
        } while (!character.equals("a") && !character.equals("m"));

        return character.equals("a") ? CharacterOptions.Archer : CharacterOptions.Wizard;
    }

    /**
     * Cria e retorna uma instância do personagem escolhido pelo usuário.
     */
    private static Character chooseCharacter() {
        if (getUserInputForCharacter() == CharacterOptions.Archer) {
            return new Archer(100, 15, 10);
        } else {
            return new Wizard(100, 15, 10);
        }
    }

    /**
     * Cria inimigo
     */
    private static Character createEnemy() {
        return new Goblin(100, 18, 5);
    }

    /**
     * Faz com que a Thread espere por um tempo configurado.
     */
    private static void sleep(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException ignored) {
        }
    }
}