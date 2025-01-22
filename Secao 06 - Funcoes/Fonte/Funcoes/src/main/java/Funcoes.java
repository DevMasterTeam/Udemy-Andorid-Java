/**
 * Funções também podem ser chamadas de métodos.
*/
public class Funcoes {

    // Função sem argumentos, sem parâmetros
    private void helloWorld() {
        System.out.println("Olá, mundo!");
    }

    // Função espera um parâmetro do tipo String
    private void hello(String name) {
        System.out.println("Olá, " + name + "!");
    }

    // Função espera dois parâmetros do tipo inteiro e retorna um tipo inteiro
    private int soma(int n1, int n2) {
        // Uma variável criada dentro da função pertence somente a função.
        // Cada função tem seu escopo.
        int total = n1 + n2;
        return total;
    }

    public static void main(String[] args) {
        Funcoes funcoes = new Funcoes();
        funcoes.helloWorld();
        funcoes.hello("mundo");
        System.out.println(funcoes.soma(2, 2));
    }

}