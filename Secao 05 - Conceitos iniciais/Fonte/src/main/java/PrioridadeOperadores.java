public class PrioridadeOperadores {
    public static void main(String[] args) {
        // Atenção a ordem que os operadores são avaliados
        int result = 2 + 3 * 4;
        System.out.println(result);

        result = (2 + 3) * 4;
        System.out.println(result);

        // Ordem de prioridade
        // * / %
        // + -
    }
}