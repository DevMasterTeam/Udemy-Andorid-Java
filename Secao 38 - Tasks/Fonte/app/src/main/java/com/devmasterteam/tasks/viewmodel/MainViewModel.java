package com.devmasterteam.tasks.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.devmasterteam.tasks.service.model.PersonModel;
import com.devmasterteam.tasks.service.repository.PersonRepository;

public class MainViewModel extends AndroidViewModel {

    private final PersonRepository personRepository;

    private final MutableLiveData<PersonModel> _userData = new MutableLiveData<>();
    public LiveData<PersonModel> userData = _userData;

    public MainViewModel(@NonNull Application application) {
        super(application);
        personRepository = new PersonRepository(application);
    }

    public void logout() {
        personRepository.clearUserDate();
    }

    public void loadUserData() {
        _userData.setValue(personRepository.getUserData());
    }

}
