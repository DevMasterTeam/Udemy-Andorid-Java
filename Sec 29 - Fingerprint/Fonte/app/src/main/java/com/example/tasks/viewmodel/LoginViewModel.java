package com.example.tasks.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tasks.service.helper.FingerprintHelper;
import com.example.tasks.service.listener.APIListener;
import com.example.tasks.service.listener.Feedback;
import com.example.tasks.service.model.PersonModel;
import com.example.tasks.service.model.PriorityModel;
import com.example.tasks.service.repository.PersonRepository;
import com.example.tasks.service.repository.PriorityRepository;

import java.util.List;

public class LoginViewModel extends AndroidViewModel {

    private PersonRepository mPersonRepository;
    private PriorityRepository mPriorityRepository;

    private MutableLiveData<Feedback> mLogin = new MutableLiveData<>();
    public LiveData<Feedback> login = this.mLogin;

    private MutableLiveData<Boolean> mFingerprint = new MutableLiveData<>();
    public LiveData<Boolean> fingerprint = this.mFingerprint;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        this.mPersonRepository = new PersonRepository(application);
        this.mPriorityRepository = new PriorityRepository(application);
    }

    public void login(final String email, String password) {
        this.mPersonRepository.login(email, password, new APIListener<PersonModel>() {
            @Override
            public void onSuccess(PersonModel result) {

                // Salvo os dados de login
                result.setEmail(email);
                mPersonRepository.saveUserData(result);

                // Informo sucesso
                mLogin.setValue(new Feedback());
            }

            @Override
            public void onFailure(String message) {
                mLogin.setValue(new Feedback(message));
            }
        });
    }

    public void isFingerprintAvailable() {
        PersonModel model = this.mPersonRepository.getUserData();
        boolean everLogged = !"".equals(model.getName());

        // Adiciona os headers
        this.mPersonRepository.saveUserData(model);

        if (FingerprintHelper.isAvailable(getApplication())) {
            this.mFingerprint.setValue(everLogged);
        }

        // Usuário não logado
        if (!everLogged) {
            this.mPriorityRepository.all(new APIListener<List<PriorityModel>>() {
                @Override
                public void onSuccess(List<PriorityModel> result) {
                    mPriorityRepository.save(result);
                }

                @Override
                public void onFailure(String message) {
                    // Erro silencioso
                }
            });
        }
    }

}
