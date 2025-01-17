public class Investimento {
    public static void main(String[] args) {

        float salario = 10000f;

        float patAna = 0f;
        float patPaula = 0f;
        int mes = 1;

        do {
            patAna += (salario * 0.05) + (salario * 0.05) + (patAna * 0.002);
            patPaula += (salario * 0.05) + (patPaula * 0.008);
            mes++;
        } while (patAna > patPaula);

        System.out.println("Paula vai ultrapassar o patrimônio de Ana no mês " + mes + ".");
    }
}