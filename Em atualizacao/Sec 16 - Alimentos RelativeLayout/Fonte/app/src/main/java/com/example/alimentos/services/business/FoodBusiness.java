package com.example.alimentos.services.business;

import com.example.alimentos.services.constants.FoodConstants;
import com.example.alimentos.entities.FoodEntity;
import com.example.alimentos.services.repository.FoodRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de negócios
 */
public class FoodBusiness {

    // Variáveis usadas no escopo da classe
    private FoodRepository mFoodRepository = new FoodRepository();

    /**
     * Retorna alimento específico
     */
    public FoodEntity get(int id) {
        return this.mFoodRepository.get(id);
    }

    /**
     * Retorna lista de alimentos
     */
    public List<FoodEntity> getList(int filter) {

        List<FoodEntity> list = this.mFoodRepository.getList();

        // Nenhum fltro aplicado, retorna lista completa
        if (filter == FoodConstants.FILTER.NO_FILTER) {
            return list;
        }

        // Lista vazia - Adiciona itens que correspondem ao filtro
        List<FoodEntity> filtered = new ArrayList<>();
        for (FoodEntity f : list) {
            if (filter == FoodConstants.FILTER.CAL_LOW) {
                if (f.getCalories() <= 99) {
                    filtered.add(f);
                }
            } else if (filter == FoodConstants.FILTER.CAL_MEDIUM) {
                if (f.getCalories() >= 100 && f.getCalories() <= 199) {
                    filtered.add(f);
                }
            } else if (filter == FoodConstants.FILTER.CAL_HIGH) {
                if (f.getCalories() >= 200) {
                    filtered.add(f);
                }
            }
        }

        // Retorna lista filtrada
        return filtered;
    }

}
