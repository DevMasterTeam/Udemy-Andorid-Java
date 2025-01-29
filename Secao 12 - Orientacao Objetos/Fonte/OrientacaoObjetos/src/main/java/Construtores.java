/**
 * Um construtor é um método chamado no momento que uma classe é instanciada.
 * É muito comum que no construtor haja a atribuição de valores para os atributos da classe.
 * --
 * Mesmo que uma classe não possua construtor explícitamente declarado, existe ainda um construtor
 * padrão (default) que permite que a classe seja instanciada.
 * --
 * É possível que uma classe tenha mais do que um construtor.
 * Em muitos casos, é normal que ao instaciar uma classe, nem todos os valores do construtor estejam presentes.
 * Por isso, existe mais de um construtor.
 * --
 * Para que uma classe seja instanciável, o contrutor deve estar acessível.
 * Se por algum motivo o construtor for declarado como privado, a classe não poderá ser instanciada.
 * --
 * Um construtor pode chamar o outro se fizer sentido na implementação.
 */
public class Construtores {

    // Construtor privado. Classe não pode ser instanciada;
    // private Construtores() { }

    // Construtor explícitamente declarado
    public Construtores() {
        System.out.println("Classe instanciada!");
    }

    // Mais um construtor
    public Construtores(String str) {
        this();
    }

    // Mais um construtor
    public Construtores(String str, int valor) {
        this(str);
    }

    public static void main(String[] args) {
        // Instância da classe usando os três construtores disponíveis
        Construtores c1 = new Construtores();
        Construtores c2 = new Construtores("Construtor");
        Construtores c3 = new Construtores("Construtor", 100);

        // Exemplo real - Exception é uma classe que pode ser instanciada sem nenhum valor
        // new Exception();

        // Ou com uma mensagem
        // new Exception("Mensagem");
    }
}