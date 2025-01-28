import java.util.Scanner;

/**
 * Classe que simula a reserva de lugares em um cinema.
 * O cinema possui uma matriz de lugares representada por uma matriz de 5 fileiras por 8 colunas.
 * Os lugares disponíveis são representados por '-' e os ocupados por 'x'.
 */
public class Cinema {

    // Matriz que representa os lugares do cinema
    char[][] places = new char[5][8];

    /**
     * Exibe a matriz de lugares, mostrando os disponíveis e ocupados.
     */
    private void print() {
        for (int i = 0; i < places.length; i++) {
            for (int j = 0; j < places[i].length; j++) {
                System.out.print(places[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Inicializa a matriz de lugares, marcando todos como disponíveis ('-').
     */
    private void init() {
        for (int i = 0; i < places.length; i++) {
            for (int j = 0; j < places[i].length; j++) {
                places[i][j] = '-';
            }
        }
    }

    /**
     * Efetua a reserva da posição caso esteja disponível.
     */
    private void reservation(int row, int col) {
        if (places[row][col] == '-') {
            places[row][col] = 'x';
            System.out.println("Reservado! Fileira: " + (row + 1) + ". Coluna: " + (col + 1) + ".");
        } else {
            System.out.println("Lugar não disponível.");
        }
    }

    /**
     * Obtém a posição da fileira ou coluna para reserva, validando a entrada do usuário.
     */
    private int getPositionForReservation(int maxValue, boolean isLine) {
        Scanner scanner = new Scanner(System.in);
        String text = isLine ? "linha" : "coluna";

        int position = -1;
        do {
            System.out.print("Digite a " + text + " (1-" + (maxValue + 1) + "): ");
            try {
                position = scanner.nextInt() - 1;

                if (position < 0 || position > 4) {
                    position = -1;
                    System.out.println("Entrada inválida. Intervalo de 1 a " + (maxValue + 1) + ".");
                    scanner.nextLine();
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida.");
                position = -1;
                scanner.nextLine();
            }
        } while (position == -1);

        return position;
    }

    /**
     * Função principal que executa o sistema de reservas do cinema.
     * Inicializa os lugares e permite que o usuário reserve enquanto desejar.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cinema cinema = new Cinema();
        cinema.init();

        String controlExit;
        System.out.println("Bem-vinda(o) ao cinema.");

        do {
            System.out.println("Disponíveis (-). Ocupados (x)");
            cinema.print();

            // Lógica para fileira e coluna
            int row = cinema.getPositionForReservation(4, true);
            int column = cinema.getPositionForReservation(7, false);

            // Logica para reserva
            cinema.reservation(row, column);

            System.out.print("Deseja continuar (s/n)? ");
            controlExit = scanner.nextLine().toLowerCase();
        } while (controlExit.equals("s"));
    }
}