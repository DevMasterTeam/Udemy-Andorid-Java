package com.devmasterteam.mybooks.repository;

import android.content.Context;

import com.devmasterteam.mybooks.entity.BookEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por armazenar e manipular os livros.
 * Simula um banco de dados local usando uma lista mutável.
 */
public class BookRepository {

    // Acesso ao banco de dados
    private final BookDAO dataBase;

    private BookRepository(Context context) {
        dataBase = BookDataBase.getDatabase(context).bookDAO();
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
        return dataBase.getAllBooks();
    }

    /**
     * Retorna todos os livros marcados como favoritos.
     */
    public List<BookEntity> getFavoriteBooks() {
        return dataBase.getFavoriteBooks();
    }

    /**
     * Busca um livro pelo ID.
     */
    public BookEntity getBookById(int id) {
        return dataBase.getBookById(id);
    }

    /**
     * Alterna entre true e false o atributo 'favorite'
     */
    public void toggleFavoriteStatus(int id) {
        BookEntity book = getBookById(id);
        book.setFavorite(!book.isFavorite());
        dataBase.update(book);
    }

    /**
     * Remove um livro pelo ID
     */
    public boolean deleteBook(int id) {
        return dataBase.delete(getBookById(id)) > 0;
    }

    /**
     * Faz a criação dos livros no banco de dados
     */
    public void loadInitialData() {
        dataBase.create(getInitialBooks());
    }

    /**
     * Massa inicial de dados
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