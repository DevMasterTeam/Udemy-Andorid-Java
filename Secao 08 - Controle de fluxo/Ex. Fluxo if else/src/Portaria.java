import java.util.Scanner;

public class Portaria {

    /**
     * Resolução priorizando o máximo de controle de fluxo aninhado.
     * A estrutura é mais complexa e pode dificultar o entendimento.
     */
    void controlePortaria() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();

        if (idade < 18) {
            System.out.println("Negado. Menores de idade não são permitidos.");
        } else {
            System.out.print("Informe o tipo de convite: ");
            scanner.nextLine();
            String tipo = scanner.nextLine();

            if (tipo.equals("comum") || tipo.equals("premium") || tipo.equals("luxo")) {
                System.out.print("Informe o código: ");
                String codigo = scanner.nextLine().toLowerCase();

                if (tipo.equals("comum") && codigo.startsWith("xt")) {
                    System.out.println("Welcome :)");
                } else if (codigo.startsWith("xl")) {
                    System.out.println("Welcome :)");
                } else {
                    System.out.println("Negado. Convite inválido.");
                }
            } else {
                System.out.println("Negado. Convite inválido.");
            }
        }
    }

    /**
     * Fazendo o uso do conceito "early return", traduzindo "retorno antecipado" ou "retorno cedo".
     * Consiste em retornar assim que é possível uma vez que já se tenha o resultado.
     * Nesse caso, esse padrão ajudou na escrita sem controle de fluxo aninhado.
     */
    String controlePortaria2() {
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

    public static void main(String[] args) {
        Portaria portaria = new Portaria();
        portaria.controlePortaria();
        portaria.controlePortaria2();
    }
}