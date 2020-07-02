package com.example.convidados.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.convidados.constants.DataBaseConstants;

public class GuestDataBaseHelper extends SQLiteOpenHelper {

    private static final String NAME = "convidados.bd";
    private static final int VERSION = 2;

    // Query SQL para gerar a tabela
    private static final String CREATE_TABLE_GUEST = "create table " + DataBaseConstants.GUEST.TABLE_NAME + " ("
            + DataBaseConstants.GUEST.COLUMNS.ID + " integer primary key autoincrement, "
            + DataBaseConstants.GUEST.COLUMNS.NAME + " text, "
            + DataBaseConstants.GUEST.COLUMNS.PRESENCE + " integer);";

    /**
     * Construtor padrão
     */
    public GuestDataBaseHelper(Context context) {
        super(context, NAME, null, VERSION);
    }

    /**
     * Método executado somente uma vez quando o acesso ao banco de dados é feito pela primeira vez
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_GUEST);
    }

    /**
     * Método executado quando a versão do DATABASE_VERSION é alterada
     * Caso a estrutura de dados precise ser alterada, pode ser feito neste momento.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}
