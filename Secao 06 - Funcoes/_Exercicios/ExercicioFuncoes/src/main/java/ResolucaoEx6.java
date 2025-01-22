import java.util.Scanner;

public class ResolucaoEx6 {
    // Função para ler a string do usuário
    private String lerString(String titulo) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(titulo);
        return scanner.nextLine();
    }

    // Função para trocar todas as letras "a" ou "A" por "x" e retornar a string final
    private void trocarLetras(String str) {
        // Troca as letras 'a' ou 'A' por 'x' e converte para minúsculas
        System.out.println(str.toLowerCase().replace("a", "x"));
    }

    public static void main(String[] args) {
        ResolucaoEx6 ex6 = new ResolucaoEx6();
        ex6.trocarLetras(ex6.lerString("Digite uma string: "));
    }
}