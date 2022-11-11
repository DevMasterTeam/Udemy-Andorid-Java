/**
 * Tipos primitivos: armazenamento simples de valor
 * Tipos não primitivos: Possuem métodos/funções dentro deles além de armazenar valores
* */
public class TiposPrimitivos {
    public static void main(String[] args) {

        // Tipos primitivos
        int i = 8;
        float f = 10.5f;
        boolean b = true;
        double d1 = 150.5;
        double d2 = 150d;
        short s = 11;
        long l = 584;
        char c = 'c';


        // Diferença entre tipos
        Integer int1 = 0;
        int int2 = 0;

        // Tipos não-primitivos possuem funcionalidades
        int1.toString();

        // Tipos primitivos não possuem funcionalidades além de armazenar o valor
        // Linha abaixo não compila
        // int2.toString();
    }
}