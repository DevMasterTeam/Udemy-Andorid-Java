public class Luminoso extends Astro {

    private float luz;

    public void nome() {
        // Palavra super se refere a classe superior
        System.out.println("Nome astro Luminoso: " + super.getNome());
    }

    @Override
    public void orbita() {
        System.out.println("Planetas orbitam ao meu redor.");
    }
}
