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
       // db.execSQL("create table nome tabela (_id integer primary key autoncrement, ....)");

        db.execSQL("create table Cadastro_Igreja (_id integer primary key autoincrement, Descricao Text, Responsavel Text, Endereco Text, Bairro Text, Cidade Text, Estado Text, Logo Blob, Sobre Text)");

        db.execSQL("create table Boletim (_id integer primary key autoincrement,Tutilo Text ,Mes integer, Ano integer, Palavra Text, Tema Text, Imagem Blob)");

        db.execSQL("create table Escala (_id integer primary key autoincrement, id_Boletim integer, dia_mes integer, diretor Text, pregador Text, louvor Text, secretario_EB Text, Professor_EB Text, coordenador_EB Text,  Text, Tipo_Escala Text, Imagem Blob )"); //tipo escala - Oficial; Local; Regional

        db.execSQL("create table PG (_id integer primary key autoincrement, local Text, dia_semana integer, Endereco Text, bairro Text, Cidade Text, estado text, responsavel text )");

        db.execSQL("create table Dpto_Ministerio (_id integer primary key autoincrement, id_igreja integer, descricao Text )");

        db.execSQL("create table MembroDpto (_id integer primary key autoincrement, id_membro integer, id_dpto integer)");

        db.execSQL("create table Pessoa_Membro (_id integer primary key autoincrement, Nome Text, nascimento date)");

        db.execSQL("create table Telefones (_id integer primary key autoincrement, id_Membro integer, ddd integer, telefone text )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Dropar o banco ou alterar o banco

    }
}
