import java.util.Scanner;

public class Main {

    private void ex1() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro lado: ");
        int lado1 = scanner.nextInt();

        System.out.print("Digite o segundo lado: ");
        int lado2 = scanner.nextInt();

        if (lado1 == lado2) {
            System.out.println("Quadrado!");
        } else {
            System.out.println("Não é um quadrado.");
        }
    }

    private void ex2() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro lado: ");
        int lado1 = scanner.nextInt();

        System.out.print("Digite o segundo lado: ");
        int lado2 = scanner.nextInt();

        System.out.print("Digite o terceiro lado: ");
        int lado3 = scanner.nextInt();

        if ((lado1 == lado2) && (lado2 == lado3)) {
            System.out.println("Equilátero!");
        } else {
            System.out.println("Não é um triângulo equilátero.");
        }
    }

    private void ex3(int num) {
        if (num >= 0)
            if (num == 0)
                System.out.println("Primeira string");
            else
                System.out.println("Segunda string");
        System.out.println("Terceira string");
    }

    public static void main(String[] args) {
        new Main().ex1();
        new Main().ex2();
        new Main().ex3(4);
    }
}
