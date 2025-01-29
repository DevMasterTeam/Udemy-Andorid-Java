package enumerador;

/**
 * Enumerador com valores associados as constantes.
 */
public enum Prioridade {
    BAIXA(1), MEDIA(5), ALTA(10);

    private int id;

    Prioridade(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}