package enumerador;

/**
 * Classe feita para ajudar a demonstrar as funcionalidades de outras classes.
 */
public class Auxiliar {
    public static void main(String[] args) {

        // Não existe instância de enumerador
        // Medidas medidas = new Medidas();

        System.out.println(Medidas.KG);
        System.out.println(Medidas.GRAMA);
        System.out.println(Medidas.TONELADA);

        System.out.println(Prioridade.BAIXA.getId());
        System.out.println(Prioridade.MEDIA.getId());
        System.out.println(Prioridade.ALTA.getId());

    }
}