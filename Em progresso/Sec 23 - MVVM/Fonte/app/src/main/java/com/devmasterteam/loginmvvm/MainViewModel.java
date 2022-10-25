package com.devmasterteam.loginmvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    // Repositório - Lógica de login
    private PersonRepository mPersonRepository = new PersonRepository();

    // Variáveis mutáveis
    private MutableLiveData<String> mTextWelcome = new MutableLiveData<>();
    private MutableLiveData<String> mToastNotification = new MutableLiveData<>();

    public MainViewModel() {
        mTextWelcome.setValue("Bom dia!");
    }

    // Observáveis
    public LiveData<String> welcome() {
        return mTextWelcome;
    }

    // Observáveis
    public LiveData<String> toastNotification() {
        return mToastNotification;
    }

    public void doLogin(String email) {
        if (this.mPersonRepository.login(email)) {
            this.mToastNotification.setValue("Success");
        } else {
            this.mToastNotification.setValue("Falha");
        }
    }
}
