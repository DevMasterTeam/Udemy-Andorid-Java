/**
 * Todos os tipos de dados possuem tipos primitivos associados, exceto String.
 * Double       - double
 * Float        - float
 * Long         - long
 * Integer      - int
 * Short        - short
 * Byte         - byte
 * Boolean      - boolean
 * Character    - char
 * --
 * Tipos que não são primitivos são chamados de objetos.
 * A diferença entre os dois tipos é que os tipos primitivos não possuem as 
 * operações/funções que os objetos/classes possuem.
 * --
 * No entanto, ambos podem representar a mesma informação básica. Por exemplo:
 * int n1 = 10;
 * Integer n2 = 10;
 * --
 * Ambos armazenam o número 10, mas a classe Integer oferece métodos adicionais, 
 * como Integer.parseInt(), n2.toString(), e outras funcionalidades que o tipo primitivo não possui.
 * Representam a mesma informação. Diferem nos métodos auxiliares e propriedades.
 * */
public class TiposPrimitivos {

    public static void main(String[] args) {

        Integer valor1 = 10;
        int valor2 = 20;

        // Faz a conversão de um inteiro para String
        valor1.toString();

        // Não existe
        // valor2.toString();
    }
}