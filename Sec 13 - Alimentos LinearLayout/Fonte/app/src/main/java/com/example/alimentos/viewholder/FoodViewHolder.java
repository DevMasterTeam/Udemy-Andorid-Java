package com.example.alimentos.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alimentos.listener.OnListClick;
import com.example.alimentos.R;
import com.example.alimentos.entity.FoodEntity;

/**
 * Responsável por fazer as manipulações de elementos de interface - RecyclerView
 */
public class FoodViewHolder extends RecyclerView.ViewHolder {

    // Elementos de interface
    private TextView mTextName;
    private TextView mTextCalories;

    /**
     * Construtor
     */
    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);

        // Mapeando os elementos de interface da linha
        this.mTextName = itemView.findViewById(R.id.text_name);
        this.mTextCalories = itemView.findViewById(R.id.text_calories);
    }

    /**
     * Atribui valores aos elementos
     */
    public void bind(final FoodEntity food, final OnListClick listener) {

        // Atribui os valores para os elementos de interface
        this.mTextName.setText(food.getName());
        this.mTextCalories.setText(String.valueOf(food.getCalories()));

        // Toda a linha recebe o evento de click
        this.mTextName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Invoca o método implementado na MainActivity
                listener.onClick(food.getId());
            }
        });
    }
}