package com.devmasterteam.mybooks.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.devmasterteam.mybooks.entity.BookEntity;
import com.devmasterteam.mybooks.helper.DataBaseConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por armazenar e manipular os livros.
 * Simula um banco de dados local usando uma lista mutável.
 */
public class BookRepository {

    // Acesso ao banco de dados
    private final BookDataBaseHelper dataBase;

    private BookRepository(Context context) {
        dataBase = new BookDataBaseHelper(context);
    }

    /**
     * O padrão Singleton garante que uma classe tenha apenas uma instância durante toda a execução do programa.
     * Ele fornece um ponto de acesso global para acessar essa instância de forma controlada e segura.
     * ---------------
     * Vantagens do Singleton:
     * - Garante que a classe tenha uma única instância.
     * - Oferece um ponto de acesso global para essa instância.
     * - Pode ser útil para recursos compartilhados, como conexões de banco de dados ou repositórios de dados.
     */
    private static BookRepository instance;

    /**
     * Fornece a única instância do BookRepository.
     * Esta é uma implementação thread-safe do padrão singleton.
     */
    public static synchronized BookRepository getInstance(Context context) {
        synchronized (BookRepository.class) {
            if (instance == null) {
                instance = new BookRepository(context);
            }
        }
        return instance;
    }

    /**
     * Retorna todos os livros armazenados.
     */
    public List<BookEntity> getAllBooks() {
        // Lista de livros
        List<BookEntity> books = new ArrayList<>();

        // Obtém uma instância de leitura do banco de dados
        SQLiteDatabase db = dataBase.getReadableDatabase();

        // Query para selecionar todos os livros da tabela
        Cursor cursor = db.query(
                DataBaseConstants.BOOK.TABLE_NAME,  // Nome da tabela
                null,  // Seleciona todas as colunas
                null,  // Sem filtro de linhas
                null,  // Sem argumentos
                null,  // Sem agrupamento
                null,  // Sem filtro de ordenação
                null   // Sem limite
        );

        // Verifica se o cursor contém algum dado e percorre todas as linhas
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.ID));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.TITLE));
                String author = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.AUTHOR));
                // Converte de volta para booleano
                boolean fav = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.FAVORITE)) == 1;
                String genre = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.GENRE));

                // Adiciona o livro à lista
                books.add(new BookEntity(id, title, author, fav, genre));

                // Continua enquanto houver mais registros
            } while (cursor.moveToNext());
        }

        // Fecha o cursor e banco de dados após o uso
        cursor.close();
        db.close();

        // Retorna a lista de livros
        return books;
    }

    /**
     * Retorna todos os livros marcados como favoritos.
     */
    public List<BookEntity> getFavoriteBooks() {
        // Lista de livros
        List<BookEntity> favoriteBooks = new ArrayList<>();

        // Obtém uma instância de leitura do banco de dados
        SQLiteDatabase db = dataBase.getReadableDatabase();

        // Query para selecionar todos os livros favoritos
        Cursor cursor = db.query(
                DataBaseConstants.BOOK.TABLE_NAME,  // Nome da tabela
                null,  // Seleciona todas as colunas
                DataBaseConstants.BOOK.COLUMNS.FAVORITE + " = ?",  // Filtro para favoritos
                new String[]{"1"},  // Argumento para 'favorite = 1'
                null,  // Sem agrupamento
                null,  // Sem filtro de ordenação
                null   // Sem limite
        );

        // Verifica se o cursor contém algum dado e percorre todas as linhas
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.ID));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.TITLE));
                String author = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.AUTHOR));
                boolean fav = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.FAVORITE)) == 1;
                String genre = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.GENRE));

                // Adiciona o livro à lista de favoritos
                favoriteBooks.add(new BookEntity(id, title, author, fav, genre));
            } while (cursor.moveToNext());
        }

        // Fecha o cursor e banco de dados após o uso
        cursor.close();
        db.close();

        // Retorna a lista de livros favoritos
        return favoriteBooks;
    }

    /**
     * Busca um livro pelo ID.
     */
    public BookEntity getBookById(int id) {
        // Obtém uma instância de leitura do banco de dados
        SQLiteDatabase db = dataBase.getReadableDatabase();

        // Query para selecionar um livro pelo ID
        Cursor cursor = db.query(
                DataBaseConstants.BOOK.TABLE_NAME,  // Nome da tabela
                null,  // Seleciona todas as colunas
                DataBaseConstants.BOOK.COLUMNS.ID + " = ?",  // Filtro para o ID
                new String[]{String.valueOf(id)},  // Argumento para ID
                null,  // Sem agrupamento
                null,  // Sem filtro de ordenação
                null   // Sem limite
        );

        // Verifica se o cursor contém algum dado
        BookEntity book = null;
        if (cursor.moveToFirst()) {
            int bookId = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.ID));
            String title = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.TITLE));
            String author = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.AUTHOR));
            boolean fav = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.FAVORITE)) == 1;
            String genre = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.GENRE));

            // Cria o objeto BookEntity
            book = new BookEntity(bookId, title, author, fav, genre);
        }

        // Fecha o cursor e banco de dados após o uso
        cursor.close();
        db.close();

        // Retorna o livro encontrado ou null
        return book;
    }

    /**
     * Alterna entre true e false o atributo 'favorite'
     */
    public void toggleFavoriteStatus(int id) {
        // Obtém o livro filtrado pelo ID
        BookEntity book = getBookById(id);
        int newFavoriteStatus = (book != null && book.isFavorite()) ? 0 : 1;
        SQLiteDatabase db = dataBase.getWritableDatabase();

        // Atualiza o status de favorito
        ContentValues values = new ContentValues();
        values.put(DataBaseConstants.BOOK.COLUMNS.FAVORITE, newFavoriteStatus);

        db.update(
                DataBaseConstants.BOOK.TABLE_NAME,
                values,
                DataBaseConstants.BOOK.COLUMNS.ID + " = ?",
                new String[]{String.valueOf(id)}
        );

        // Fecha o banco de dados
        db.close();
    }

    /**
     * Remove um livro pelo ID
     */
    public boolean deleteBook(int id) {
        // Obtém uma instância de escrita do banco de dados
        SQLiteDatabase db = dataBase.getWritableDatabase();

        // Deleta o livro pelo ID
        int rowsDeleted = db.delete(
                DataBaseConstants.BOOK.TABLE_NAME,
                DataBaseConstants.BOOK.COLUMNS.ID + " = ?",
                new String[]{String.valueOf(id)}
        );

        // Fecha o banco de dados
        db.close();

        // Retorna true se uma linha foi deletada, caso contrário, false
        return rowsDeleted > 0;
    }
}