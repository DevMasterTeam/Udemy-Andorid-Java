/**
 * Operadores
 *
 * Soma             ->  +
 * Subtração        ->  -
 * Divisão          -> /
 * Multiplicação    -> *
 * Resto da divisão -> %
 *
 */
public class Operacoes {

    public static void main(String[] args) {

        // Operações matemáticas simples
        System.out.println("2 + 2 = " + (2 + 2));
        System.out.println("2 - 2 = " + (2 - 2));
        System.out.println("2 / 2 = " + (2 / 2));
        System.out.println("2 * 2 = " + (2 * 2));
        System.out.println("10 % 4 = " + (10 % 4));
        System.out.println("10 % 2 = " + (10 % 2));

        int numero = 10;

        // Incremento e decremento - Primeiro faz uso da variável depois aplica a mudança
        System.out.println("numero++ = " + (numero++));
        System.out.println("numero-- = " + (numero--));

        // Aplica a mudança e faz uso da variável
        System.out.println("numero++ = " + (++numero));
        System.out.println("--numero = " + (--numero));

        // Operações simplificadas
        System.out.println("numero = numero + 2 = " + (numero = numero + 2));
        System.out.println("numero += 2 = " + (numero += 2));

        System.out.println("numero = numero - 2 = " + (numero = numero - 2));
        System.out.println("numero -= 2 = " + (numero -= 2));

        System.out.println("numero = numero / 2 = " + (numero = numero / 2));
        System.out.println("numero /= 2 = " + (numero /= 2));

        System.out.println("numero = numero * 2 = " + (numero = numero * 2));
        System.out.println("numero *= 2 = " + (numero *= 2));

        System.out.println("numero = numero % 3 = " + (numero = numero % 3));
        System.out.println("numero %= 3 = " + (numero %= 3));

    }

}
