package interfaces;

public class Auxiliar {
    public static void main(String[] args) {

        // Polimorfismo com Interface
        Maquina m1 = new Furadeira();
        Maquina m2 = new Liquidificador();

        m1.ligar();
        m2.ligar();

    }
}
