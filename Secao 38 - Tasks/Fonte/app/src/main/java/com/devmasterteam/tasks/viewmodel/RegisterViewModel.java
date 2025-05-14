package com.devmasterteam.tasks.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.devmasterteam.tasks.service.listener.ApiListener;
import com.devmasterteam.tasks.service.listener.Feedback;
import com.devmasterteam.tasks.service.model.PersonModel;
import com.devmasterteam.tasks.service.repository.PersonRepository;

public class RegisterViewModel extends AndroidViewModel {

    private final PersonRepository personRepository;

    private final MutableLiveData<Feedback> _create = new MutableLiveData<>();
    public LiveData<Feedback> create = _create;

    public RegisterViewModel(@NonNull Application application) {
        super(application);
        personRepository = new PersonRepository(application);
    }

    public void create(String name, final String email, String password) {
        personRepository.create(name, email, password, new ApiListener<PersonModel>() {
            @Override
            public void onSuccess(PersonModel result) {

                result.setEmail(email);
                personRepository.saveUserData(result);
                _create.setValue(new Feedback());
            }

            @Override
            public void onFailure(String message) {
                _create.setValue(new Feedback(message));
            }
        });
    }

}