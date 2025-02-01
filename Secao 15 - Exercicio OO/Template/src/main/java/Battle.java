import character.Character;

/**
 * Classe responsável por gerenciar batalhas entre personagens no jogo.
 */
class Battle {

    private static Character principal;
    private static Character enemy;

    /**
     * Executa uma rodada de combate entre o jogador e o inimigo.
     * O jogador ataca primeiro, seguido pelo inimigo (se ele ainda estiver vivo).
     * A batalha termina quando um dos personagens é derrotado.
     */
    public static void fight() {
        int danoJogador = principal.attack();
        enemy.receiveDamage(danoJogador);

        if (!enemy.isAlive()) {
            System.out.println(enemy + " foi derrotado!");
            // Exercicio: Se o inimigo foi derrotada, como interropter este código?
        }

        int danoInimigo = enemy.attack();
        principal.receiveDamage(danoInimigo);

        if (!principal.isAlive()) {
            System.out.println(principal + " foi derrotado!");
            // Exercicio: Se o herói foi derrotada, como interropter este código?
        }

        System.out.println();
    }

    /**
     * Inicia a batalha entre dois personagens.
     */
    public static void start(Character p1, Character p2) {
        principal = p1;
        enemy = p2;

        System.out.println("\nBatalha iniciada entre " + p1 + " e " + p2);
    }
}