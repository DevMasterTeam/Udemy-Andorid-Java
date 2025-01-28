public class Multidimensional {
    public static void main(String[] args) {

        int[][] matriz = {{1, 8, 2, 5}, {2, 5, 1,1}, {3, 9, 9, 5}};

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}