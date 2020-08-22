package com.example.tasks.service.repository.local;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreferences
 */
public class SecurityPreferences {

    // Só é instanciado dentro da classe
    private SharedPreferences mSharedPreferences;

    public SecurityPreferences(Context context) {
        this.mSharedPreferences = context.getSharedPreferences("TasksShared", Context.MODE_PRIVATE);
    }

    /**
     * Salva um valor string baseado em uma chave
     */
    public void storeString(String key, String value) {
        this.mSharedPreferences.edit().putString(key, value).apply();
    }

    /**
     * Obtém o valor associado a chave
     */
    public String getStoredString(String key) {
        return this.mSharedPreferences.getString(key, "");
    }

    /**
     * Remove o valor associado a chave
     */
    public void remove(String key) {
        this.mSharedPreferences.edit().remove(key).apply();
    }

}
