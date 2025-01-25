/**
 * While é um laço de repetição executado enquanto a condição é verdadeira.
 */
public class FluxoWhile {
    public static void main(String[] args) {

        int indice = 1;
        while (indice < 10) {

            if (indice == 5) {
                indice++;
                continue;
            }

            System.out.print("indice: " + indice + " ");
            indice++;
        }
    }
}