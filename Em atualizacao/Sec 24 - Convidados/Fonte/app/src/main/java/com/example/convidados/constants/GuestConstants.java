package com.example.convidados.constants;

public class GuestConstants {

    /**
     * Construtor privado impede que classe seja instanciada
     */
    private GuestConstants() {
    }

    /**
     * Usado para passagem de parâmetro entre activities
     */
    public static String GUESTID = "guestId";

    /**
     * Usada para a navegação de fragments
     */
    public static String FILTER = "FILTER";

    /**
     * Usado para confirmação do usuário
     */
    public static class CONFIRMATION {
        public static int NOT_CONFIRMED = 0;
        public static int PRESENT = 1;
        public static int ABSENT = 2;
    }

}