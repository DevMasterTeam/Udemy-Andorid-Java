import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue é uma coleção que representa uma estrutura de dados do tipo FIFO (first-in-first-out).
 * Significa que o primeiro item adicionado será o primeiro item a ser removido.
 */
public class Fila {

    private static Queue filaClientes = new LinkedList();

    // Faz a impressão dos items da fila
    private static void imprimeDados() {
        for (Object item : filaClientes) {
            System.out.println(item.toString());
        }
    }

    public static void main(String[] args) {

        // Adiciona items no fim da fila
        filaClientes.add("Elizabeth");
        filaClientes.add("Gabriel");
        filaClientes.add("Tony");
        filaClientes.add("Jéssica");

        System.out.println("Fila completa: ");
        imprimeDados();
        System.out.println();

        // Remove o primeiro item da fila
        filaClientes.poll();
        System.out.println("Fila completa: ");
        imprimeDados();

    }
}