package estatico;

/**
 * Atributos e métodos estáticos deixam de ser referenciados através da instância da classe
 * e são referenciados diretamente da definição da classe.
 * São escopos da CLASSE e não da instância.
 * --
 * Um atributo estático está disponível em uma classe de forma única para toda a aplicação.
 * Ele não está vinculado a uma instância da classe. Ele pertence a classe em si.
 * --
 * Os métodos static podem ser chamados sem uma instância. São ótimos como utilitários.
 * Métodos estáticos não podem acessar variáveis de instância.
 */
public class Estatico {

    // Variável não estática, só será acessada quando a classe for instanciada
    public int id;
    static int varEstatica = 10;

    public Estatico() {
        varEstatica++;
    }

    static String ola() {

        // Métodos estáticos não tem acesso as variáveis e métodos não estáticos
        // Não existe this em métodos estáticos
        // System.out.println(id);
        // System.out.println(this.id);

        return "Olá";
    }

}