import java.util.HashMap;

/**
 * Mapa são listas de dados entrada-valor. Significa que para uma chave, existe um valor associado.
 * Assim como Set, map também não permite elementos duplicados nas chaves.
 */
public class Map {
    public static void main(String[] args) {

        java.util.Map<String, String> map = new HashMap<>();

        // Adição de valores - Não permite valores repetidos
        // Nesse caso, o último valor adicionado associada a chave será mantifo.
        map.put("França", "Parissss");
        map.put("França", "Paris");
        map.put("Alemanha", "Berlim");

        // Imprime as chaves
        System.out.println(map.keySet());

        // Imprime os valores
        System.out.println(map.values());

        // Remoção
        map.remove("França");

        // Verifica se existe
        map.containsKey("Alemanha");

        // Imprime o valor associado a chave
        System.out.println(map.get("Alemanha"));

        // Limpa coleção
        map.clear();

        // Tamanho do map
        map.size();
    }
}
