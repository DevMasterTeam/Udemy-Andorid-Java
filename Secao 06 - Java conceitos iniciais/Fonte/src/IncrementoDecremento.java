public class IncrementoDecremento {
    public static void main(String[] args) {
        int numero = 200;

        // Incremento e decremento - Primeiro faz uso da variável depois aplica a mudança
        System.out.println("numero++ = " + (numero++));
        System.out.println("numero-- = " + (numero--));

        // Aplica a mudança e faz uso da variável
        System.out.println("++numero = " + (++numero));
        System.out.println("--numero = " + (--numero));
    }
}
