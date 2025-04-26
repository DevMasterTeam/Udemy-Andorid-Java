package com.devmasterteam.mybooks.repository;

import com.devmasterteam.mybooks.entity.BookEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por armazenar e manipular os livros.
 * Simula um banco de dados local usando uma lista mutável.
 */
public class BookRepository {

    // Lista mutável que armazena os livros
    private final List<BookEntity> books = new ArrayList<>();

    /**
     * Construtor privado
     */
    private BookRepository() {
        books.addAll(getInitialBooks());
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
    public static BookRepository getInstance() {
        synchronized (BookRepository.class) {
            if (instance == null) {
                instance = new BookRepository();
            }
        }
        return instance;
    }

    /**
     * Cria uma lista inicial de livros para popular o repositório.
     */
    private List<BookEntity> getInitialBooks() {
        List<BookEntity> initialBooks = new ArrayList<>();
        initialBooks.add(new BookEntity(1, "To Kill a Mockingbird", "Harper Lee", true, "Ficção"));
        initialBooks.add(new BookEntity(2, "Dom Casmurro", "Machado de Assis", false, "Romance"));
        initialBooks.add(new BookEntity(3, "O Hobbit", "J.R.R. Tolkien", true, "Fantasia"));
        initialBooks.add(new BookEntity(4, "Cem Anos de Solidão", "Gabriel García Márquez", false, "Romance"));
        initialBooks.add(new BookEntity(5, "O Pequeno Príncipe", "Antoine de Saint-Exupéry", false, "Fantasia"));
        initialBooks.add(new BookEntity(6, "Crime e Castigo", "Fiódor Dostoiévski", false, "Ficção policial"));
        initialBooks.add(new BookEntity(7, "Frankenstein", "Mary Shelley", false, "Terror"));
        initialBooks.add(new BookEntity(8, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", false, "Fantasia"));
        initialBooks.add(new BookEntity(9, "Neuromancer", "William Gibson", false, "Cyberpunk"));
        initialBooks.add(new BookEntity(10, "Senhor dos Anéis", "J.R.R. Tolkien", false, "Fantasia"));
        initialBooks.add(new BookEntity(11, "Drácula", "Bram Stoker", false, "Terror"));
        initialBooks.add(new BookEntity(12, "Orgulho e Preconceito", "Jane Austen", false, "Romance"));
        initialBooks.add(new BookEntity(13, "Harry Potter e a Câmara Secreta", "J.K. Rowling", false, "Fantasia"));
        initialBooks.add(new BookEntity(14, "As Crônicas de Nárnia", "C.S. Lewis", false, "Fantasia"));
        initialBooks.add(new BookEntity(15, "O Código Da Vinci", "Dan Brown", false, "Mistério"));
        initialBooks.add(new BookEntity(16, "It: A Coisa", "Stephen King", false, "Terror"));
        initialBooks.add(new BookEntity(17, "Moby Dick", "Herman Melville", true, "Aventura"));
        initialBooks.add(new BookEntity(18, "O Nome do Vento", "Patrick Rothfuss", true, "Fantasia"));
        initialBooks.add(new BookEntity(19, "O Conde de Monte Cristo", "Alexandre Dumas", true, "Aventura"));
        initialBooks.add(new BookEntity(20, "Os Miseráveis", "Victor Hugo", false, "Romance"));
        return initialBooks;
    }

    /**
     * Retorna todos os livros armazenados.
     */
    public List<BookEntity> getAllBooks() {
        return books;
    }

    /**
     * Retorna todos os livros marcados como favoritos.
     */
    public List<BookEntity> getFavoriteBooks() {
        List<BookEntity> favoriteBooks = new ArrayList<>();
        for (BookEntity book : books) {
            if (book.isFavorite()) {
                favoriteBooks.add(book);
            }
        }
        return favoriteBooks;
    }

    /**
     * Busca um livro pelo ID.
     */
    public BookEntity getBookById(int id) {
        BookEntity book = null;
        for (BookEntity b : books) {
            if (b.getId() == id) {
                book = b;
                break;
            }
        }
        return book;
    }

    /**
     * Alterna entre true e false o atributo 'favorite'.
     */
    public void toggleFavoriteStatus(int id) {
        for (BookEntity book : books) {
            if (book.getId() == id) {
                book.setFavorite(!book.isFavorite());
                break;
            }
        }
    }

    /**
     * Remove um livro pelo ID.
     */
    public boolean deleteBook(int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }
}