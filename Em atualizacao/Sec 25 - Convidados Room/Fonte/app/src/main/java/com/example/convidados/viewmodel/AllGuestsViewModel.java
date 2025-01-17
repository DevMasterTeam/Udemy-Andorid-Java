package com.example.convidados.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.convidados.constants.GuestConstants;
import com.example.convidados.model.Feedback;
import com.example.convidados.model.GuestModel;
import com.example.convidados.repository.GuestRepository;

import java.util.List;

public class AllGuestsViewModel extends AndroidViewModel {

    private GuestRepository mRepository;

    private MutableLiveData<List<GuestModel>> mGuestList = new MutableLiveData<>();
    public LiveData<List<GuestModel>> guestList = this.mGuestList;

    private MutableLiveData<Feedback> mFeedback = new MutableLiveData<>();
    public LiveData<Feedback> feedback = this.mFeedback;

    public AllGuestsViewModel(@NonNull Application application) {
        super(application);
        this.mRepository = new GuestRepository(application.getApplicationContext());
    }

    public void getList(int filter) {
        if (filter == GuestConstants.CONFIRMATION.NOT_CONFIRMED) {
            this.mGuestList.setValue(this.mRepository.getAll());
        } else if (filter == GuestConstants.CONFIRMATION.PRESENT) {
            this.mGuestList.setValue(this.mRepository.getPresents());
        } else if (filter == GuestConstants.CONFIRMATION.ABSENT) {
            this.mGuestList.setValue(this.mRepository.getAbsents());
        }
    }

    public void delete(int id) {
        if (this.mRepository.delete(id)) {
            this.mFeedback.setValue(new Feedback("Convidado removido com sucesso"));
        } else {
            this.mFeedback.setValue(new Feedback("Erro inesperado", false));
        }
    }

}