package polimorfismo;

public class Main {

    public static void main(String[] args) {

        // Polimorfismo é o conceito de que uma classe pode assumir várias "formas"
        // No nosso caso, funcionário pode tanto ser um gerente como um analista.
        // Isso permite que o tipo da variável possa ser definido como Funcionario
        // independente se temos um gerente ou analista.
        Funcionario f1 = new Gerente("Roberta", 9220f);
        Funcionario f2 = new Analista("Júlio", 5400f);

        System.out.println(f1.bonus());
        System.out.println(f2.bonus());
    }
}
