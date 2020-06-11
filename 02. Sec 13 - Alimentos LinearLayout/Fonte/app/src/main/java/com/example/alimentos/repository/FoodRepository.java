package com.example.alimentos.repository;

import com.example.alimentos.entity.FoodEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de dados
 */
public class FoodRepository {

    // Lista de alimentos - Funciona como se fosse um banco de dados
    private List<FoodEntity> mListFood;

    /**
     * Construtor
     */
    public FoodRepository() {
        this.mListFood = new ArrayList<>();

        // Adiciona items
        this.mListFood.add(new FoodEntity(0, "Alface crespa", 8));
        this.mListFood.add(new FoodEntity(1, "Azeite", 90));
        this.mListFood.add(new FoodEntity(2, "Batata doce", 115));
        this.mListFood.add(new FoodEntity(3, "Ervilhas cruas", 81));
        this.mListFood.add(new FoodEntity(4, "Feijão carioca", 77));
        this.mListFood.add(new FoodEntity(5, "Filé de frango frito", 240));
        this.mListFood.add(new FoodEntity(6, "Grão de bico", 720));
        this.mListFood.add(new FoodEntity(7, "Macarrão cozido", 221));
        this.mListFood.add(new FoodEntity(8, "Pão de forma 12 grãos", 110));
        this.mListFood.add(new FoodEntity(9, "Queijo parmesão", 18));
        this.mListFood.add(new FoodEntity(10, "Rúcula", 5));
        this.mListFood.add(new FoodEntity(11, "Vagem cozida", 44));
        this.mListFood.add(new FoodEntity(12, "Vodka", 231));
        this.mListFood.add(new FoodEntity(13, "Whiskey", 58));
    }

    /**
     * Retorna alimento específico
     */
    public FoodEntity get(int id) {
        return this.mListFood.get(id);
    }

    /**
     * Retorna lista de alimentos
     */
    public List<FoodEntity> getList() {
        return this.mListFood;
    }

}