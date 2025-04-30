package com.devmasterteam.mybooks.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devmasterteam.mybooks.databinding.ItemBookBinding;
import com.devmasterteam.mybooks.entity.BookEntity;
import com.devmasterteam.mybooks.ui.listener.BookListener;
import com.devmasterteam.mybooks.ui.viewholder.BookViewHolder;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookViewHolder> {

    // Lista de livros
    private List<BookEntity> bookList = new ArrayList<>();
    private BookListener bookListener;

    /**
     * Cria e retorna um novo ViewHolder para o item do RecyclerView.
     * Este método é chamado quando o RecyclerView precisa criar um novo item para ser exibido.
     */
    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla o layout do item do RecyclerView
        ItemBookBinding view = ItemBookBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new BookViewHolder(view, bookListener);
    }

    /**
     * Este método é chamado para determinar quantos itens existem no RecyclerView.
     * Ele retorna o tamanho da lista de livros que será exibida.
     */
    @Override
    public int getItemCount() {
        return bookList.size();
    }

    /**
     * Vincula os dados do livro ao ViewHolder correspondente.
     */
    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        holder.bind(bookList.get(position));
    }

    /**
     * Atualização da lista de livros.
     */
    public void updateBooks(List<BookEntity> list) {
        bookList = list;
        notifyDataSetChanged();
    }

    /**
     * Eventos na listagem.
     */
    public void attachListener(BookListener listener) {
        this.bookListener = listener;
    }
}