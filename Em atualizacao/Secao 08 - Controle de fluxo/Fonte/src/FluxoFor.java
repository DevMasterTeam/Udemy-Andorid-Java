/**
 * For é um laço de repetição executado enquanto a condição é verdadeira.
 --
 * for (instrução 1; instrução 2; instrução 3)
 * Instrução 1 - Executada somente uma vez antes da execução do corpo do for
 * Instrução 2 - Define a condição antes de executar o corpo do for
 * Instrução 3 - Executada toda vez após a execução do corpo do for
 * */
public class FluxoFor {
    public static void main(String[] args) {

        // Repete o mesmo código até que a condição seja falsa
        for (int i = 0; i < 10; i++) {

            // Continue faz com que a execução passe para a próxima interação
            if (i == 2)
                continue;

            System.out.print(i + " ");

            // Possível de fazer verificações de fluxo
            if (i == 5) {
                // Para sair de um laço de repetição
                break;
            }
        }

        System.out.println();
        // É possível declarar uma variável dentro do for, como mostrado acima
        // Também possível declarar fora e usá-la dentro do dor
        int i;
        for (i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }

        System.out.println();
        // No exemplo abaixo, temos um for sem inicialização de variável, uma vez que valor já foi iniciado
        int j = 0;
        for (; j < 10; j++) {
            System.out.print(j + " ");
        }

        // O código abaixo fará com que o programa seja executado sem critério de parada.
        // Chamado de loop infinito. Já que não existe parada, roda até que haja um problema
        // de memória ou processamento.
        // for (;;) { }

    }
}