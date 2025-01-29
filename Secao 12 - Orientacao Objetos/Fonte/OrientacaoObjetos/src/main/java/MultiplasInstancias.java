public class MultiplasInstancias {
    private int valor;

    public static void main(String[] args) {

        // Criação de uma instância
        MultiplasInstancias m1 = new MultiplasInstancias();
        m1.valor = 100;

        // Aqui não ocorre a instância de uma classe, mas sim referência a um objeto já existente
        MultiplasInstancias m2 = m1;

        // Ao fazer a ação abaixo o valor referenciado é atualizado,
        // ou seja, o valor referente a instância m1
        m2.valor = 200;

        System.out.println("M1: " + m1.valor);
        System.out.println("M2: " + m2.valor);

        // --
        MultiplasInstancias c1 = new MultiplasInstancias();
        c1.valor = 50;

        MultiplasInstancias c2 = new MultiplasInstancias();
        c2.valor = 50;

        // Outro erro muito comum é pensar que uma vez que os valores de dois objetos são iguais,
        // os objetos também são iguais.
        // Porém, são objetos diferentes com atributos com o mesmo valor.
        System.out.println(c1 == c2);
    }
}