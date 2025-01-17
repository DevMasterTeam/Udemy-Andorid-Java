import org.junit.jupiter.api.*;

public class PortariaTest {
    Portaria p = new Portaria();

    String menorIdade = "Negado. Menores de idade não são permitidos.";
    String welcome = "Welcome :)";
    String conviteInvalido = "Negado. Convite inválido.";

    @Test
    @DisplayName("Teste funcionamento portaria com variações de convite e código.")
    public void testeEntradaPortaria() {

        // Quando existem várias assertions, se uma falhar, as outras não são executadas.
        Assertions.assertEquals(p.controle(-5, "comum", "XT123"), menorIdade);
        Assertions.assertEquals(p.controle(17, "comum", "XT123"), menorIdade);
        Assertions.assertEquals(p.controle(27, "comum", "XT123"), welcome);
        Assertions.assertEquals(p.controle(27, "premium", "XT123"), conviteInvalido);
        Assertions.assertEquals(p.controle(27, "luxo", "XT123"), conviteInvalido);
        Assertions.assertEquals(p.controle(27, "VIP", "XT123"), conviteInvalido);
        Assertions.assertEquals(p.controle(27, "premium", "XL845"), welcome);
        Assertions.assertEquals(p.controle(27, "luxo", "XL845"), welcome);

        // É possível fazer a verificação de todas as assertions mesmo que uma falhe
        Assertions.assertAll(
                () -> Assertions.assertEquals(p.controle(17, "comum", "XT123"), menorIdade),
                () -> Assertions.assertEquals(p.controle(27, "comum", "XT123"), welcome),
                () -> Assertions.assertEquals(p.controle(30, "comum", "XT123"), welcome)
        );
    }

    @Test
    @Disabled("Ainda não finalizado.")
    public void naoImplementado() {
    }

    @Test
    public void naoImplementadoMasInvalido() {
        // Vai falhar
        Assertions.fail("Ainda não finalizado.");
    }

    @Test
    @DisplayName("Roda baseado em condicao")
    public void rodaSomenteBaseadoEmCondicao() {
        // Suposição
        Assumptions.assumeTrue(p.controle(17, "comum", "XT123") == menorIdade);

        // Resto do código só é executado se a suposição se mostrar como verdadeira
        Assertions.assertEquals(p.controle(17, "comum", "XT123"), welcome);
    }

    @Test
    @DisplayName("Teste lancamento de excecao")
    public void lancaExcecao() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            String str = null;
            int tamanho = str.length();
        });
    }

    @Test
    @DisplayName("Teste de não nulo.")
    public void testNotNull() {
        // Testa se o retorno da função é diferente de nulo.
        Assertions.assertNotNull(p.controle(17, "", ""));

        // Muito cuidado em cenários desse tipo, pois pode ser que a função nunca tenha o retorno nulo
        // Nesse caso, esse teste nunca falha, mesmo que a função esteja com comportamento incorreto.
    }
}