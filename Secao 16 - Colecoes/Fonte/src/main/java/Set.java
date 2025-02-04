import java.util.HashSet;

/**
 * A coleção Set não permite elementos duplicados, o que é uma característica muito útil.
 * Caso dois valores iguais sejam adicionados no Set, somente um deles será usado e não acontecerá erro.
 */
public class Set {
    public static void main(String[] args) {

        java.util.Set<String> set = new HashSet<>();

        set.add("A");
        set.add("A");
        set.add("B");

        for (String s : set) {
            System.out.println(s);
        }

        // Remove um valor
        set.remove("A");

        // Verifica se existe
        set.contains("B");

        // Limpa a coleção
        set.clear();

        // Tamanho
        set.size();
    }
}