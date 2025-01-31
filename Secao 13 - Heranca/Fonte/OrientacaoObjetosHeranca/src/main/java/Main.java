/**
 * Os modificadores de visibilidade:
 * public, private, protected
 * --
 * Vale a pena destacar que não são aplicadas apenas à classes, mas também métodos e atribuos.
 * Também é válido para construtores, uma vez que também são métodos.
 * --
 * public
 * Uma classe, método ou atributo public é acessível pela classe, pacote e classes externas ao pacote.
 * --
 * private
 * Uma classe, método ou atributo private é acessível somente pela classe.
 * A classe principal não pode receber private ou protected ou o Java vai gerar um erro.
 * A classe principal pode ter o modificador public ou ser deixado sem modificar algum.
 * Se deixado sem nenhum modificador, se diz default e se torna visível para as classes do mesmo pacote.
 * --
 * protected
 * Uma classe, método ou atributo private é acessível pelas classe no mesmo pacote.
 * --
 * Sem modificador específico
 * Segue a mesma regra de protected.
 */
public class Main {
    public static void main(String[] args) {

        Iluminado iluminado = new Iluminado();
        iluminado.getNome();

        // Não está visível
        // luminado.name

        // Protected - Acessível dentro do pacote somente
        System.out.println(iluminado.massa);

    }

    public void hello() {
        System.out.println("Hello.");
    }

    public void hello(String name) {
        System.out.println("Hello." + name);
    }

    public void hello(int n) {
        System.out.println("Hello número: " + n);
    }

    public void hello(String name, int n) {
        System.out.println("Hello " + name + "número: " + n);
    }

}
