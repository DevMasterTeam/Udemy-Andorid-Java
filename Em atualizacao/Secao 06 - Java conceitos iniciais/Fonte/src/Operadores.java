public class Operadores {
    public static void main(String[] args) {

        // Operações matemáticas simples
        System.out.println("2 + 2 = " + (2 + 2));
        System.out.println("2 - 2 = " + (2 - 2));
        System.out.println("2 / 2 = " + (2 / 2));
        System.out.println("2 * 2 = " + (2 * 2));
        System.out.println("10 % 4 = " + (10 % 4));
        System.out.println("10 % 2 = " + (10 % 2));

        // Usando variáveis
        int numero = 100;
        System.out.println(numero + 10);
        System.out.println((numero * 1.1) + 50);

        // Operações simplificadas
        // Somar duas unidades a um valor
        numero = numero + 2;
        numero += 2;

        // Subtrair
        numero = numero - 2;
        numero -= 2;

        // Divisão
        numero = numero / 2;
        numero /= 2;

        // Multiplicação
        numero = numero * 2;
        numero *= 2;

        // Atribuir o resto da divisão
        numero = numero % 3;
        numero %= 3;
    }
}