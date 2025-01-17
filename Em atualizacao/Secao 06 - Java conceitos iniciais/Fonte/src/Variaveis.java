/**
 * Variáveis armazenam valores que podem ser usados posteriormente dentro de um programa.
 * Toda variável possui um tipo. É o tipo de dado que diz qual o valor que pode ser armazenado.
 * Toda variável possui um nome, é como ela é referenciada dentro do programa.
 * Toda variável possui um nome único dentro de onde é declarada.
 * --
 * Nenhuma variável pode ser declarada com uma palavra reservada.
 * Palavras reservadas são palavras usadas para a linguagem, como class, static, void, public, String.
 */
public class Variaveis {
    public static void main(String[] args) {

        // Declaração
        String nome;

        // Inicialização
        nome = "Meu nome";

        // Uso da variável
        System.out.println("Meu nome é" + nome);
    }
}