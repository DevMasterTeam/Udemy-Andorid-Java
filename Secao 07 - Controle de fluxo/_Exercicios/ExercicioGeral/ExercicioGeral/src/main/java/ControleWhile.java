import java.util.Scanner;

public class ControleWhile {

    private void caixaDagua() {
        int caixa = 2000;
        int balao = 7;

        int numBaloes = 0;
        int preenchimento = 0;
        while ((preenchimento + balao) <= caixa) {
            numBaloes++;
            preenchimento += balao;
        }
        System.out.println("Na caixa d'água cabem " + numBaloes + " balões.");
    }

    private void fizzBuzz() {
        int i = 1;
        while (i <= 50) {
            if (i % 15 == 0) {
                System.out.print(" FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.print(" Buzz");
            } else if (i % 5 == 0) {
                System.out.print(" Fizz");
            } else {
                System.out.print(" " + i);
            }
            i++;
        }
    }

    private void inverteString(String str) {
        int length = str.length();

        // Caso seja necessário retornar a string invertida
        // String inverso = "";
        while (length > 0) {
            System.out.print(str.charAt(length - 1));
            // inverso += str.charAt(length - 1);
            length--;
        }
    }

    private boolean xxoo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um texto para verficação xxoo: ");
        String str = scanner.nextLine();
        str = str.toLowerCase();

        int i = 0;
        int countX = 0;
        int countO = 0;
        while (i < str.length()) {
            if (str.charAt(i) == 'x') {
                countX++;
            } else if (str.charAt(i) == 'o') {
                countO++;
            }
            i++;
        }

        return (countO == countX) && (countO != 0);
    }

    public static void main(String[] args) {
        new ControleWhile().caixaDagua();
        new ControleWhile().fizzBuzz();

        System.out.println();
        new ControleWhile().inverteString("Programa capaz de receber um texto");

        System.out.println();
        boolean retBoolean = new ControleWhile().xxoo();
        System.out.println(retBoolean);
    }
}