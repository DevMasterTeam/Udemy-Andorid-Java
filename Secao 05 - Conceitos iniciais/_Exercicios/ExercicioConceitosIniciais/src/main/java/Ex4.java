public class Ex4 {
    public static void main(String[] args) {
        // String de exemplo
        String texto = "Aprender Java é divertido!";

        // Converter a String para maiúscula
        String textoMaiusculo = texto.toUpperCase();
        System.out.println("Texto em maiúsculas: " + textoMaiusculo);

        // Converter a String para minúscula
        String textoMinusculo = texto.toLowerCase();
        System.out.println("Texto em minúsculas: " + textoMinusculo);

        // Encontrar o tamanho da String
        int tamanho = texto.length();
        System.out.println("Tamanho do texto: " + tamanho);

        // Verificar se a String possui a palavra "Java"
        boolean contemJava = texto.contains("Java");
        System.out.println("Contém a palavra 'Java' " + contemJava);
    }
}