import java.util.Scanner;

public class Main {
    public String controlePortaria() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe a idade: ");
        int idade = scanner.nextInt();

        if (idade < 18) {
            return "Negado. Menores de idade não são permitidos.";
        }

        System.out.print("Informe o tipo de convite: ");
        scanner.nextLine();
        String tipo = scanner.nextLine();

        if (!tipo.equals("comum") && !tipo.equals("premium") && !tipo.equals("luxo")) {
            return "Negado. Convite inválido.";
        }

        System.out.print("Informe o código do convite: ");
        String codigoConvite = scanner.nextLine();

        if ((tipo.equals("premium") || tipo.equals("luxo")) && codigoConvite.startsWith("XL")) {
            return "Welcome :)";
        }

        if (tipo.equals("comum") && codigoConvite.startsWith("XT")) {
            return "Welcome :)";
        }

        return "Negado. Convite inválido.";
    }
}