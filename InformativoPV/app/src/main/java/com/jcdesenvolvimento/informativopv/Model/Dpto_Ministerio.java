package com.jcdesenvolvimento.informativopv.Model;

/**
 * Created by joni on 20/11/2017.
 */

public class Dpto_Ministerio {

    private int iId;
    private int iId_igreja;
    private String sDescricao;

    public Dpto_Ministerio() {
    }

    public Dpto_Ministerio(int iId, int iId_igreja, String sDescricao) {
        this.iId = iId;
        this.iId_igreja = iId_igreja;
        this.sDescricao = sDescricao;
    }

    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public int getiId_igreja() {
        return iId_igreja;
    }

    public void setiId_igreja(int iId_igreja) {
        this.iId_igreja = iId_igreja;
    }

    public String getsDescricao() {
        return sDescricao;
    }

    public void setsDescricao(String sDescricao) {
        this.sDescricao = sDescricao;
    }
}
