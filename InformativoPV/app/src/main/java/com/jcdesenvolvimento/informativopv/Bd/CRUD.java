package com.jcdesenvolvimento.informativopv.Bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joni on 03/11/17.
 */

public class CRUD {
    private SQLiteDatabase bd ;


    public CRUD(Context ctx){
        BD auxBd = new BD(ctx);
        bd = auxBd.getWritableDatabase();
    }

    public  void insert (String Objeto){
        //Classe para passar valores para o db
        ContentValues valores = new ContentValues();
        valores .put();

        bd.insert("tabela",null,valores);

    }

    public void atualizar(String Objeto){
        ContentValues valores = new ContentValues();
        valores .put();

        bd.update("tabel",valores,"_id="+ID,null);
    }

    public void deletar(String Objeto){
        bd.delete("tabela", "_id"+id,null);
    }

    public List<> buscar(){
        List<> list = new ArrayList<>();
        String[] colunas = new String[]{"",""};

        Cursor cursor = bd.query("tabela",colunas,null,null,null,null,"");

        if (cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
               //Setar os valores no objeto e adicionar a lista (cursor.getTipo(indiceColuna));

            }while(cursor.moveToNext());
        }



        return list;

    }
}
