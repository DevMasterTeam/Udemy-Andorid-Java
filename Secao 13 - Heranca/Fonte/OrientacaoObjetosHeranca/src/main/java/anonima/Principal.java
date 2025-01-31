package anonima;

/**
 * Classe anônima é uma classe criada dentro de um método que pode ser passada como parâmetro.
 * Nesse caso, não houve a necessidade de se criar uma classe para então implementar a interface.
 * --
 * É como se criássemos uma classe sem nome, mas que implementa a interface.
 * --
 * Classes anônimas são muito poderosas, pois permitem que o código de uma classe seja invocado
 * a qualquer momento a partir de outra classe.
 */
public class Principal {

    public void salvar(Listener listener, int id) {
        listener.click(id);
    }

    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.salvar(new Listener() {
            @Override
            public void click(int id) {
                System.out.println("Fui clicado!");
            }
        }, 10);
    }

}