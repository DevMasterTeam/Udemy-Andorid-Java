package com.devmasterteam.modelviewviewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    // Variáveis mutáveis
    private final MutableLiveData<String> textWelcome = new MutableLiveData<>();
    private final MutableLiveData<String> loginMessage = new MutableLiveData<>();

    // Construtor
    public MainViewModel() {
        textWelcome.setValue("Bom dia!");
    }

    // Observável
    public LiveData<String> welcome() {
        return textWelcome;
    }

    // Observável
    public LiveData<String> loginMessage() {
        return loginMessage;
    }

    // Lógica de login
    public void login(String text) {
        if (text.isEmpty()) {
            loginMessage.setValue("Preencha seus dados.");
        } else {
            loginMessage.setValue("Login feito com sucesso.");
        }
    }

}
