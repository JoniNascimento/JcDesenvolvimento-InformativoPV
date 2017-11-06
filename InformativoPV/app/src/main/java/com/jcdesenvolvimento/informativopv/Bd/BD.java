package com.jcdesenvolvimento.informativopv.Bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by joni on 03/11/17.
 */

public class BD extends SQLiteOpenHelper {
    private static  final String NOME_BD = "Informativo";
    private static final int VERSAO_BD = 1;

    //Se o banco existir vai conectar ao banco
    //Se não existir vai chamar o metodo onCreate
    //Se Já existir e a versão mudar chama o onUpgrade
    public BD(Context context) {
        super(context, NOME_BD, null, VERSAO_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table nome tabela (_id integer primary key autoncrement, ....)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Dropar o banco ou alterar o banco

    }
}
