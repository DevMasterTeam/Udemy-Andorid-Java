package polimorfismo;

public class Funcionario {

    public String nome;
    public float salario;

    public Funcionario(String nome, float salario) {
        this.nome = nome;
        this.salario = salario;
    }

    // Funcionários possuem bônus
    public float bonus() {
        return this.salario * 0.5f;
    }

}
