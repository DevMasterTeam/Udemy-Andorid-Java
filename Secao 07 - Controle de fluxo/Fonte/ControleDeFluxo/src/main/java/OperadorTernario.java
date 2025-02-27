/**
 * Operador ternário nada mais é do que uma simplificação do if/else
 * (expressão) ? instrução caso expressão seja verdadeira : instrução caso expressão seja falsa
 * Exemplo: (10 == 10) ? true : false
 */
public class OperadorTernario {

    // Operador ternário
    private String maiorDeIdadeTernario(int idade) {
        return idade >= 18 ? "Maior de idade" : "Menor de idade";
    }

    public static void main(String[] args) {
        OperadorTernario ternario = new OperadorTernario();

        System.out.println(ternario.maiorDeIdadeTernario(15));
        System.out.println(ternario.maiorDeIdadeTernario(25));
    }
}