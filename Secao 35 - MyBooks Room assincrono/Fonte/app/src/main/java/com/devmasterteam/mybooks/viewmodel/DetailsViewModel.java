package com.devmasterteam.mybooks.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.devmasterteam.mybooks.callback.Callback;
import com.devmasterteam.mybooks.entity.BookEntity;
import com.devmasterteam.mybooks.repository.BookRepository;

public class DetailsViewModel extends AndroidViewModel {

    // Acesso a dados
    private final BookRepository repository =
            BookRepository.getInstance(getApplication().getApplicationContext());

    // Livro que será carregado
    private final MutableLiveData<BookEntity> _book = new MutableLiveData<>();
    public LiveData<BookEntity> book = _book;

    // Livro que será removido
    private final MutableLiveData<Boolean> _bookDeleted = new MutableLiveData<>();
    public LiveData<Boolean> bookDeleted = _bookDeleted;

    public DetailsViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * Carrega livro do repositório
     */
    public void getBook(int bookId) {
        repository.getBookById(bookId, new Callback<BookEntity>() {
            @Override
            public void onSuccess(BookEntity result) {
                _book.postValue(result);
            }

        });
    }

    /**
     * Atualiza boolean de favorito
     */
    public void favorite(int bookId) {
        repository.toggleFavoriteStatus(bookId, result -> {
        });
    }

    /**
     * Faz a remoção do livro por ID
     */
    public void delete(int bookId) {
        repository.deleteBook(bookId, new Callback<Boolean>() {
            @Override
            public void onSuccess(Boolean result) {
                _bookDeleted.postValue(result);
            }
        });
    }
}