/**
 * Controle de fluxo vai nos permitir tomar uma decisão durante a execução da aplicação.
 */
public class FluxoParte1 {

    private void maiorDeIdade(int idade) {

        // O controle de fluxo if tem o poder de alterar o fluxo do programa baseado numa condição.
        // Quando a expressão dentro do if é verdadeira, o código relacionado ao if é executado.
        // if (expressao)

        if (idade >= 18) {
            System.out.println("Maior de idade.");
        }
    }

    public static void main(String[] args) {
        FluxoParte1 fluxo = new FluxoParte1();

        fluxo.maiorDeIdade(15);
        fluxo.maiorDeIdade(21);
    }
}