package com.example.convidados.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.convidados.constants.DataBaseConstants;
import com.example.convidados.constants.GuestConstants;
import com.example.convidados.model.GuestModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Persistência de dados de convidados
 */
public class GuestRepository {

    // Instãncia única da classe
    private static GuestRepository INSTANCE;

    // Acesso ao banco de dados
    private GuestDataBaseHelper mHelper;

    /**
     * Construtos
     */
    private GuestRepository(Context context) {
        this.mHelper = new GuestDataBaseHelper(context);
    }

    /**
     * Singleton
     */
    public static GuestRepository getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new GuestRepository(context);
        }
        return INSTANCE;
    }

    /**
     * Faz a listagem de todos os convidados
     */
    private List<GuestModel> getList(String selection, String[] selectionArgs) {
        List<GuestModel> list = new ArrayList<>();
        try {
            SQLiteDatabase db = this.mHelper.getReadableDatabase();

            String table = DataBaseConstants.GUEST.TABLE_NAME;

            // Colunas que serão retornadas
            String[] columns = {DataBaseConstants.GUEST.COLUMNS.ID,
                    DataBaseConstants.GUEST.COLUMNS.NAME,
                    DataBaseConstants.GUEST.COLUMNS.PRESENCE};

            // Faz a seleção
            Cursor cursor = db.query(table, columns, selection, selectionArgs, null, null, null);
            if (cursor != null && cursor.getCount() > 0) {
                while (cursor.moveToNext()) {

                    int id = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.ID));
                    String name = cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME));
                    int presence = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE));

                    list.add(new GuestModel(id, name, presence));
                }
            }

            // Fecha cursor
            if (cursor != null) {
                cursor.close();
            }

            // Retorna listagem
            return list;
        } catch (Exception e) {
            return list;
        }
    }

    public List<GuestModel> getAll() {
        return this.getList(null, null);
    }

    /**
     * Faz a listagem de todos os convidados confirmados
     */
    public List<GuestModel> getPresents() {
        String selection = DataBaseConstants.GUEST.COLUMNS.PRESENCE + " = ?";
        String[] selectionArgs = {String.valueOf(GuestConstants.CONFIRMATION.PRESENT)};

        return this.getList(selection, selectionArgs);
    }

    /**
     * Faz a listagem de todos os convidados ausentes
     */
    public List<GuestModel> getAbsents() {
        String selection = DataBaseConstants.GUEST.COLUMNS.PRESENCE + " = ?";
        String[] selectionArgs = {String.valueOf(GuestConstants.CONFIRMATION.ABSENT)};

        return this.getList(selection, selectionArgs);
    }

    /**
     * Carrega convidado
     */
    public GuestModel load(int id) {
        try {
            GuestModel guest = null;
            SQLiteDatabase db = this.mHelper.getReadableDatabase();

            String table = DataBaseConstants.GUEST.TABLE_NAME;

            // Colunas que serão retornadas
            String[] columns = {DataBaseConstants.GUEST.COLUMNS.ID,
                    DataBaseConstants.GUEST.COLUMNS.NAME,
                    DataBaseConstants.GUEST.COLUMNS.PRESENCE};

            String selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?";
            String[] selectionArgs = {String.valueOf(id)};

            Cursor cursor = db.query(table, columns, selection, selectionArgs, null, null, null);
            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();

                String name = cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME));
                int presence = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE));

                guest = new GuestModel(id, name, presence);
            }

            if (cursor != null) {
                cursor.close();
            }

            return guest;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Insere convidado
     */
    public boolean insert(GuestModel guest) {
        try {
            SQLiteDatabase db = this.mHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.getName());
            values.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guest.getConfirmation());

            db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, values);
            db.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Atualiza convidado
     */
    public boolean update(GuestModel guest) {
        try {
            SQLiteDatabase db = this.mHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.getName());
            values.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guest.getConfirmation());

            String where = DataBaseConstants.GUEST.COLUMNS.ID + " = ?";
            String[] args = {String.valueOf(guest.getId())};

            db.update(DataBaseConstants.GUEST.TABLE_NAME, values, where, args);
            db.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Remove convidado
     */
    public boolean delete(int id) {
        try {
            SQLiteDatabase db = this.mHelper.getWritableDatabase();

            String where = DataBaseConstants.GUEST.COLUMNS.ID + " = ?";
            String[] args = {String.valueOf(id)};

            db.delete(DataBaseConstants.GUEST.TABLE_NAME, where, args);
            db.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}