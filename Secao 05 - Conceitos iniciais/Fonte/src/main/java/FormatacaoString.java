import java.util.Locale;

public class FormatacaoString {
    public static void main(String[] args) {

        // Concatenação de Strings
        String nome = "John";
        System.out.println("Ola, " + nome);

        // No entanto, é possível utilizar formatação de String para evitar concatenação.
        String saudacao = String.format("Ola, %s", nome);
        System.out.println(saudacao);

        // Tipos de dados e especificadores
        // %s - String
        // %d - Integer
        // %f - Ponto flutuante
        // %c - Character
        // %b - Boolean

        int valor = 5;
        float salario = 8451.54F;

        String valorESalario = String.format("Valor eh de %d e salario eh de %f", valor, salario);
        System.out.println(valorESalario);
        System.out.println();

        // Formatando números corretamente
        valorESalario = String.format("Valor eh de %02d e salario eh de %.2f", valor, salario);
        System.out.println(valorESalario);
        System.out.println();

        // A localização pode ser utlizada - Casas decimais com "." ao invés de ","
        // Localização - Diferentes países / regiões
        valorESalario = String.format(Locale.CANADA, "Valor eh de %02d e salario eh de %.2f", valor, salario);
        System.out.println(valorESalario);

    }
}