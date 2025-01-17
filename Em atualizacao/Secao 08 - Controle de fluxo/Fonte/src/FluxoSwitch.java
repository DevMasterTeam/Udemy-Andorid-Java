/**
 * Switch case pode ser usado quando existe possibilidades limitadas de valores para uma variável.
 --
 * O mesmo funcionamento poderia ser alcançado com if/else, porém em alguns casos,
 * a definição de valores com switch facilita a leitura.
 --
 * Existe também a possibilidade de fornecer um comportamento padrão definido no 'default',
 * caso os valores não satisfaçam a condição.
 --
 * A palavra "break" dentro de cada opção faz com que a verificação de valores não continue
 * caso entre em alguns dos "cases".
 */
public class FluxoSwitch {

    private void calculaBonus(String cargo, Float salario) {
        switch (cargo) {
            case "Gerente": {
                // Switch case com controle de fluxo if/else
                if (salario <= 2000) {
                    System.out.println("O bônus é de: " + salario * 0.5);
                } else {
                    System.out.println("O bônus é de: " + salario * 0.6);
                }
                break;
            }
            case "Supervisor": {
                System.out.println("O bônus é de: " + salario * 0.5);
                break;
            }
            default: {
                System.out.println("Bônus padrão de R$300,00");
                break;
            }
        }
    }

    public static void main(String[] args) {
        FluxoSwitch fluxoWhen = new FluxoSwitch();
        fluxoWhen.calculaBonus("Gerente", 1800f);
        fluxoWhen.calculaBonus("Gerente", 2800f);
        fluxoWhen.calculaBonus("Supervisor", 1300f);
        fluxoWhen.calculaBonus("Técnico", 1200f);
    }
}