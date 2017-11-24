package com.jcdesenvolvimento.informativopv.Bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jcdesenvolvimento.informativopv.Model.Boletim;
import com.jcdesenvolvimento.informativopv.Model.Dpto_Ministerio;
import com.jcdesenvolvimento.informativopv.Model.Escala;
import com.jcdesenvolvimento.informativopv.Model.Igreja;
import com.jcdesenvolvimento.informativopv.Model.MembroDpto;
import com.jcdesenvolvimento.informativopv.Model.Pessoa_Membro;

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

    //CadIgreja
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

                list.add(objIgreja);


            }while(cursor.moveToNext());
        }



        return list;

    }
    //CadIgreja



    //Boletim
    public  void insertBoletim (Boletim objeto){
        //Classe para passar valores para o db
        ContentValues valores = new ContentValues();
        valores.put("Mes", objeto.getiMes());
        valores.put("Palavra", objeto.getsPalavra().toString());
        valores.put("Imagem", objeto.getiImagem());

        bd.insert("Boletim",null,valores);

    }

    public void atualizaBoletim(Boletim objeto){
        ContentValues valores = new ContentValues();
        valores.put("Mes", objeto.getiMes());
        valores.put("Palavra", objeto.getsPalavra().toString());
        valores.put("Imagem", objeto.getiImagem());

        bd.update("Boletim",valores,"_id="+objeto.getiId(),null);
    }

    public void deletarBoletim(Boletim objeto){
        bd.delete("Boletim", "_id"+objeto.getiId(),null);
    }

    public List<Boletim> buscarBoletim(){
        List<Boletim> list = new ArrayList<Boletim>();
        String[] colunas = new String[]{"_id","Mes", "Palavra", "Imagem"}; //String de colunas da busca

        Cursor cursor = bd.query("Boletim",colunas,null,null,null,null,"");

        if (cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                Boletim objBoletim = new Boletim();
                //Setar os valores no objeto e adicionar a lista (cursor.getTipo(indiceColuna));
                objBoletim.setiId(cursor.getInt(0));
                objBoletim.setiMes(cursor.getInt(1));
                objBoletim.setsPalavra(cursor.getString(2));
                objBoletim.setiImagem(cursor.getBlob(3));

                list.add(objBoletim);


            }while(cursor.moveToNext());
        }



        return list;

    }
    //Boletim


    //Escala
    public  void insertEscala (Escala objeto){
        //Classe para passar valores para o db
        ContentValues valores = new ContentValues();
        valores.put("id_Boletim", objeto.getiId_Boletim());
        valores.put("dia_mes",objeto.getiDia_mes());
        valores.put("diretor", objeto.getsDiretor().toString());
        valores.put("pregador", objeto.getsPregador().toString());
        valores.put("louvor", objeto.getsLouvor().toString());
        valores.put("secretario_EB", objeto.getsSecretario_EB().toString());
        valores.put("Professor_EB", objeto.getsProfessor_EB().toString());
        valores.put("coordenador_EB", objeto.getsCoordenador_EB().toString());
        valores.put("Patio", objeto.getsPatio().toString());
        valores.put("Tipo_Escala", objeto.getsTipo_Escala().toString());
        valores.put("Imagem", objeto.getiImagem());


        bd.insert("Escala",null,valores);

    }

    public void atualizaEscala (Escala objeto){
        ContentValues valores = new ContentValues();
        valores.put("id_Boletim", objeto.getiId_Boletim());
        valores.put("dia_mes",objeto.getiDia_mes());
        valores.put("diretor", objeto.getsDiretor().toString());
        valores.put("pregador", objeto.getsPregador().toString());
        valores.put("louvor", objeto.getsLouvor().toString());
        valores.put("secretario_EB", objeto.getsSecretario_EB().toString());
        valores.put("Professor_EB", objeto.getsProfessor_EB().toString());
        valores.put("coordenador_EB", objeto.getsCoordenador_EB().toString());
        valores.put("Patio", objeto.getsPatio().toString());
        valores.put("Tipo_Escala", objeto.getsTipo_Escala().toString());
        valores.put("Imagem", objeto.getiImagem());

        bd.update("Escala",valores,"_id="+objeto.getiId(),null);
    }

    public void deletarEscala (Escala objeto){
        bd.delete("Escala", "_id"+objeto.getiId(),null);
    }

    public List<Escala> buscarEscala(){
        List<Escala> list = new ArrayList<Escala>();
        String[] colunas = new String[]{"_id","Mes", "Palavra", "Imagem"}; //String de colunas da busca

        Cursor cursor = bd.query("Escala",colunas,null,null,null,null,"");

        if (cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                Escala objEscala = new Escala();
                //Setar os valores no objeto e adicionar a lista (cursor.getTipo(indiceColuna));
                objEscala.setiId(cursor.getInt(0));
                objEscala.setiId_Boletim(cursor.getInt(1));
                objEscala.setiDia_mes(cursor.getInt(2));
                objEscala.setsDiretor(cursor.getString(3));
                objEscala.setsPregador(cursor.getString(4));
                objEscala.setsLouvor(cursor.getString(5));
                objEscala.setsSecretario_EB(cursor.getString(6));
                objEscala.setsProfessor_EB(cursor.getString(7));
                objEscala.setsCoordenador_EB(cursor.getString(8));
                objEscala.setsPatio(cursor.getString(9));
                objEscala.setsTipo_Escala(cursor.getString(10));
                objEscala.setiImagem(cursor.getBlob(11));

                list.add(objEscala);


            }while(cursor.moveToNext());
        }



        return list;

    }
    //Escala


    //Dpto_Ministerio
    public  void insertDpto_Ministerio(Dpto_Ministerio objeto){
        //Classe para passar valores para o db
        ContentValues valores = new ContentValues();
        valores.put("id_igreja", objeto.getiId_igreja());
        valores.put("descricao", objeto.getsDescricao());


        bd.insert("Dpto_Ministerio",null,valores);


    }

    public void atualizaDpto_Ministerio(Dpto_Ministerio objeto){
        ContentValues valores = new ContentValues();
        valores.put("id_igreja", objeto.getiId_igreja());
        valores.put("descricao", objeto.getsDescricao());


        bd.update("Dpto_Ministerio",valores,"_id="+objeto.getiId(),null);
    }

    public void deletarDpto_Ministerio(Dpto_Ministerio objeto){
        bd.delete("Dpto_Ministerio", "_id"+objeto.getiId(),null);
    }

    public List<Dpto_Ministerio> buscarDpto_Ministerio(){
        List<Dpto_Ministerio> list = new ArrayList<Dpto_Ministerio>();
        String[] colunas = new String[]{"_id","Mes", "Palavra", "Imagem"}; //String de colunas da busca

        Cursor cursor = bd.query("Dpto_Ministerio",colunas,null,null,null,null,"");

        if (cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                Dpto_Ministerio objDpto_Ministerio = new Dpto_Ministerio();
                //Setar os valores no objeto e adicionar a lista (cursor.getTipo(indiceColuna));
                objDpto_Ministerio.setiId(cursor.getInt(0));
                objDpto_Ministerio.setiId_igreja(cursor.getInt(1));
                objDpto_Ministerio.setsDescricao(cursor.getString(2));


                list.add(objDpto_Ministerio);


            }while(cursor.moveToNext());
        }



        return list;

    }
    //Dpto_Ministerio

    //MembroDpto
    public  void insertMembroDpto(MembroDpto objeto){
        //Classe para passar valores para o db
        ContentValues valores = new ContentValues();
        valores.put("iId_Igreja", objeto.getId_igreja());
        valores.put("descricao", objeto.getsDescricao());


        bd.insert("MembroDpto",null,valores);


    }

    public void atualizaMembroDpto(MembroDpto objeto){
        ContentValues valores = new ContentValues();
        valores.put("id_igreja", objeto.getiId_igreja());
        valores.put("descricao", objeto.getsDescricao());


        bd.update("MembroDpto",valores,"_id="+objeto.getiId(),null);
    }

    public void deletarMembroDpto(MembroDpto objeto){
        bd.delete("Dpto_Ministerio", "_id"+objeto.getiId(),null);
    }

    public List<MembroDpto> buscarMembroDpto{
        List<MembroDpto> list = new ArrayList<MembroDpto>();
        String[] colunas = new String[]{"_id","Mes", "Palavra", "Imagem"}; //String de colunas da busca

        Cursor cursor = bd.query("MembroDpto",colunas,null,null,null,null,"");

        if (cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                MembroDpto objMembroDpto = new MembroDpto();
                //Setar os valores no objeto e adicionar a lista (cursor.getTipo(indiceColuna));
                objMembroDpto.setiId(cursor.getInt(0));
                objMembroDpto.setiId_igreja(cursor.getInt(1));
                objMembroDpto.setsDescricao(cursor.getString(2));


                list.add(objDpto_Ministerio);


            }while(cursor.moveToNext());
        }



        return list;

    }
    //Dpto_Ministerio


      db.execSQL("create table  (_id integer primary key autoncrement, id_membro integer, id_dpto integer)");

        db.execSQL("create table Pessoa_Membro (_id integer primary key autoncrement, Nome Text, nascimento date)");

        db.execSQL("create table Telefones (_id integer primary key autoncrement, id_cliente integer, ddd integer, telefone text )");



}
