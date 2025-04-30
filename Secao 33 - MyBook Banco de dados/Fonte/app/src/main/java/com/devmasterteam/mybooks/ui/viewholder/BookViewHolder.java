package com.devmasterteam.mybooks.ui.viewholder;

import androidx.recyclerview.widget.RecyclerView;

import com.devmasterteam.mybooks.R;
import com.devmasterteam.mybooks.databinding.ItemBookBinding;
import com.devmasterteam.mybooks.entity.BookEntity;
import com.devmasterteam.mybooks.ui.listener.BookListener;

public class BookViewHolder extends RecyclerView.ViewHolder {

    private final ItemBookBinding item;
    private final BookListener listener;

    public BookViewHolder(ItemBookBinding item, BookListener listener) {
        super(item.getRoot());
        this.item = item;
        this.listener = listener;
    }

    /**
     * Faz a atribuição dos valores para os elementos de layout
     * */
    public void bind(BookEntity book) {
        item.textviewTitle.setText(book.getTitle());
        item.textviewAuthor.setText(book.getAuthor());
        item.textviewGenre.setText(book.getGenre());

        // Tratamento para categoria específica
        setGenreBackgroundColor(book.getGenre());

        // Tratamento para imagem de favorito
        updateFavoriteIcon(book.isFavorite());

        // Evento de click para detalhes
        item.textviewTitle.setOnClickListener(v -> listener.onClick(book.getId()));
        item.textviewAuthor.setOnClickListener(v -> listener.onClick(book.getId()));

        // Evento de favoritar
        item.imageviewFavorite.setOnClickListener(v -> listener.onFavoriteClick(book.getId()));
    }

    /**
     * Tratamento para imagem de favorito.
     */
    private void updateFavoriteIcon(boolean favorite) {
        int favoriteIcon = favorite ? R.drawable.ic_favorite : R.drawable.ic_favorite_empty;
        item.imageviewFavorite.setImageResource(favoriteIcon);
    }

    /**
     * Define a cor de fundo do texto que representa o gênero do livro.
     * A cor é atribuída com base no tipo de gênero do livro.
     * - Para o gênero "Terror", a cor de fundo será vermelha.
     * - Para o gênero "Fantasia", será usado um gradiente de fundo específico.
     * - Para outros gêneros, a cor de fundo será teal (verde/azul).
     */
    private void setGenreBackgroundColor(String genre) {
        if ("Terror".equals(genre)) {
            item.textviewGenre.setBackgroundResource(R.drawable.rounded_label_red);
        } else if ("Fantasia".equals(genre)) {
            item.textviewGenre.setBackgroundResource(R.drawable.rounded_label_fantasy);
        } else {
            item.textviewGenre.setBackgroundResource(R.drawable.rounded_label_teal);
        }
    }
}