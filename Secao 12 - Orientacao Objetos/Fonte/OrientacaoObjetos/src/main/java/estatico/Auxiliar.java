package estatico;

public class Auxiliar {
    public static void main(String[] args) {

        // Acesso a variável estática sem instância da classe
        System.out.println(Estatico.varEstatica);

        // Acesso a método estático sem instância da classe
        System.out.println(Estatico.ola());

        // ------------------
        // Classe instanciada
        new Estatico();
        new Estatico();
        new Estatico();

        // ------------------
        // Variáveis e métodos estáticos são ótimo como utilitários.
        // Não há necessidade de instanciar a classe para acessá-los
        // Por exemplo, constantes

        // Número de Euler
        System.out.println(Math.E);

        // Valor de PI
        System.out.println(Math.PI);

        // Métodos
        System.out.println("Maior número entre E e PI: " + Math.max(Math.E, Math.PI));

    }
}