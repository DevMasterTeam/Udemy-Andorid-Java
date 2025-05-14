package com.devmasterteam.tasks.service.repository;

import android.content.Context;

import com.devmasterteam.tasks.service.constants.TaskConstants;
import com.devmasterteam.tasks.service.listener.ApiListener;
import com.devmasterteam.tasks.service.model.PersonModel;
import com.devmasterteam.tasks.service.repository.local.SecurityPreferences;
import com.devmasterteam.tasks.service.repository.remote.PersonService;
import com.devmasterteam.tasks.service.repository.remote.RetrofitClient;

import retrofit2.Call;

public class PersonRepository extends BaseRepository {

    private final PersonService personService;
    private final SecurityPreferences securityPreferences;

    public PersonRepository(Context context) {
        super(context);
        this.context = context;
        personService = RetrofitClient.createService(PersonService.class);
        securityPreferences = new SecurityPreferences(context);
    }

    public void create(String name, String email, String password, final ApiListener<PersonModel> listener) {
        Call<PersonModel> call = this.personService.create(name, email, password, true);
        super.execute(call, listener);
    }

    public void login(String email, String password, final ApiListener<PersonModel> listener) {
        Call<PersonModel> call = personService.login(email, password);
        super.execute(call, listener);
    }

    public void saveUserData(PersonModel model) {
        securityPreferences.storeString(TaskConstants.SHARED.TOKEN_KEY, model.getToken());
        securityPreferences.storeString(TaskConstants.SHARED.PERSON_KEY, model.getPersonKey());
        securityPreferences.storeString(TaskConstants.SHARED.PERSON_NAME, model.getName());
        securityPreferences.storeString(TaskConstants.SHARED.PERSON_EMAIL, model.getEmail());

        RetrofitClient.saveHeaders(model.getToken(), model.getPersonKey());
    }

    public void clearUserDate() {
        securityPreferences.remove(TaskConstants.SHARED.TOKEN_KEY);
        securityPreferences.remove(TaskConstants.SHARED.PERSON_KEY);
        securityPreferences.remove(TaskConstants.SHARED.PERSON_NAME);
    }

    public PersonModel getUserData() {
        PersonModel model = new PersonModel();
        model.setName(securityPreferences.getStoredString(TaskConstants.SHARED.PERSON_NAME));
        model.setToken(securityPreferences.getStoredString(TaskConstants.SHARED.TOKEN_KEY));
        model.setPersonKey(securityPreferences.getStoredString(TaskConstants.SHARED.PERSON_KEY));
        model.setEmail(securityPreferences.getStoredString(TaskConstants.SHARED.PERSON_EMAIL));

        return model;
    }
}