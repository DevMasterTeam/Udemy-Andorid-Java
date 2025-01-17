import java.util.Scanner;

public class SubstituicaoString {

    private void replace(String str) {
        String replaced = str.replace("a", "x").replace("A", "x");
        System.out.println(replaced.toLowerCase());
    }

    private void readString() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe um texto: ");
        String str = scanner.nextLine();
        replace(str);
    }

    public static void main(String[] args) {
        new SubstituicaoString().readString();
    }
}