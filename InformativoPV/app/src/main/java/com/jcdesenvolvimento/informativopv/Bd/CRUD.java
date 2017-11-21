package com.jcdesenvolvimento.informativopv.Bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jcdesenvolvimento.informativopv.Model.Igreja;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joni on 03/11/17.
 */

public class CRUD {
    private SQLiteDatabase bd ;

    //CadIgreja
    public CRUD(Context ctx){
        BD auxBd = new BD(ctx);
        bd = auxBd.getWritableDatabase();
    }

    public  void insertCadIgreja (Igreja objeto){
        //Classe para passar valores para o db
        ContentValues valores = new ContentValues();
        valores.put("Descricao", objeto.getsDescricao().toString());
        valores.put("Responsavel", objeto.getsResponsavel().toString());
        valores.put("Endereco", objeto.getsEndereco().toString());
        valores.put("Bairro", objeto.getsBairro().toString());
        valores.put("Cidade", objeto.getsCidade().toString());
        valores.put("Estado", objeto.getsEstado().toString());
        valores.put("Logo", objeto.getbLogo());
        valores.put("Sobre", objeto.getsSobre().toString());

        bd.insert("Cadastro_Igreja",null,valores);

    }

    public void atualizaCadIgreja(Igreja objeto){
        ContentValues valores = new ContentValues();
        valores.put("Descricao", objeto.getsDescricao().toString());
        valores.put("Responsavel", objeto.getsResponsavel().toString());
        valores.put("Endereco", objeto.getsEndereco().toString());
        valores.put("Bairro", objeto.getsBairro().toString());
        valores.put("Cidade", objeto.getsCidade().toString());
        valores.put("Estado", objeto.getsEstado().toString());
        valores.put("Logo", objeto.getbLogo());
        valores.put("Sobre", objeto.getsSobre().toString());

        bd.update("Cadastro_Igreja",valores,"_id="+objeto.getId(),null);
    }

    public void deletarCadIgreja(Igreja objeto){
        bd.delete("Cadastro_Igreja", "_id"+objeto.getId(),null);
    }

    public List<Igreja> buscarCadIgreja(){
        List<Igreja> list = new ArrayList<Igreja>();
        String[] colunas = new String[]{"_id","Descricao", "Endereco", "Bairro","Cidade", "Estado", "Logo", "Sobre" }; //String de colunas da busca

        Cursor cursor = bd.query("Cadastro_Igreja",colunas,null,null,null,null,"");

        if (cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
               //Setar os valores no objeto e adicionar a lista (cursor.getTipo(indiceColuna));
               Igreja objIgreja = new Igreja();
                objIgreja.setId(cursor.getInt(0));
                objIgreja.setsDescricao(cursor.getString(1));
                objIgreja.setsEndereco(cursor.getString(2));
                objIgreja.setsBairro(cursor.getString(3));
                objIgreja.setsCidade(cursor.getString(4));
                objIgreja.setsEstado(cursor.getString(5));
                objIgreja.setbLogo(cursor.getBlob(6));
                objIgreja.setsSobre(cursor.getString(7));


            }while(cursor.moveToNext());
        }



        return list;

    }
    //CadIgreja



}
