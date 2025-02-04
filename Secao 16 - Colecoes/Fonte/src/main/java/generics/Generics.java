package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Generics é a capacidade de parametrizar tipos.
 * Ou seja, criar classes e métodos que funcionam com diferentes tipos de dados.
 * Qualquer classe, interface ou método que opera com tipo parametrizado é chamada de genérica.
 */
public class Generics {

    // Posso receber qualquer tipo de dado e retornar este tipo
    public <T> T save(T entity) {
        return entity;
    }

    public static void main(String[] args) {
        // Lista de inteiros
        List<Integer> listaInteiros = new ArrayList<>();

        // Lista de Strings
        List<String> listaStrings = new ArrayList<>();

        // Lista de Booleans
        List<Boolean> listaBooleans = new ArrayList<>();

        // -------------
        Generics generics = new Generics();
        generics.save(100);
        generics.save("ABC");
        generics.save(false);
        generics.save(new ArrayList<Integer>());
    }
}
