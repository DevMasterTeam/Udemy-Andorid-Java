/**
 * Enhanced for é uma abreviação do laço de repetição for. Sintaxe:
 * for (DECLARAÇÃO VARIAVEL : ARRAY) { }
 * */
public class EnhancedFor {

    // Recebimento de um array por parâmetro
    private void arrayPorParametro(int[] array) {
        System.out.println("Tamanho do array recebido: " + array.length);
    }

    // ... se chama varargs e é a capacidade de receber inúmeros valores por parâmetro na mesma variável
    // Variação da maneira de receber arrays;
    public void printValues(int... values) {
        for (int value : values) {
            System.out.println(value);
        }

        System.out.println("Tamanho do array recebido: " + values.length);
    }

    public static void main(String[] args) {
        // Declaração com inicialização
        int[] numbers = {1, 2, 3, 4, 5};

        // Enhanced for
        for (int num : numbers) {
            System.out.println(num);
        }
    }
}