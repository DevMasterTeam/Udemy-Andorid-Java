package com.devmasterteam.tasks.service.repository.local;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreferences
 */
public class SecurityPreferences {

    // Só é instanciado dentro da classe
    private final SharedPreferences sharedPreferences;

    public SecurityPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences("TasksShared", Context.MODE_PRIVATE);
    }

    /**
     * Salva um valor string baseado em uma chave
     */
    public void storeString(String key, String value) {
        sharedPreferences.edit().putString(key, value).apply();
    }

    /**
     * Obtém o valor associado a chave
     */
    public String getStoredString(String key) {
        return sharedPreferences.getString(key, "");
    }

    /**
     * Remove o valor associado a chave
     */
    public void remove(String key) {
        sharedPreferences.edit().remove(key).apply();
    }

}