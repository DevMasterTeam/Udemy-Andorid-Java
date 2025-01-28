public class Multidimensional {

    /**
     * Calcula e exibe a média de todos os valores armazenados em uma matriz de números reais (float).
     */
    private void media() {
        float[][] matriz = {{8.8f, 9, 7.6f, 4}, {8.9f, 9.7f, 9.4f, 8.9f}, {10, 10, 9, 9}, {4.7f, 9.9f, 9.2f, 8.9f}};

        float sum = 0;
        float count = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                sum += matriz[i][j];
                count++;
            }
        }

        System.out.println("Média: " + (sum / count));
    }

    /**
     * Imprime uma matriz de char
     */
    private void print(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Imprime uma matriz de int
     */
    private void print(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Multidimensional multi = new Multidimensional();

        int[][] m1 = new int[4][4];
        int count = 1;
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                m1[i][j] = count;
                count++;
            }
        }
        multi.print(m1);

        char[][] m2 = new char[4][4];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                if (i == j)
                    m2[i][j] = 'x';
                else
                    m2[i][j] = '-';
            }
        }
        multi.print(m2);

        char[][] m3 = new char[4][4];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                if (i >= j)
                    m3[i][j] = 'x';
                else
                    m3[i][j] = '-';
            }
        }
        multi.print(m3);

        char[][] m4 = new char[4][4];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                if (i <= j)
                    m4[i][j] = 'x';
                else
                    m4[i][j] = '-';
            }
        }
        multi.print(m4);

    }
}