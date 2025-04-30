package com.devmasterteam.mybooks.helper;

// Classe utilitária que contém constantes relacionadas ao banco de dados
public final class DataBaseConstants {

    // Construtor privado para evitar instância da classe
    private DataBaseConstants() {}

    // Estrutura relacionada à tabela de livros
    public static class BOOK {
        // Nome da tabela
        public static final String TABLE_NAME = "BookTable";

        // Colunas da tabela de livros
        public static class COLUMNS {
            public static final String ID = "id";
            public static final String TITLE = "title";
            public static final String AUTHOR = "author";
            public static final String FAVORITE = "favorite";
            public static final String GENRE = "genre";
        }
    }
}
