import java.util.Scanner;

public class Main {

    private int countCaracters(String str) {
        return str.length();
    }

    private int cubo(int num) {
        return num * num * num;
        // return Math.pow(num, 3);
    }

    private float milesToKm(float km) {
        return km * 1.6f;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe a quantidade de anos: ");
        int anos = scanner.nextInt();

        System.out.println(anos + " ano(s) corresponde a:");
        System.out.println(anos * 12 + " meses.");
        System.out.println(anos * 365 + " dias.");
        System.out.println(anos * 365 * 24 + " horas.");
        System.out.println(anos * 365 * 24 * 60 + " minutos");
        System.out.println(anos * 365 * 24 * 60 * 60 + " segundos");
    }
}
