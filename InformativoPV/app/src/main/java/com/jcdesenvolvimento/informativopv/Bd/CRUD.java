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
import com.jcdesenvolvimento.informativopv.Model.Telefones;

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
        valores.put("IdIgreja",objeto.getiIdIgreja());
        valores.put("Titulo", objeto.getTitulo().toString());
        valores.put("Mes", objeto.getiMes());
        valores.put("Ano", objeto.getiAno());
        valores.put("Palavra", objeto.getsPalavra().toString());
        valores.put("Tema",objeto.getsTema().toString());
        valores.put("Imagem", objeto.getiImagem());

        bd.insert("Boletim",null,valores);

    }

    public void atualizaBoletim(Boletim objeto){
        ContentValues valores = new ContentValues();
        valores.put("IdIgreja",objeto.getiIdIgreja());
        valores.put("Titulo", objeto.getTitulo().toString());
        valores.put("Mes", objeto.getiMes());
        valores.put("Ano", objeto.getiAno());
        valores.put("Palavra", objeto.getsPalavra().toString());
        valores.put("Tema",objeto.getsTema().toString());
        valores.put("Imagem", objeto.getiImagem());

        bd.update("Boletim",valores,"_id="+objeto.getiId(),null);


    }

    public void deletarBoletim(Boletim objeto){
        bd.delete("Boletim", "_id"+objeto.getiId(),null);
    }

    public List<Boletim> buscarBoletim(){
        List<Boletim> list = new ArrayList<Boletim>();
        String[] colunas = new String[]{"_id","IdIgreja", "Titulo","Mes", "Ano", "Palavra","Tema", "Imagem"}; //String de colunas da busca

        Cursor cursor = bd.query("Boletim",colunas,null,null,null,null,"");

        if (cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                Boletim objBoletim = new Boletim();
                //Setar os valores no objeto e adicionar a lista (cursor.getTipo(indiceColuna));
                objBoletim.setiId(cursor.getInt(0));
                objBoletim.setiIdIgreja(cursor.getInt(1));
                objBoletim.setTitulo(cursor.getString(2));
                objBoletim.setiMes(cursor.getInt(3));
                objBoletim.setiAno(cursor.getInt(4));
                objBoletim.setsPalavra(cursor.getString(5));
                objBoletim.setsTema(cursor.getString(6));
                objBoletim.setiImagem(cursor.getBlob(7));

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
        valores.put("iId_Igreja", objeto.getiId_Igreja());
        valores.put("id_membro", objeto.getiId_membro());
        valores.put("id_dpto", objeto.getiId_dpto());


        bd.insert("MembroDpto",null,valores);


    }

    public void atualizaMembroDpto(MembroDpto objeto){
        ContentValues valores = new ContentValues();
        valores.put("iId_Igreja", objeto.getiId_Igreja());
        valores.put("id_membro", objeto.getiId_membro());
        valores.put("id_dpto", objeto.getiId_dpto());

        bd.update("MembroDpto",valores,"_id="+objeto.getiId(),null);
    }

    public void deletarMembroDpto(MembroDpto objeto){
        bd.delete("MembroDpto", "_id"+objeto.getiId(),null);
    }

    public List<MembroDpto> buscarMembroDpto(){
        List<MembroDpto> list = new ArrayList<MembroDpto>();
        String[] colunas = new String[]{"_id","Mes", "Palavra", "Imagem"}; //String de colunas da busca

        Cursor cursor = bd.query("MembroDpto",colunas,null,null,null,null,"");

        if (cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                MembroDpto objMembroDpto = new MembroDpto();
                //Setar os valores no objeto e adicionar a lista (cursor.getTipo(indiceColuna));
                objMembroDpto.setiId(cursor.getInt(0));
                objMembroDpto.setiId_Igreja(cursor.getInt(1));
                objMembroDpto.setiId_membro(cursor.getInt(2));
                objMembroDpto.setiId_dpto(cursor.getInt(3));

                list.add(objMembroDpto);


            }while(cursor.moveToNext());
        }



        return list;

    }
    //Dpto_Ministerio


    //Pessoa_Membro
    public  void insertPessoa_Membro(Pessoa_Membro objeto){
        //Classe para passar valores para o db
        ContentValues valores = new ContentValues();
        valores.put("Id_Igreja", objeto.getiId_Igreja());
        valores.put("Nome", objeto.getsNome());
        valores.put("nascimento", String.valueOf(objeto.getdNascimento()));


        bd.insert("Pessoa_Membro",null,valores);


    }

    public void atualizaPessoa_Membro(Pessoa_Membro objeto){
        ContentValues valores = new ContentValues();
        valores.put("Id_Igreja", objeto.getiId_Igreja());
        valores.put("Nome", objeto.getsNome());
        valores.put("nascimento", String.valueOf(objeto.getdNascimento()));


        bd.update("Pessoa_Membro",valores,"_id="+objeto.getiId(),null);
    }

    public void deletarPessoa_Membro(Pessoa_Membro objeto){
        bd.delete("Pessoa_Membro", "_id"+objeto.getiId(),null);
    }

    public List<Pessoa_Membro> buscarPessoa_Membro(){
        List<Pessoa_Membro> list = new ArrayList<Pessoa_Membro>();
        String[] colunas = new String[]{"_id","Mes", "Palavra", "Imagem"}; //String de colunas da busca

        Cursor cursor = bd.query("Pessoa_Membro",colunas,null,null,null,null,"");

        if (cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                Pessoa_Membro objPessoa_Membro = new Pessoa_Membro();
                //Setar os valores no objeto e adicionar a lista (cursor.getTipo(indiceColuna));
                objPessoa_Membro.setiId(cursor.getInt(0));
                objPessoa_Membro.setiId_Igreja(cursor.getInt(1));
                objPessoa_Membro.setsNome(cursor.getString(2));
                //objPessoa_Membro.setdNascimento(String.valueOf(cursor.getString(3)));

                list.add(objPessoa_Membro);


            }while(cursor.moveToNext());
        }



        return list;

    }
    //Pessoa_Membro



    //Telefones
    public  void insertTelefones(Telefones objeto){
        //Classe para passar valores para o db
        ContentValues valores = new ContentValues();
        valores.put("Id_Membro", objeto.getiId_Membro());
        valores.put("ddd", objeto.getiDdd());
        valores.put("telefone", objeto.getsTelefone());


        bd.insert("Telefones",null,valores);


    }

    public void atualizaTelefones(Telefones objeto){
        ContentValues valores = new ContentValues();
        valores.put("Id_Membro", objeto.getiId_Membro());
        valores.put("ddd", objeto.getiDdd());
        valores.put("telefone", objeto.getsTelefone());


        bd.update("Telefones",valores,"_id="+objeto.getiId(),null);
    }

    public void deletarTelefones(Telefones objeto){
        bd.delete("Telefones", "_id"+objeto.getiId(),null);
    }

    public List<Telefones> buscarTelefones(){
        List<Telefones> list = new ArrayList<Telefones>();
        String[] colunas = new String[]{"_id","Mes", "Palavra", "Imagem"}; //String de colunas da busca

        Cursor cursor = bd.query("Telefones",colunas,null,null,null,null,"");

        if (cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                Telefones objTelefones = new Telefones();
                //Setar os valores no objeto e adicionar a lista (cursor.getTipo(indiceColuna));
                objTelefones.setiId(cursor.getInt(0));
                objTelefones.setiId_Membro(cursor.getInt(1));
                objTelefones.setiDdd(cursor.getInt(2));
                objTelefones.setsTelefone(cursor.getString(3));
                //objPessoa_Membro.setdNascimento(String.valueOf(cursor.getString(3)));

                list.add(objTelefones);


            }while(cursor.moveToNext());
        }



        return list;

    }
    //Telefones





}
