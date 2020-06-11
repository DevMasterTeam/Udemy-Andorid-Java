package com.example.alimentos.business;

import com.example.alimentos.entity.FoodEntity;
import com.example.alimentos.repository.FoodRepository;

import java.util.List;

/**
 * Classe de negócios
 */
public class FoodBusiness {

    /**
     * Retorna alimento específico
     */
    public FoodEntity get(int id) {
        return new FoodRepository().get(id);
    }

    /**
     * Retorna lista de alimentos
     */
    public List<FoodEntity> getList() {
        return new FoodRepository().getList();
    }

}
