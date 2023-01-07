import java.util.Scanner;

public class ControleFor {

    private void exA() {
        for (int i = 1; i <= 50; i++) {
            System.out.print(i + " ");
        }
    }

    private void exB() {
        for (int i = 50; i >= 1; i--) {
            System.out.print(i + " ");
        }
    }

    private void exC() {
        for (int i = 1; i <= 50; i++) {
            if (i % 5 == 0)
                continue;
            System.out.print(i + " ");
        }
    }

    private void exD() {
        int soma = 0;
        for (int i = 1; i <= 500; i++) {
            soma += i;
        }
        System.out.println("Soma: " + soma);
    }

    // Escada
    private void exE(int n) {
        int interacao = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < interacao; j++) {
                System.out.print("#");
            }
            interacao++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new ControleFor().exA();
        System.out.println();
        new ControleFor().exB();
        System.out.println();
        new ControleFor().exC();
        System.out.println();
        new ControleFor().exD();
        System.out.println();

        new ControleFor().exE(3);
        System.out.println();
        new ControleFor().exE(5);
        System.out.println();
    }
}