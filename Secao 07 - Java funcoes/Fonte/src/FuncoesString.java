public class FuncoesString {
    public static void main(String[] args) {

        String str = "Programação Java!";

        // Tamanho de uma String
        System.out.println("Tamanho: " + str.length() + " caracteres.");

        // Obtém uma posição
        System.out.println("Primeira letra: " + str.charAt(0));

        // Faz a comparação de duas Strings
        System.out.println(str.equals("programação")); // false
        System.out.println(str.equals(str)); // true

        // Verifica se a String começa com o parâmetro informado
        System.out.println(str.startsWith("Programação"));

        // Verifica se a String termina com o parâmetro informado
        System.out.println(str.endsWith("!"));

        // Obtém parte de uma String - Começa na posição 5 até o final
        System.out.println(str.substring(6));

        // Obtém parte de uma String - Intervalo definido (começo e fim)
        System.out.println(str.substring(6, 8));

        // Substitui todas as ocorrências dentro de uma String por outra
        System.out.println(str.replace("Java!", "Java muito legal!"));

        // Converte toda a string para maiúsculas
        System.out.println(str.toUpperCase());

        // Converte toda a string para minúsculas
        System.out.println(str.toLowerCase());

        // Elimina espaços em branco no começo e fim
        System.out.println("     Minha string com espaços em branco       ".trim());
    }
}