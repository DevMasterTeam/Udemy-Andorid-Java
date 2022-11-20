import java.util.Scanner;

public class InformacoesUsuario {

    public static void main(String[] args) {

        // Scanner fará a leitura das informações
        Scanner scanner = new Scanner(System.in);

        // Console fica a espera da informação
        System.out.print("Por favor, informe um número: ");

        // Leitura de um inteiro
        int inteiro = scanner.nextInt();
        System.out.println("Número: " + inteiro);

        // Terminada a leitura da informação
        System.out.println("Fim da execução.");

        // Métodos correspondentes para todos os tipos de dados
        double doubleValor = scanner.nextDouble();
        float floatValor = scanner.nextFloat();
        long longValor = scanner.nextLong();
        int intValor = scanner.nextInt();
        short shortValor = scanner.nextShort();
        byte byteValor = scanner.nextByte();
        boolean bool = scanner.nextBoolean();
        String string = scanner.nextLine();

    }
}