public class Unidimensional {

    // Usado para armazenar valores já calculados
    long[] cacheFatorial = new long[11];

    /**
     * Encontra a string mais longa em um array de nomes e exibe o índice onde ela está localizada.
     */
    private void maiorString() {
        String[] nomes = {"Natasha Alianovna Romanoff", "Stephen Vincent Strange", "Anthony Edward Stark"};

        int index = -1;
        int maxLength = -1;
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i].length() > maxLength) {
                maxLength = nomes[i].length();
                index = i;
            }
        }

        System.out.println("Mais String está no índice: " + index);
    }

    /**
     * Calcula a média aritmética de um array de números reais (float).
     */
    private float average(float[] values) {
        if (values == null || values.length == 0) {
            return 0;
        }

        float sum = 0;
        for (float v : values) {
            sum += v;
        }
        return (sum / values.length);
    }

    /**
     * Calcula o fatorial de um número inteiro positivo utilizando um cache para armazenar resultados já calculados.
     * --
     * O fatorial de um número n (representado por n!) é definido como o produto de todos os números inteiros de 1 até n.
     * Por exemplo, 5! = 5 * 4 * 3 * 2 * 1 = 120.
     * --
     * Uso um vetor de cache (`cacheFatorial`) para armazenar os resultados de cálculos prévios,
     * melhorando o desempenho ao evitar recalcular fatoriais já computados.
     */
    private long fatorial(int n) {
        int number = n;

        if (n == 0 || n == 1) {
            return 1;
        }

        if (cacheFatorial[n] != 0) {
            return cacheFatorial[n];
        }

        long resultado = 1;
        while (n > 1) {
            resultado *= n;
            n--;
        }

        cacheFatorial[number] = resultado;
        return resultado;
    }

    public static void main(String[] args) {
        Unidimensional uni = new Unidimensional();

        // Exercício 1
        uni.maiorString();

        // Exercício 2
        float[] valores = {14f, 5.3f, 63.5f, 34f, 15f};
        System.out.println("Média: " + uni.average(valores));

        float[] valores2 = {};
        System.out.println("Média: " + uni.average(valores2));
        System.out.println("Média: " + uni.average(null));

        // Desafio
        System.out.println(uni.fatorial(8));
        System.out.println(uni.fatorial(8));
        System.out.println(uni.fatorial(8));
    }
}