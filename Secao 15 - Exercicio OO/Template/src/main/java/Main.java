import character.*;
import character.Character;

import java.util.Scanner;

// Exercicio: Ponto de entrada está com mais de 40 linhas de lógica. Como melhorar usando funções?
public class Main {

    public static void main(String[] args) {

        // Escolha do personagem hero
        Character hero;

        Scanner scanner = new Scanner(System.in);
        String character;

        do {
            System.out.println("Escolha seu personagem: ");
            System.out.println("Arqueiro (A)");
            System.out.println("Mago (M)");
            character = scanner.nextLine().trim().toLowerCase();
        } while (!character.equals("a") && !character.equals("m"));

        // Exercicio: É possível evitar comparação de Strings? Alguma outra opção mais segura?
        String option = character.equals("a") ? "Arqueiro" : "Mago";

        // Exercicio: É possível evitar comparação de Strings? Alguma outra opção mais segura?
        if (option.equals("Arqueiro")) {
            hero = new Archer(100, 15, 10);
        } else {
            hero = new Wizard(100, 15, 10);
        }

        // Cria o inimigo
        Character enemy = new Goblin(100, 18, 5);

        // Inicia a batalha
        Battle.start(hero, enemy);

        // Sistema de jogo - Executa até que acabe a batalha
        Thread battleThread = new Thread(() -> {

            while (hero.isAlive() && enemy.isAlive()) {
                Battle.fight();

                try {
                    Thread.sleep(2500);
                } catch (InterruptedException ignored) {
                }
            }
        });

        // Inicializa
        battleThread.start();
    }
}