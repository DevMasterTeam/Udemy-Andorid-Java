package com.example.convidados.repository;

import android.content.Context;

import com.example.convidados.constants.GuestConstants;
import com.example.convidados.model.GuestModel;

import java.util.List;

public class GuestRepository {

    private GuestDAO mGuestDAO;

    public GuestRepository(Context context) {
        GuestDataBase db = GuestDataBase.getDatabase(context);
        this.mGuestDAO = db.guestDAO();
    }

    public List<GuestModel> getAll() {
        return this.mGuestDAO.getAll();
    }

    public List<GuestModel> getPresents() {
        return this.mGuestDAO.getListByPresence(GuestConstants.CONFIRMATION.PRESENT);
    }

    public List<GuestModel> getAbsents() {
        return this.mGuestDAO.getListByPresence(GuestConstants.CONFIRMATION.ABSENT);
    }

    public GuestModel load(int id) {
        return this.mGuestDAO.load(id);
    }

    public boolean insert(GuestModel guest) {
        return this.mGuestDAO.insert(guest) > 0;
    }

    public boolean update(GuestModel guest) {
        return this.mGuestDAO.update(guest) > 0;
    }

    public boolean delete(int id) {
        GuestModel guestModel = this.load(id);
        return this.mGuestDAO.delete(guestModel) > 0;
    }

}