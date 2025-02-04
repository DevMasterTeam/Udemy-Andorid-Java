import java.util.Stack;

/**
 * Stack é uma coleção que representa uma estrutura de dados do tipo LIFO (last-in-first-out).
 * Significa que o último item adicionado será o primeiro item a ser removido.
 */
public class Pilha {

    /**
     * Exibe todos os elementos de uma pilha na ordem em que estão armazenados.
     */
    public static void printStack(Stack<String> stack) {
        for (String prato : stack) {
            System.out.println(prato);
        }
    }

    public static void main(String[] args) {

        Stack<String> pilhaPratos = new Stack<>();

        pilhaPratos.push("Prato 1");
        pilhaPratos.push("Prato 2");
        pilhaPratos.push("Prato 3");
        pilhaPratos.push("Prato 4");

        System.out.println("Pilha completa: ");
        printStack(pilhaPratos);

        // Remove um item
        pilhaPratos.pop();

        System.out.println("Pilha completa: ");
        printStack(pilhaPratos);

        // Possível ver qual o elemento que está no topo da pilha
        System.out.println(pilhaPratos.peek());

        // Possível limpar todos os items da pilha
        pilhaPratos.clear();

        // Métodos add & remove
        // Ainda é possível utilizar os métodos add e remove, uma vez que Stack implementa a interface List
        // Porém, ao fazer isso e manipular os indexes manualmente não se respeita mais o funcionamento de um pilha.

    }
}