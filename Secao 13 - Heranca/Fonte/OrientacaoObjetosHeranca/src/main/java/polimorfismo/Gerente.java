package polimorfismo;

public class Gerente extends Funcionario {

    public boolean metasCumpridas;

    public Gerente(String nome, float salario) {
        super(nome, salario);
    }

    @Override
    public float bonus() {
        if (metasCumpridas) {
            return this.salario;
        } else {
            return super.bonus();
        }
    }
}