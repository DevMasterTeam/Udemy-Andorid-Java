package composicao;

public class Animal {
    private String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void falar() {
        System.out.println("Meu nome é " + getNome());
    }

}
