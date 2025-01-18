public class Ex3 {
    public static void main(String[] args) {
        // Declarar dois números para as operações
        int numero1 = 20;
        int numero2 = 5;

        // Soma de dois números
        int soma = numero1 + numero2;
        System.out.println("Soma de " + numero1 + " e " + numero2 + ": " + soma);

        // Divisão de dois números
        int divisao = numero1 / numero2;
        System.out.println("Divisão de " + numero1 + " por " + numero2 + ": " + divisao);

        // Resto da divisão de dois números
        int resto = numero1 % numero2;
        System.out.println("Resto da divisão de " + numero1 + " por " + numero2 + ": " + resto);

        // Incremento e decremento de uma variável
        int variavel = 10;

        // Pré-incremento
        System.out.println("Pré-incremento: " + (++variavel));

        // Pós-incremento
        System.out.println("Pós-incremento: " + (variavel++) + " (valor após: " + variavel + ")");

        // Pré-decremento
        System.out.println("Pré-decremento: " + (--variavel));

        // Pós-decremento
        System.out.println("Pós-decremento: " + (variavel--) + " (valor após: " + variavel + ")");
    }
}
