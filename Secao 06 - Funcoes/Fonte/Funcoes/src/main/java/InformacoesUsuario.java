import java.util.Scanner;

public class InformacoesUsuario {
    public static void main(String[] args) {

        // Scanner fará a leitura das informações
        Scanner scanner = new Scanner(System.in);

        System.out.print("Por favor, informe um número: ");

        // Leitura de um inteiro
        int inteiro = scanner.nextInt();
        System.out.println("Número: " + inteiro);

        // Terminada a leitura do dado
        System.out.println("Fim da execução.");

        // Métodos correspondentes para todos os tipos de dados
        Double doubleValor = scanner.nextDouble();
        Float floatValor = scanner.nextFloat();
        Long longValor = scanner.nextLong();
        Integer intValor = scanner.nextInt();
        Short shortValor = scanner.nextShort();
        Byte byteValor = scanner.nextByte();
        Boolean bool = scanner.nextBoolean();
        String string = scanner.nextLine();
    }
}