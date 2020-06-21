package com.example.alimentos.ui.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alimentos.services.listener.OnListClick;
import com.example.alimentos.R;
import com.example.alimentos.entities.FoodEntity;

/**
 * Responsável por fazer as manipulações de elementos de interface - RecyclerView
 */
public class FoodViewHolder extends RecyclerView.ViewHolder {

    // Elementos de interface
    private TextView mTextName;
    private TextView mTextCalories;
    private TextView mTextQuantity;
    private TextView mTextUnit;

    private Context mContext;

    /**
     * Construtor
     */
    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);

        this.mContext = itemView.getContext();

        // Mapeando os elementos de interface da linha
        this.mTextName = itemView.findViewById(R.id.text_name);
        this.mTextCalories = itemView.findViewById(R.id.text_calories);
        this.mTextQuantity = itemView.findViewById(R.id.text_quantity);
        this.mTextUnit = itemView.findViewById(R.id.text_unit);
    }

    /**
     * Atribui valores aos elementos
     */
    public void bind(final FoodEntity food, final OnListClick listener) {

        // Atribui os valores para os elementos de interface
        this.mTextName.setText(food.getName());

        String strCalories = String.format("%s %s", food.getCalories(), this.mContext.getString(R.string.calorias));
        this.mTextCalories.setText(strCalories);
        this.mTextQuantity.setText(String.valueOf(food.getQuantity()));
        this.mTextUnit.setText(food.getUnit());

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