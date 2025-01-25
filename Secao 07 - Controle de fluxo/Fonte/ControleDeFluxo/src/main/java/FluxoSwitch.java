/**
 * Switch case pode ser usado quando existe possibilidades limitadas de valores para uma variável.
 * --
 * O mesmo funcionamento poderia ser alcançado com if/else, porém em alguns casos,
 * a definição de valores com switch facilita a leitura.
 * --
 * Existe também a possibilidade de fornecer um comportamento padrão definido no 'default',
 * caso os valores não satisfaçam a condição.
 * --
 * A palavra "break" dentro de cada opção faz com que a verificação de valores não continue
 * caso entre em alguns dos "cases".
 */
public class FluxoSwitch {

    // Estilo mais recente de Switch chamado de "rule switch" que faz o uso de -> 
    // e não necessita da palavra break dentro dos cases.
    private void calculaBonus(String cargo, Float salario) {
        switch (cargo) {
            case "Gerente" -> {
                // Switch case com controle de fluxo if/else
                if (salario <= 2000) {
                    System.out.println("O bônus é de: " + salario * 0.5);
                } else {
                    System.out.println("O bônus é de: " + salario * 0.6);
                }
            }
            case "Supervisor" -> {
                System.out.println("O bônus é de: " + salario * 0.5);
            }
            default -> {
                System.out.println("Bônus padrão de R$300,00");
            }
        }
    }

    private void calculaBonus2(String cargo, Float salario) {
        switch (cargo) {
            case "Gerente" -> {
                double bonus = salario <= 2000 ? salario * 0.5 : salario * 0.6;
                System.out.println("O bônus é de: " + bonus);
            }
            case "Supervisor" -> {
                System.out.println("O bônus é de: " + salario * 0.5);
            }
            default -> {
                System.out.println("Bônus padrão de R$300,00");
            }
        }
    }

    private float valorMensalidade(String curso) {
        float valor;
        switch (curso) {
            case "Geografia": {
                valor = 500;
                break;
            }
            case "Matematica":
            case "Filosofia": {
                valor = 800;
                break;
            }
            case "Informática": {
                valor = 1200;
                break;
            }
            default: {
                valor = 0;
            }
        }
        return valor;
    }

    public static void main(String[] args) {
        FluxoSwitch fluxo = new FluxoSwitch();
        fluxo.calculaBonus("Gerente", 1800f);
        fluxo.calculaBonus("Gerente", 2800f);
        fluxo.calculaBonus("Supervisor", 1300f);
        fluxo.calculaBonus("Técnico", 1200f);
        System.out.println(fluxo.valorMensalidade("Geografia"));
    }
}