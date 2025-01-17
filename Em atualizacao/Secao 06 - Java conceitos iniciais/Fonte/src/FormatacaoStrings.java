public class FormatacaoStrings {
    public static void main(String[] args) {

        // Simples concatenação
        System.out.println("Concatenção de " + " strings.");

        // Qualquer informação concatenada a uma string se torna uma string.
        System.out.println("Número: " + 2);
        System.out.println("Número: " + 2.535);
        System.out.println("Número: " + false);

        // Concatenação de várias linhas
        System.out.println("Várias" +
                "e várias " +
                " linhas.");

        // Caractéres 'escape'
        System.out.println("Pular uma \n linha");
        System.out.println("Tab no \t texto");
        System.out.println("Aspas sem interromper a string \"");
        System.out.println("Barra sem interromper a string \\");
    }
}