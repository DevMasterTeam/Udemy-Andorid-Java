package com.devmasterteam.mybooks.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.devmasterteam.mybooks.entity.BookEntity;
import com.devmasterteam.mybooks.repository.BookRepository;
import com.devmasterteam.mybooks.callback.Callback;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    // Acesso a dados
    private final BookRepository repository =
            BookRepository.getInstance(getApplication().getApplicationContext());

    // Livro que será carregado
    private final MutableLiveData<List<BookEntity>> _bookList = new MutableLiveData<>();
    public final LiveData<List<BookEntity>> bookList = _bookList;

    public HomeViewModel(@NonNull Application application) {
        super(application);

        // incializa os dados quando a viewModel é aberta (se não tiver dados)
        repository.getAllBooks(new Callback<>() {
            @Override
            public void onSuccess(List<BookEntity> result) {
                if (result.isEmpty()) {
                    repository.loadInitialData();
                }
            }

        });
    }

    /**
     * Busca todos os livros
     */
    public void getAll() {
        repository.getAllBooks(new Callback<>() {
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
                getAll();
            }
        });
    }
}