import character.Character;

/**
 * Classe responsável por gerenciar batalhas entre personagens no jogo.
 */
class Battle {

    private static Character hero;
    private static Character enemy;

    /**
     * Executa uma rodada de combate entre o jogador e o inimigo.
     * O jogador ataca primeiro, seguido pelo inimigo (se ele ainda estiver vivo).
     * A batalha termina quando um dos personagens é derrotado.
     */
    public static void fight() {
        int damageHero = hero.attack();
        enemy.receiveDamage(damageHero);

        if (!enemy.isAlive()) {
            System.out.println(enemy + " foi derrotado!");
            return;
        }

        int damageEnemy = enemy.attack();
        hero.receiveDamage(damageEnemy);

        if (!hero.isAlive()) {
            System.out.println(hero + " foi derrotado!");
            return;
        }

        System.out.println();
    }

    /**
     * Inicia a batalha entre dois personagens.
     */
    public static void start(Character p1, Character p2) {
        hero = p1;
        enemy = p2;

        System.out.println();
        System.out.println("Batalha iniciada entre " + p1 + " e " + p2);
        System.out.println();
    }
}