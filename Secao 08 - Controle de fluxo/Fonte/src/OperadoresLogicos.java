/**
 * Além dos operadores de comparação (>, >=, <, <=) e igualdade (==, !=)
 * É possível usar outros operadores para fazer a combinação de condições.
 * && - Operador AND, em português E ou CONJUNÇÃO
 * || - Operador OR, em português OU ou DISJUNÇÃO
 * ! - Operador NOT, em português NÃO ou NEGAÇÃO
 */
public class OperadoresLogicos {

    private void bonusFuncionario(int anosEmpresa) {
        if (anosEmpresa == 0) {
            System.out.println("Bônus padrão: R$200,00");
        } else if (anosEmpresa >= 1 && anosEmpresa <= 4) {
            System.out.println("Bônus: R$400,00");
        } else {
            System.out.println("Bônus: R$1000,00");
        }
    }

    private boolean maiorDeIdade(int idade) {

        // Operadores para executar uma validação
        // idade == 18;
        // idade > 18;
        // idade >= 18;
        // idade < 18;
        // idade <= 18;
        // idade != 18;

        return (idade > 18);
    }

    private void execucaoTarefa(boolean critica, boolean urgente) {
        if (critica || urgente) {
            System.out.println("Tarefa deve ser executada de qualquer maneira.");
        } else {
            System.out.println("Tome seu tempo.");
        }
    }

    public static void main(String[] args) {
        OperadoresLogicos op = new OperadoresLogicos();

        op.bonusFuncionario(0);
        op.bonusFuncionario(2);
        op.bonusFuncionario(10);

        op.execucaoTarefa(true, false);
        op.execucaoTarefa(false, true);
        op.execucaoTarefa(false, false);

        if (!op.maiorDeIdade(15)) {
            System.out.println("Permitida entrada somente de maiores de idade.");
        }
    }
}
