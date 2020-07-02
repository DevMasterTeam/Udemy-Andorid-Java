package com.example.alimentos.entity;

/**
 * Entidade de dados - Food
 */
public class FoodEntity {

    // Variáveis privadas
    private int id;
    private String name;
    private int calories;

    /**
     * Construtor
     */
    public FoodEntity(int id, String name, int calories) {
        this.id = id;
        this.name = name;
        this.calories = calories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
