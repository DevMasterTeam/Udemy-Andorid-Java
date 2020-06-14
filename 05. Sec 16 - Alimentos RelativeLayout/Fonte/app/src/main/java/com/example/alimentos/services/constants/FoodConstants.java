package com.example.alimentos.services.constants;

/**
 * Classe de constantes
 */
public class FoodConstants {

    /**
     * Construtor privado, faz com que não seja possível instanciar a classe.
     * Os dados da classe podem ser acessados através das variáveis estáticas.
     */
    private FoodConstants() {
    }

    // Utilizada para passagem de parâmetros
    public static String FOOD_ID = "foodId";

    public static class FILTER {
        public static int NO_FILTER = 0;
        public static int CAL_LOW = 1;
        public static int CAL_MEDIUM = 2;
        public static int CAL_HIGH = 3;
    }

}
