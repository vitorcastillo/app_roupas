package com.vitorcastillo.as2_coletaroupas;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CriaUsuario extends SQLiteOpenHelper {
    public static final String NOME_BANCO = "usuario.db";
    public static final String TABELA = "usuario";
    public static final String ID = "id";
    public static final String NOME = "name";
    public static final String CPF = "cpf";
    public static final String TELEFONE = "fone";
    public static final String EMAIL = "email";
    public static final String SENHA = "senha";
    public static final String ENDERECO = "endereco";
    public static final int VERSAO = 1;

    public CriaUsuario(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+"("
                + ID + " integer primary key autoincrement,"
                + NOME + " text,"
                + CPF + " text,"
                + TELEFONE + " text,"
                + EMAIL + " text,"
                + SENHA + " text,"
                + ENDERECO + " text"
                +")";
        db.execSQL(sql);


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);

    }
}