package composicao;

/**
 * Uma composição de classes acontece quando temos uma classe dentro da outra.
 * É uma maneira de delegar responsabilidade.
 * Uma maneira fácil de ler é pensar que uma classe TEM outra.
 */
public class ComposicaoClasses {

    // Objeto de outra classe como atributo
    private Animal animal;

    public static void main(String[] args) {
        ComposicaoClasses composicao = new ComposicaoClasses();
        composicao.animal = new Animal("Pluto");

        // A implementação do falar não está na classe ComposicaoClasses e sim na Animal
        composicao.animal.falar();
    }

    // Exemplos de composição
    // Classe Receita com um array de Ingredientes.
    // Classe Carro com uma classe Motor.
}