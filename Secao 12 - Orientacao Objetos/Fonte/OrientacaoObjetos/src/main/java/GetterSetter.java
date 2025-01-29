/**
 * É uma boa prática não permitir acesso a atributos diretamente.
 * Sempre que o acesso a uma variável é necessária, deve-se criar métodos Getter e Setter.
 * Este é o conceito de Encapsulamento / data hiding / information hiding
 * --
 * É possível implementar lógica dentro do getter ou setter, caso necessário.
 * --
 * Getter é responsável por devolver o valor da variável.
 * Setter é responsável por atribuir o valor a variável.
 */
public class GetterSetter {

    // Atributos privados
    private String nome;
    private int idade;

    // Getter - Público para obter o valor da variável
    public String getNome() {
        return nome;
    }

    // Setter - Público para atribuir o valor da variável
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Só é possível obter o valor da idade, não é possível atribuir
    public int getIdade() {
        return idade;
    }

}