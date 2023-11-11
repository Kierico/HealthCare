package com.example.healthcare;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String BANCO_DADOS_NOME = "healthcare";
    private static int BANCO_DADOS_VERSAO = 1;

    /** Contrutor */
    public DatabaseHelper(Context context) {
        super(context, BANCO_DADOS_NOME, null, BANCO_DADOS_VERSAO);
    }

    /** Metodos Principais (onCreate & onUpgrade) */
    @Override
    public void onCreate(SQLiteDatabase db) {
        /** Método do SQL para criar */
        //db.execSQL("CREATE TABLE ?(_id INTEGER PRIMARY KEY AUTOINCREMENT, ? TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
