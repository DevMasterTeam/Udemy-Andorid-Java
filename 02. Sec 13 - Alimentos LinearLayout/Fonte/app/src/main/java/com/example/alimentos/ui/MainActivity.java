package com.example.alimentos.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.alimentos.listener.OnListClick;
import com.example.alimentos.adapter.FoodAdapter;
import com.example.alimentos.business.FoodBusiness;
import com.example.alimentos.constants.FoodConstants;
import com.example.alimentos.entity.FoodEntity;
import com.example.alimentos.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lista de alimentos
        List<FoodEntity> list = new FoodBusiness().getList();

        // 1 - Obter a recycler view
        this.mViewHolder.mRecyclerFood = findViewById(R.id.recycler_food);

        // Implementa o evento de click para passar por parâmetro para a ViewHolder
        OnListClick foodListener = new OnListClick() {
            @Override
            public void onClick(int id) {
                Bundle bundle = new Bundle();
                bundle.putInt(FoodConstants.FOOD_ID, id);

                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        };

        // 2 - Definir um adapter
        FoodAdapter adapter = new FoodAdapter(list, foodListener);
        this.mViewHolder.mRecyclerFood.setAdapter(adapter);

        // 3 definir um layout
        this.mViewHolder.mRecyclerFood.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     * ViewHolder
     */
    private static class ViewHolder {
        RecyclerView mRecyclerFood;
    }
}