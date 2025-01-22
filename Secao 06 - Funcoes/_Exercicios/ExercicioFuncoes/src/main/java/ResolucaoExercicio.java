import java.util.Scanner;

public class ResolucaoExercicio {

    private void exercicio1() {
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário a quantidade de anos
        System.out.print("Digite a quantidade de anos: ");
        int anos = scanner.nextInt();

        // Calcula a quantidade de meses, dias, horas, minutos e segundos
        int meses = anos * 12;
        int dias = anos * 365;
        int horas = dias * 24;
        int minutos = horas * 60;
        int segundos = minutos * 60;

        // Exibe o resultado
        System.out.println(anos + " ano(s) corresponde a:");
        System.out.println(meses + " meses");
        System.out.println(dias + " dias");
        System.out.println(horas + " horas");
        System.out.println(minutos + " minutos");
        System.out.println(segundos + " segundos");

        scanner.close();
    }

    // Função que conta a quantidade de caracteres de uma string
    private int exercicio2(String str) {
        return str.length();
    }

    private int exercicio3(int n) {
        return n * n * n;
    }

    private double exercicio4(double milhas) {
        return milhas * 1.6;
    }

    private double exercicio5(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
}
