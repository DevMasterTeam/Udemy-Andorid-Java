public class FluxoIfElseOperadores {

    // Abaixo, ideia proposta para resolução.
    /*
     * Cálculo de bonus de funcionario baseado em tempo de empresa
     * Menos de um ano  -> 500
     * 1 a 3 anos       -> 2000
     * 4 anos ou mais   -> 5000
     *
     * Posteriormente, mudança efetuada para considerar o bônus do Diretor no valor de 10000.
     */

    /**
     * Exemplo com muitos níveis de controle de fluxo.
     * Quanto mais níveis, mais complexo um código se torna e pode ficar difícil
     * de entender qual sua funcionalidade.
     * Exemplo abaixo demonstra algo que NÃO deve ser feito.
     */
    private float bonusFuncionario1(int experiencia) {
        if (experiencia == 0) {
            return 500;
        } else {
            if (experiencia == 1) {
                return 2000;
            } else {
                if (experiencia == 2) {
                    return 2000;
                } else {
                    if (experiencia == 3) {
                        return 2000;
                    }
                }
            }
        }

        return 0F;
    }

    /**
     * Mais um tipo de resolução. Desta vez com menos níveis,
     * mas ainda assim é possível melhorar.
     */
    public void bonusFuncionario2(int anosEmpresa) {
        if (anosEmpresa == 0) {
            System.out.println("Bônus padrão: R$500,00");
        } else {
            if (anosEmpresa >= 1 && anosEmpresa <= 3) {
                System.out.println("Bônus: R$2000,00");
            } else {
                System.out.println("Bônus: R$5000,00");
            }
        }
    }

    /**
     * Tipo de resolução armazenando o valor em uma variável para retornar ao final.
     */
    public float bonusFuncionario3(int anosEmpresa) {
        float bonus;
        if (anosEmpresa == 0) {
            bonus = 500;
        } else if (anosEmpresa >= 1 && anosEmpresa <= 3) {
            bonus = 2000;
        } else {
            bonus = 5000;
        }

        return bonus;
    }

    /**
     * Sem controle de fluxo aninhado.
     * Uso do conceito de EARLY RETURN. Retornar assim que possível.
     */
    public float bonusFuncionario4(int anosEmpresa, String cargo) {
        if (cargo.equals("Diretor")) {
            return 10000;
        }

        if (anosEmpresa == 0) {
            return 500F;
        } else if (anosEmpresa >= 1 && anosEmpresa <= 3) {
            return 2000;
        } else {
            return 5000;
        }
    }

}