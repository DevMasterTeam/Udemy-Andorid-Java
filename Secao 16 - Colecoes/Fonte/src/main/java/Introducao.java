import java.util.ArrayList;
import java.util.List;

/**
 * Coleções em Java são classes e interfaces criadas para auxiliar na manipulação de um conjuneto de elementos.
 * Coleções trazem métodos úteis para manipulação dos dados.
 */
public class Introducao {

    /**
     * Impressão dos valores presentes em uma Lista.
     */
    private static void printArray(ArrayList array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
    }

    /**
     * Recebe um ArrayList sem saber qual o tipo de informação que existe dentro.
     * Assim, é necessário tratar o tipo de informação de cada elemento.
     * */
    private static void handleObject(ArrayList array) {
        for (Object o : array) {
            if (o instanceof Integer) {
                System.out.println("Tipo inteiro!");
            } else if (o instanceof String) {
                System.out.println("Tipo String!");
            } else if (o instanceof Double) {
                System.out.println("Tipo Double!");
            } // ..... e assim por diante
        }

        for (Object o : array) {
            if (o.getClass().getSimpleName().equals("Integer")) {
                System.out.println("Tipo Integer!");
            } else if (o.getClass().getSimpleName().equals("String")) {
                System.out.println("Tipo String!");
            }
        }
    }

    public static void main(String[] args) {

        // Declaração de array
        // Quais são as limitações? Tamanho é fixo em 10.
        // Inclusão e remoção fazem uso do index. Não existe método para limpar o array.
        // Não existe método para verificar se existe um valor no array.
        String[] stringArray = new String[10];

        // Declaração de um ArrayList - Um tipo de coleção
        // Não há a necessidade de declarar o tamanho. Seu tamanho é alocado conforme necessidade.
        // Essa declaração não deixa explícito qual o tipo de informação que existe nos elements.
        ArrayList nomes = new ArrayList();

        // Método auxiliar para adicionar um item
        nomes.add("Tony");
        nomes.add("Steve");
        nomes.add("Natascha");
        nomes.add("Bruce");

        // Quantidade de elementos
        nomes.size();

        // Mostra todos os elementos
        printArray(nomes);

        // Remover passando o valor ou index
        nomes.remove("Tony");
        // nomes.remove(0);

        // Verfifica se a lista está vazia - true/false
        nomes.isEmpty();

        // Verifica se contém o elemento - true/false
        nomes.contains("Natascha");

        System.out.println();
        System.out.println("Bruce está na posição: " + nomes.indexOf("Bruce"));

        // Remove todos os items do array
        nomes.clear();

        // ---------------------------
        // Uma lista que define qual tipo de informação será aceita.
        List<Integer> listInteger = new ArrayList<>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
    }
}