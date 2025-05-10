package com.devmasterteam.mybooks.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.devmasterteam.mybooks.callback.Callback;
import com.devmasterteam.mybooks.entity.BookEntity;
import com.devmasterteam.mybooks.repository.BookRepository;

import java.util.List;

public class FavoriteViewModel extends AndroidViewModel {

    // Acesso a dados
    private final BookRepository repository =
            BookRepository.getInstance(getApplication().getApplicationContext());

    // Livro que será carregado
    private final MutableLiveData<List<BookEntity>> _bookList = new MutableLiveData<>();
    public final LiveData<List<BookEntity>> bookList = _bookList;

    public FavoriteViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * Busca todos os livros
     */
    public void getFavoriteBooks() {
        repository.getFavoriteBooks(new Callback<List<BookEntity>>() {
            @Override
            public void onSuccess(List<BookEntity> result) {
                _bookList.postValue(result);
            }

        });
    }

    /**
     * Atualiza boolean de favorito
     */
    public void favorite(int bookId) {
        // Atualiza boolean de favorito
        repository.toggleFavoriteStatus(bookId, new Callback<Void>() {
            @Override
            public void onSuccess(Void result) {
                // Atualiza listagem para refletir as mudanças
                getFavoriteBooks();
            }
        });
    }
}