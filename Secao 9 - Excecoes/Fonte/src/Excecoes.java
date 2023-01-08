import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Exceção é um comportamente não esperado no código.
 * Caso uma exceção não tratada ocorra, ocasiona o fechamento da aplicação.
 * --
 * try-catch é uma maneira de tratar problemas esperados e principalmente não esperados.
 * finally é uma instrução opcional, pode existir try-catch sem finally.
 * finally, diferente do catch, é SEMPRE executado. Catch só é executado quando existe exceção.
 */
public class Excecoes {

    /**
     * Quando existe mais de um tipo de exceção sendo capturada,
     * a Exception mais genérica deve sempre vir por último.
     * No caso, trata-se a exceção de formato de número para depois tratar a exceção genérica.
     */
    private void scanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Por favor, informe um número: ");

        try {
            int inteiro = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Número inválido.");
        } catch (Exception e) {
            System.out.println("Erro inesperado.");
        }
    }

    /**
     * Função simulando um código que não temos acesso para modificações
     * Somente temos que lidar com o tipo de retorno.
     */
    private String geraNomeUsuario(String nome) {
        return null;
    }

    /**
     * Método que caso ocorra uma exceção, lança para quem está chamando
     * Isso pode ocorrer quando a função não sabe como prosseguir com a informação recebida.
     */
    private float divisao(float n1, float n2) throws Exception {
        if (n2 == 0)
            throw new Exception("Não exite divisão por zero.");

        return n1 / n2;
    }

    public static void main(String[] args) {
        Excecoes excecoes = new Excecoes();

        // NullPointerException - Uma das exeções mais comuns no Java
        // Significa que os atributos ou métodos de uma variável nunca instaciada estão sendo acessados.
        String str = excecoes.geraNomeUsuario("Jo");
        System.out.println(str.length());

        // Toda função que lança uma exceção deve obrigatoriamente tratar
        try {
            float resultado = excecoes.divisao(1, 0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}