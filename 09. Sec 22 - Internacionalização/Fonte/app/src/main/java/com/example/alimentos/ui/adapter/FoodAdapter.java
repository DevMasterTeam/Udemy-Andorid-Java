package com.example.alimentos.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alimentos.services.listener.OnListClick;
import com.example.alimentos.R;
import com.example.alimentos.entities.FoodEntity;
import com.example.alimentos.ui.viewholder.FoodViewHolder;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodViewHolder> {

    // Variáveis - Escopo da classe
    private List<FoodEntity> mList;
    private OnListClick mListClick;

    /**
     * Construtor
     */
    public FoodAdapter(List<FoodEntity> list, OnListClick listener) {
        this.mList = list;
        this.mListClick = listener;
    }

    /**
     * Responsável pela criação de linha
     */
    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Obtém o contexto
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Instancia o layout para manipulação dos elementos
        View view = inflater.inflate(R.layout.item_food, parent, false);

        // Retorna a Viewholder com a View inicializada
        return new FoodViewHolder(view);
    }

    /**
     * Responsável por atribuir valores após linha criada
     */
    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        FoodEntity foodEntity = this.mList.get(position);
        holder.bind(foodEntity, this.mListClick);
    }

    @Override
    public int getItemCount() {
        // Qual o tamanho da lista que a RecyclerView vai trabalhar
        return this.mList.size();
    }

}
