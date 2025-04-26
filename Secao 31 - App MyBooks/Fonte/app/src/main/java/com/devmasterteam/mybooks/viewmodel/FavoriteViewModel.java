package com.devmasterteam.mybooks.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.devmasterteam.mybooks.entity.BookEntity;
import com.devmasterteam.mybooks.repository.BookRepository;

import java.util.List;

public class FavoriteViewModel extends ViewModel {

    // Acesso a dados
    private final BookRepository repository = BookRepository.getInstance();

    // Livro que será carregado
    private final MutableLiveData<List<BookEntity>> _bookList = new MutableLiveData<>();
    public final LiveData<List<BookEntity>> bookList = _bookList;

    /**
     * Busca todos os livros
     */
    public void getFavoriteBooks() {
        _bookList.setValue(repository.getFavoriteBooks());
    }

    /**
     * Atualiza boolean de favorito
     */
    public void favorite(int bookId) {
        // Atualiza boolean de favorito
        repository.toggleFavoriteStatus(bookId);

        // Atualiza listagem para refletir as mudanças
        getFavoriteBooks();
    }
}