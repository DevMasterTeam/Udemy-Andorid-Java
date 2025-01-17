/**
 * do while é um laço de repetição executado enquanto a condição é verdadeira.
 * Extremamente parecido com 'while', porém o corpo do 'do while' é executado sempre no mínimo uma vez.
 * Já que não existe condição para que entre no corpo, a condição só acontece no final.
 */
public class FluxoDoWhile {
    public static void main(String[] args) {

        int indice = 1;
        do {
            System.out.print("indiceDoWhile: " + indice + " ");
            indice++;
        } while (indice < 10);

    }
}
