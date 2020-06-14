package com.example.alimentos.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.alimentos.R;
import com.example.alimentos.services.business.FoodBusiness;
import com.example.alimentos.services.constants.FoodConstants;
import com.example.alimentos.entities.FoodEntity;

public class DetailsActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Verifica se a tela possui action bar
        if (getSupportActionBar() != null) {
            // Adiciona uma seta na action bar
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // Elementos de interface
        this.mViewHolder.mTextName = findViewById(R.id.text_name);
        this.mViewHolder.mTextCalories = findViewById(R.id.text_calories);
        this.mViewHolder.mTextQuantity = findViewById(R.id.text_quantity);
        this.mViewHolder.mTextUnit = findViewById(R.id.text_unit);
        this.mViewHolder.mTextDescription = findViewById(R.id.text_description);

        // Obtém o valor passado por parâmetro via Intent
        this.getData();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Click no ícone de voltar
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Obtém o valor passado por parâmetro
     */
    private void getData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            /// Obtém ID passado por parâmetro e busca detalhes do alimento
            int id = bundle.getInt(FoodConstants.FOOD_ID);
            FoodEntity food = new FoodBusiness().get(id);

            // Preenche os dados para visualização
            this.mViewHolder.mTextName.setText(food.getName());
            this.mViewHolder.mTextQuantity.setText(String.valueOf(food.getQuantity()));
            this.mViewHolder.mTextUnit.setText(food.getUnit());

            String strCalories = String.format("%s %s", food.getCalories(), this.getString(R.string.calorias));
            this.mViewHolder.mTextCalories.setText(strCalories);

            // Faz a validação se existe alguma informação extra
            if (!"".equals(food.getDescription())) {
                this.mViewHolder.mTextDescription.setText(food.getDescription());
            }
        }
    }

    /**
     * ViewHolder
     */
    private static class ViewHolder {
        TextView mTextName;
        TextView mTextCalories;
        TextView mTextQuantity;
        TextView mTextUnit;
        TextView mTextDescription;
    }
}