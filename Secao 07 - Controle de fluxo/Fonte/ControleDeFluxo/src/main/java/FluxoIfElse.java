public class FluxoIfElse {
    private boolean maiorDeIdade(int idade) {

        // boolean validacao = idade == 18;
        // boolean validacao = idade > 18;
        // boolean validacao = idade >= 18;
        // boolean validacao = idade < 18;
        // boolean validacao = idade <= 18;
        // boolean validacao = idade != 18;

        // O controle de fluxo if/else tem o poder de alterar o fluxo do programa baseado numa condição.
        // Quando a expressão dentro do if é verdadeira, o código relacionado ao if é executado.
        // if (expressao)

        // Uma vez que (idade >= 18) é uma expressão avaliada como true ou false
        // seu valor pode ser retornado, pois é compatível com o tipo de retorno da função.
        return (idade >= 18);
    }

    /**
     * Cálculo de mensalidade de faculdade baseada em curso
     * matematica - 500
     * informatica - 600
     * geografia - 700
     * */
    private float calculoMensalidade(String curso) {
        // Retornos feitos quando uma condição é satisfeita.
        // Nesse caso, não existe ELSE. Ou seja, não existe uma condição padrão.
        // Dessa maneira, existe um valor padrão retornado no final da função.
        if (curso.equals("matematica")) {
            return 500;
        } else if (curso.equals("informatica")) {
            return 600;
        } else if (curso.equals("geografia")) {
            return 700;
        }

        return 0F;
    }

    private float calculoMensalidade2(String curso) {
        // Neste exemplo, caso o curso informado por parâmetro não seja encontrado,
        // existe uma condição padrão executada, ELSE.
        // Assim, não é necessário ter um return explícito depois do controle de fluxo;
        if (curso.equals("matematica")) {
            return 500;
        } else if (curso.equals("informatica")) {
            return 600;
        } else if (curso.equals("geografia")) {
            return 700;
        } else {
            return 0F;
        }
    }
}
