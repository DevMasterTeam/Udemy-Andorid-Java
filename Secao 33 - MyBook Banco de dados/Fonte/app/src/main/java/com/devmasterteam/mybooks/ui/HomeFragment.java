package com.devmasterteam.mybooks.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.devmasterteam.mybooks.R;
import com.devmasterteam.mybooks.databinding.FragmentHomeBinding;
import com.devmasterteam.mybooks.entity.BookEntity;
import com.devmasterteam.mybooks.helper.BookConstants;
import com.devmasterteam.mybooks.ui.adapter.BookAdapter;
import com.devmasterteam.mybooks.ui.listener.BookListener;
import com.devmasterteam.mybooks.viewmodel.HomeViewModel;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel viewModel;
    private final BookAdapter adapter = new BookAdapter();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle b) {
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        // Atribui um layout que diz como a RecyclerView se comporta
        binding.recyclerBooks.setLayoutManager(new LinearLayoutManager(getContext()));

        // Define um adapter - Faz a ligação da RecyclerView com a listagem de itens
        binding.recyclerBooks.setAdapter(adapter);

        // Atribui implementação de listener
        attachBookListener();

        // Cria os observadores
        observe();

        // Retorna elemento raiz
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.getAll();
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
                NavHostFragment.findNavController(HomeFragment.this)
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
    private void observe() {
        viewModel.bookList.observe(getViewLifecycleOwner(), new Observer<>() {
            @Override
            public void onChanged(List<BookEntity> books) {
                adapter.updateBooks(books);
            }
        });
    }
}