package com.devmasterteam.mybooks.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.devmasterteam.mybooks.R;
import com.devmasterteam.mybooks.databinding.FragmentDetailsBinding;
import com.devmasterteam.mybooks.entity.BookEntity;
import com.devmasterteam.mybooks.helper.BookConstants;
import com.devmasterteam.mybooks.viewmodel.DetailsViewModel;

public class DetailsFragment extends Fragment implements View.OnClickListener {

    private FragmentDetailsBinding binding;

    private DetailsViewModel viewModel;

    // ID de referência do livro em questão
    private int bookId = 0;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle b) {
        viewModel = new ViewModelProvider(this).get(DetailsViewModel.class);
        binding = FragmentDetailsBinding.inflate(inflater, container, false);

        // Busca ID recebido por Bundle e carrega informações
        bookId = getArguments() != null ? getArguments().getInt(BookConstants.BOOK_ID) : 0;
        viewModel.getBook(bookId);

        // Atribui os eventos
        setListeners();

        // Cria os observadores
        setObservers();

        // Retorna elemento raiz
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    /**
     * Eventos de click
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_delete) {
            handleBookRemoval();
        } else if (v.getId() == R.id.imageview_back) {
            requireActivity().getSupportFragmentManager().popBackStack();
        } else if (v.getId() == R.id.checkbox_favorite) {
            handleToggleFavorite();
        }
    }

    /**
     * Atribui os eventos
     */
    private void setListeners() {
        binding.buttonDelete.setOnClickListener(this);
        binding.imageviewBack.setOnClickListener(this);
        binding.checkboxFavorite.setOnClickListener(this);
    }

    /**
     * Cria os observadores
     */
    private void setObservers() {
        viewModel.book.observe(getViewLifecycleOwner(), new Observer<>() {
            @Override
            public void onChanged(BookEntity book) {
                binding.textviewTitle.setText(book.getTitle());
                binding.textviewAuthorValue.setText(book.getAuthor());
                binding.textviewGenreValue.setText(book.getGenre());
                binding.checkboxFavorite.setChecked(book.isFavorite());

                setGenreBackgroundColor(book.getGenre());
            }
        });

        viewModel.bookDeleted.observe(getViewLifecycleOwner(), new Observer<>() {
            @Override
            public void onChanged(Boolean isDeleted) {
                // Notifica usuário
                Toast.makeText(getContext(), getString(R.string.msg_removed_successfully), Toast.LENGTH_SHORT).show();

                // Volta para a Fragment anterior
                requireActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }

    /**
     * Exibe um diálogo de confirmação para a remoção de um livro.
     * Se o usuário confirmar, o livro será removido.
     */
    private void handleBookRemoval() {
        Context context = getContext();
        if (context != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage(getString(R.string.dialog_message_delete_item))
                    .setPositiveButton(getString(R.string.dialog_positive_button_yes), (dialog, id) -> {
                        viewModel.delete(bookId);
                    })
                    .setNegativeButton(getString(R.string.dialog_negative_button_no), (dialog, id) -> {
                        dialog.dismiss();
                    });
            builder.create().show();
        }
    }

    /**
     * Alterna o status de favorito de um livro.
     * Se o livro for marcado como favorito, ele será desmarcado e vice-versa.
     */
    private void handleToggleFavorite() {
        viewModel.favorite(bookId);
    }

    /**
     * Define a cor de fundo do texto que representa o gênero do livro.
     * A cor é atribuída com base no tipo de gênero do livro.
     * - Para o gênero "Terror", a cor de fundo será vermelha.
     * - Para o gênero "Fantasia", será usado um gradiente de fundo específico.
     * - Para outros gêneros, a cor de fundo será teal (verde escuro).
     */
    private void setGenreBackgroundColor(String genre) {
        if ("Terror".equals(genre)) {
            binding.textviewGenreValue.setBackgroundResource(R.drawable.rounded_label_red);
        } else if ("Fantasia".equals(genre)) {
            binding.textviewGenreValue.setBackgroundResource(R.drawable.rounded_label_fantasy);
        } else {
            binding.textviewGenreValue.setBackgroundResource(R.drawable.rounded_label_teal);
        }
    }

}