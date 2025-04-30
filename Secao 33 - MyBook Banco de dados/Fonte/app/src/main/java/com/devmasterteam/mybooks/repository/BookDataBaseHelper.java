package com.devmasterteam.mybooks.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.devmasterteam.mybooks.entity.BookEntity;
import com.devmasterteam.mybooks.helper.DataBaseConstants;

import java.util.ArrayList;
import java.util.List;

public class BookDataBaseHelper extends SQLiteOpenHelper {

    // Versão do banco e nome
    private static final int VERSION = 1;
    private static final String NAME = "BooksDB";

    // Constante que representa o comando SQL para criar a tabela de livros
    private static final String CREATE_TABLE_BOOKS =
            "CREATE TABLE " + DataBaseConstants.BOOK.TABLE_NAME + " (" +
                    DataBaseConstants.BOOK.COLUMNS.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    DataBaseConstants.BOOK.COLUMNS.TITLE + " TEXT NOT NULL, " +
                    DataBaseConstants.BOOK.COLUMNS.AUTHOR + " TEXT NOT NULL, " +
                    DataBaseConstants.BOOK.COLUMNS.FAVORITE + " INTEGER NOT NULL, " +
                    DataBaseConstants.BOOK.COLUMNS.GENRE + " TEXT NOT NULL" +
                    ");";

    /**
     * Construtor
     */
    public BookDataBaseHelper(Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Executa a criação da tabela no banco
        db.execSQL(CREATE_TABLE_BOOKS);

        // Uma vez criada, executa a inserção da massa de dados
        insertBooks(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Deleta a tabela e cria novamente (uma maneira de lidar com atualizações)
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseConstants.BOOK.TABLE_NAME);

        // Cria novamente usando o novo schema
        onCreate(db);
    }

    /**
     * Função para inserir livros no banco de dados
     */
    private void insertBooks(SQLiteDatabase db) {
        List<BookEntity> books = getInitialBooks();
        for (BookEntity book : books) {
            ContentValues values = new ContentValues();
            values.put(DataBaseConstants.BOOK.COLUMNS.TITLE, book.getTitle());
            values.put(DataBaseConstants.BOOK.COLUMNS.AUTHOR, book.getAuthor());
            // Converte boolean para inteiro
            values.put(DataBaseConstants.BOOK.COLUMNS.FAVORITE, book.isFavorite() ? 1 : 0);
            values.put(DataBaseConstants.BOOK.COLUMNS.GENRE, book.getGenre());

            // Insere o livro na tabela
            db.insert(DataBaseConstants.BOOK.TABLE_NAME, null, values);
        }
    }

    /**
     * Cria uma lista inicial de livros para popular o repositório.
     */
    private List<BookEntity> getInitialBooks() {
        List<BookEntity> books = new ArrayList<>();

        books.add(new BookEntity(1, "To Kill a Mockingbird", "Harper Lee", true, "Ficção"));
        books.add(new BookEntity(2, "Dom Casmurro", "Machado de Assis", false, "Romance"));
        books.add(new BookEntity(3, "O Hobbit", "J.R.R. Tolkien", true, "Fantasia"));
        books.add(new BookEntity(4, "Cem Anos de Solidão", "Gabriel García Márquez", false, "Romance"));
        books.add(new BookEntity(5, "O Pequeno Príncipe", "Antoine de Saint-Exupéry", false, "Fantasia"));
        books.add(new BookEntity(6, "Crime e Castigo", "Fiódor Dostoiévski", false, "Ficção policial"));
        books.add(new BookEntity(7, "Frankenstein", "Mary Shelley", false, "Terror"));
        books.add(new BookEntity(8, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", false, "Fantasia"));
        books.add(new BookEntity(9, "Neuromancer", "William Gibson", false, "Cyberpunk"));
        books.add(new BookEntity(10, "Senhor dos Anéis", "J.R.R. Tolkien", false, "Fantasia"));
        books.add(new BookEntity(11, "Drácula", "Bram Stoker", false, "Terror"));
        books.add(new BookEntity(12, "Orgulho e Preconceito", "Jane Austen", false, "Romance"));
        books.add(new BookEntity(13, "Harry Potter e a Câmara Secreta", "J.K. Rowling", false, "Fantasia"));
        books.add(new BookEntity(14, "As Crônicas de Nárnia", "C.S. Lewis", false, "Fantasia"));
        books.add(new BookEntity(15, "O Código Da Vinci", "Dan Brown", false, "Mistério"));
        books.add(new BookEntity(16, "It: A Coisa", "Stephen King", false, "Terror"));
        books.add(new BookEntity(17, "Moby Dick", "Herman Melville", true, "Aventura"));
        books.add(new BookEntity(18, "O Nome do Vento", "Patrick Rothfuss", true, "Fantasia"));
        books.add(new BookEntity(19, "O Conde de Monte Cristo", "Alexandre Dumas", true, "Aventura"));
        books.add(new BookEntity(20, "Os Miseráveis", "Victor Hugo", false, "Romance"));

        return books;
    }
}
