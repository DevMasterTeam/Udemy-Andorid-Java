package lambda;

/**
 * Lambda surgiu com o Java 8 como maneira de escrever código mais limpo.
 * --
 * Sintáxe do lambda
 * (parâmetros) -> expressão
 * --
 * Um lambda só pode ser escrito se a classe anônima possui um único método.
 * Conceito de SAM (Single Abstract Method) - Interfaces que definem um único método abstrato
*/
public class Main {

    public void salvar(Listener listener, int id) {
        listener.click(id);
    }

    public static void main(String[] args) {
        Main principal = new Main();

        // Classe anônima simplificada
        principal.salvar(id -> System.out.println("Fui clicado!"), 10);
    }
}