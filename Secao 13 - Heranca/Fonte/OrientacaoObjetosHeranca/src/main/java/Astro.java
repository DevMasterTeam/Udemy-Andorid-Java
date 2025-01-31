/**
 * Herança é uma funcionalidade em orientação a objetos que permite fazer a especialização de classes.
 * Se uma classe X que herda a classe Y, podemos dizer que X extende Y
 * Podemos dizer que X é uma especialização de Y.
 * --
 * As classes especializadas compartilham atributos e métodos da classe herdada.
 * As classes especializadas podem ter atributos e métodos específicos declarados dentro delas.
 * --
 * Quando se fala em herança, é comum descrever a relação como pai/mãe e filho/filha.
 *--
 * Classes com visibilidade padrão (sem `public`) podem ser herdadas dentro do mesmo pacote.
 * Para permitir herança entre pacotes diferentes, a classe precisa ser `public`.
 * --
 * No Java não existe herança múltipla, ou seja, só é possível herdar de uma classe, nunca mais de uma.
 */
public class Astro {

    private String nome;

    protected double massa;

    // Palavra final faz com que não seja possível ser feito override.
    public final String getNome() {
        return nome;
    }

    public void orbita() {
        System.out.println("Astro pode orbitar ou ser orbitado.");
    }
}
