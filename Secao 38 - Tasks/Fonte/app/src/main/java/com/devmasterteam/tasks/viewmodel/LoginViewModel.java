package com.devmasterteam.tasks.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.devmasterteam.tasks.service.listener.ApiListener;
import com.devmasterteam.tasks.service.listener.Feedback;
import com.devmasterteam.tasks.service.model.PersonModel;
import com.devmasterteam.tasks.service.model.PriorityModel;
import com.devmasterteam.tasks.service.repository.PersonRepository;
import com.devmasterteam.tasks.service.repository.PriorityRepository;

import java.util.List;

public class LoginViewModel extends AndroidViewModel {

    private final PersonRepository personRepository;
    private final PriorityRepository priorityRepository;

    private final MutableLiveData<Feedback> _login = new MutableLiveData<>();
    public LiveData<Feedback> login = _login;

    private final MutableLiveData<Boolean> _userLogged = new MutableLiveData<>();
    public LiveData<Boolean> userLogged = _userLogged;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        personRepository = new PersonRepository(application);
        priorityRepository = new PriorityRepository(application);
    }

    public void login(final String email, String password) {
        personRepository.login(email, password, new ApiListener<PersonModel>() {
            @Override
            public void onSuccess(PersonModel result) {

                // Salvo os dados de login
                result.setEmail(email);
                personRepository.saveUserData(result);

                // Informo sucesso
                _login.setValue(new Feedback());
            }

            @Override
            public void onFailure(String message) {
                _login.setValue(new Feedback(message));
            }
        });
    }

    public void verifyUserLogged() {
        PersonModel model = personRepository.getUserData();
        boolean logged = !"".equals(model.getName());

        // Adiciona os headers
        personRepository.saveUserData(model);

        // Usuário não logado
        if (!logged) {
            priorityRepository.all(new ApiListener<List<PriorityModel>>() {
                @Override
                public void onSuccess(List<PriorityModel> result) {
                    priorityRepository.save(result);
                }

                @Override
                public void onFailure(String message) {
                    // Erro silencioso
                }
            });
        }

        _userLogged.setValue(logged);
    }

}