package com.devmasterteam.mybooks.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.devmasterteam.mybooks.R;
import com.devmasterteam.mybooks.databinding.FragmentFavoriteBinding;
import com.devmasterteam.mybooks.helper.BookConstants;
import com.devmasterteam.mybooks.ui.adapter.BookAdapter;
import com.devmasterteam.mybooks.ui.listener.BookListener;
import com.devmasterteam.mybooks.viewmodel.FavoriteViewModel;

public class FavoriteFragment extends Fragment {

    private FragmentFavoriteBinding binding;
    private FavoriteViewModel viewModel;
    private final BookAdapter adapter = new BookAdapter();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle b) {
        viewModel = new ViewModelProvider(this).get(FavoriteViewModel.class);
        binding = FragmentFavoriteBinding.inflate(inflater, container, false);

        // Atribui um layout que diz como a RecyclerView se comporta
        binding.recyclerFavoriteBooks.setLayoutManager(new LinearLayoutManager(getContext()));

        // Define um adapter - Faz a ligação da RecyclerView com a listagem de itens
        binding.recyclerFavoriteBooks.setAdapter(adapter);

        // Atribui implementação de listener
        attachBookListener();

        // Cria os observadores
        setObservers();

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.getFavoriteBooks();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    /**
     * Associa o listener de eventos de clique ao adapter de livros.
     * O listener captura os cliques no título do livro para navegar até a tela de detalhes e o
     * clique no ícone de favorito para alternar o status de favorito do livro.
     */
    private void attachBookListener() {
        adapter.attachListener(new BookListener() {
            @Override
            public void onClick(int id) {
                // Passando a informação do livro para a Fragment
                Bundle bundle = new Bundle();
                bundle.putInt(BookConstants.BOOK_ID, id);

                // Inicializa fragment de detalhes
                NavHostFragment.findNavController(FavoriteFragment.this)
                        .navigate(R.id.navigation_book_details, bundle);
            }

            @Override
            public void onFavoriteClick(int id) {
                viewModel.favorite(id);
            }
        });
    }

    /**
     * Cria os observadores
     */
    private void setObservers() {
        viewModel.bookList.observe(getViewLifecycleOwner(), books -> {
            showNoBooksViews(books.isEmpty());
            adapter.updateBooks(books);
        });
    }

    /**
     * Controla a visibilidade dos elementos da UI relacionados a livros favoritos.
     * Exibe ou oculta a mensagem e imagem de "sem livros" e a RecyclerView de livros favoritos,
     * com base no valor de "show".
     */
    private void showNoBooksViews(boolean show) {
        binding.textviewNoBooks.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
        binding.imageviewNoBooks.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
        binding.recyclerFavoriteBooks.setVisibility(show ? View.INVISIBLE : View.VISIBLE);
    }
}