package com.jcdesenvolvimento.informativopv.Model;

/**
 * Created by joni on 20/11/2017.
 */

public class Telefones {

    private int iId;
    private int iId_Membro;
    private int iDdd;
    private String sTelefone;

    public Telefones() {
    }

    public Telefones(int iId, int iId_Membro, int iDdd, String sTelefone) {
        this.iId = iId;
        this.iId_Membro = iId_Membro;
        this.iDdd = iDdd;
        this.sTelefone = sTelefone;
    }

    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public int getiId_Membro() {
        return iId_Membro;
    }

    public void setiId_Membro(int iId_Membro) {
        this.iId_Membro = iId_Membro;
    }

    public int getiDdd() {
        return iDdd;
    }

    public void setiDdd(int iDdd) {
        this.iDdd = iDdd;
    }

    public String getsTelefone() {
        return sTelefone;
    }

    public void setsTelefone(String sTelefone) {
        this.sTelefone = sTelefone;
    }
}
