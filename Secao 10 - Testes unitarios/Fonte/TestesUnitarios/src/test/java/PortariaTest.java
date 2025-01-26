import org.junit.jupiter.api.*;

public class PortariaTest {

    // Variável no escopo da classe para ser acessível dentro de todos os métodos
    Portaria p = new Portaria();

    String menorIdade = "Negado. Menores de idade não são permitidos.";
    String welcome = "Welcome :)";
    String conviteInvalido = "Negado. Convite inválido.";

    @Test
    @DisplayName("Não permite entrada de menores de idade.")
    public void naoPermiteMenoresDeIdade() {

        // Quando existem várias assertions, se uma falhar, as outras não são executadas.
        Assertions.assertEquals(p.controle(-5, "comum", "xt123"), menorIdade);
        Assertions.assertEquals(p.controle(17, "comum", "xt123"), menorIdade);
        Assertions.assertEquals(p.controle(0, "comum", "xt123"), menorIdade);

        // É possível fazer a verificação de todas as assertions mesmo que uma falhe
        /*Assertions.assertAll(
                () -> Assertions.assertEquals(p.controle(17, "comum", "XT123"), menorIdade),
                () -> Assertions.assertEquals(p.controle(27, "comum", "XT123"), welcome),
                () -> Assertions.assertEquals(p.controle(30, "comum", "XT123"), welcome)
        );*/
    }

    @Test
    @DisplayName("Não permite tipo de convite inválido.")
    public void naoPermiteTipoDeConviteInvalido() {
        Assertions.assertEquals(p.controle(25, "cpto", ""), conviteInvalido);
        Assertions.assertEquals(p.controle(25, "----", ""), conviteInvalido);
        Assertions.assertEquals(p.controle(50, "*(&$&%¨&#", ""), conviteInvalido);
        Assertions.assertEquals(p.controle(70, "LUXO", ""), conviteInvalido);
    }

    @Test
    @DisplayName("Não permite tipo de convite válido com código inválido.")
    public void conviteValidoCodigoInvalido() {
        Assertions.assertEquals(p.controle(25, "comum", "55t584"), conviteInvalido);
        Assertions.assertEquals(p.controle(25, "premium", "OLLl875"), conviteInvalido);
        Assertions.assertEquals(p.controle(25, "luxo", "893487"), conviteInvalido);
    }

    @Test
    @DisplayName("Permite acesso ao evento.")
    public void permiteAcessoPortaria() {
        Assertions.assertEquals(p.controle(25, "comum", "xt123"), welcome);
        Assertions.assertEquals(p.controle(25, "premium", "xl418"), welcome);
        Assertions.assertEquals(p.controle(25, "luxo", "xl98"), welcome);
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
        Assumptions.assumeTrue(p.controle(17, "comum", "xt123").equals(menorIdade));

        // Resto do código só é executado se a suposição se mostrar como verdadeira
        Assertions.assertEquals(p.controle(36, "comum", "xt123"), welcome);
    }

    @Test
    @DisplayName("Teste lancamento de excecao")
    public void lancaExcecao() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            String str = null;
            str.length();
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