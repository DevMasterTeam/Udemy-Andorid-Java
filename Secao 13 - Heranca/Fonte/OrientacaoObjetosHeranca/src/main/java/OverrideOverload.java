/**
 * Overload (sobrecarga) é o conceito de definir múltiplos métodos com o mesmo nome em uma classe,
 * mas com assinaturas diferentes (tipos ou quantidade de parâmetros).
 * --
 * Override (sobrescrita) é o conceito de redefinir um método de uma superclasse em uma subclasse,
 * mantendo a mesma assinatura, mas alterando seu comportamento.
 */
public class OverrideOverload extends Astro {

    public void overload() {
    }

    public void overload(String str) {
    }

    public void overload(int i) {
    }

    /**
     * Método sobrescrito (Override): Substitui a implementação da classe base.
     * Usa a anotação @Override para indicar que está sobrescrevendo um método da superclasse.
     */
    @Override
    public void orbita() {
        super.orbita();
    }
}