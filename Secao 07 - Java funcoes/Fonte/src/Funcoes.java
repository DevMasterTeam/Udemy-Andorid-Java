/**
 * Toda e qualquer função pertence a uma classe. Não existem funções fora de classes.
 * Funções permitem que um trecho de código seja isolado e chamado quando necessário.
 */
public class Funcoes {

    /**
     * Função sem parâmetro e sem tipo de retorno
     * void - Indica que uma fez feita a execução do corpo, não há retorno.
     */
    private void helloWorld() {
        System.out.println("Olá, mundo!");
    }

    /**
     * Função com tipo de retorno e parâmetro
     * Espera obrigatoriamente receber uma String e retorna outra String
     */
    private String hello(String nome) {
        return "Olá, " + nome;
    }

    /**
     * Função que chama outra função
     */
    private String hello(String nome, String sobrenome) {
        return hello(nome) + " " + sobrenome + "!";
    }

    public static void main(String[] args) {

        // Fazendo a instância da classe Funcoes para usar o método.
        Funcoes funcoes = new Funcoes();

        // Uso da função quantas vezes necessário
        funcoes.helloWorld();
        funcoes.helloWorld();
        funcoes.helloWorld();

        System.out.println(funcoes.hello("Luke", "Skywalker"));
    }

}
