public class FluxoParte2 {

    // Possibliade do controle de fluxo aninhado, ou seja, um dentro do outro.
    private void bonusFuncionario(int anosEmpresa) {
        if (anosEmpresa == 0) {
            System.out.println("Bônus padrão: R$200,00");
        } else {
            if (anosEmpresa == 1) {
                System.out.println("Bônus: R$400,00");
            } else {
                System.out.println("Bônus: R$1000,00");
            }
        }

        // Uso de else if
        if (anosEmpresa == 0) {
            System.out.println("Bônus padrão: R$200,00");
        } else if (anosEmpresa == 1) {
            System.out.println("Bônus: R$400,00");
        } else {
            System.out.println("Bônus: R$1000,00");
        }
    }

    public static void main(String[] args) {
        FluxoParte2 fluxo = new FluxoParte2();

        fluxo.bonusFuncionario(0);
        fluxo.bonusFuncionario(1);
        fluxo.bonusFuncionario(2);
    }
}