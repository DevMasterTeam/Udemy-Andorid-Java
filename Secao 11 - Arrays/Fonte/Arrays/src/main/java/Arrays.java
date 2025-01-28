import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Um array é uma estrutura de dados que permite armazenar uma coleção de valores do mesmo tipo.
 * Ele é útil quando precisamos trabalhar com múltiplos elementos relacionados e acessar
 * esses elementos de forma ordenada, utilizando índices.
 * --------
 * Arrays em Java possuem um tamanho fixo, definido no momento da criação.
 * Esse tamanho não pode ser alterado posteriormente.
 * -------
 * Quando um array é criado, os elementos são automaticamente inicializados com valores padrão,
 * dependendo do tipo de dado:
 * -> Tipos primitivos: Os valores padrão são 0 para inteiros, 0.0 para números de ponto flutuante,
 * e false para booleanos.
 * -> Objetos: O valor padrão é null.
 */
public class Arrays {

    // Fazendo uso de loops (controle de luxo)
    private void percorreArray() {
        int[] array = {1, 2, 3, 4, 5};
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    // Preenchimento de três números a partir do teclado. Validações com controle de fluxo.
    private void preenchaTresNumeros() {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[3];
        int index = 0;
        do {
            System.out.print("Informe numero inteiro [" + (index + 1) + "]: ");
            try {
                int valor = scanner.nextInt();
                numeros[index] = valor;
                index++;
            } catch (InputMismatchException excp) {
                System.out.println("Formato incorreto.");
                scanner.nextLine();
            }
        } while (index < 3);

        System.out.println("Sequência de numeros: ");
        for (int i  = 0; i < numeros.length; i++ ){
            System.out.print(numeros[i] + " ");
        }
    }

    public static void main(String[] args) {
        // Declaração com inicialização
        int[] array1 = {1, 2, 3, 4, 5};

        // Somente declaração - Deve ser inicializado posteriormente
        int[] array2;

        // Array sem inicialização de valores, mas com informação de tamanho
        int[] array3 = new int[15];
        // Valor abaixo vai resultar em 0, já que o valor padrão de um int (primitivo) é 0
        System.out.println(array3[0]);

        // Array sem inicialização de valores, mas com informação de tamanho
        Integer[] array4 = new Integer[10];
        // Valor resulta em null que é o padrão de um objeto não inicializado
        System.out.println(array4[0]);
    }
}