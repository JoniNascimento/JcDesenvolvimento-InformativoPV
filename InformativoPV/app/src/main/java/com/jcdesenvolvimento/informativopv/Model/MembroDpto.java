package com.jcdesenvolvimento.informativopv.Model;

/**
 * Created by joni on 20/11/2017.
 */

public class MembroDpto {

    private int iId;
    private int iId_membro;
    private int iId_Igreja;
    private int iId_dpto;

    public MembroDpto() {
    }

    public MembroDpto(int iId, int iId_Igreja, int iId_dpto) {
        this.iId = iId;
        this.iId_Igreja = iId_Igreja;
        this.iId_dpto = iId_dpto;
    }

    public int getiId_membro() {
        return iId_membro;
    }

    public void setiId_membro(int iId_membro) {
        this.iId_membro = iId_membro;
    }

    public int getiId() {
        return iId;

    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public int getiId_Igreja() {
        return iId_Igreja;
    }

    public void setiId_Igreja(int iId_membro) {
        this.iId_Igreja = iId_membro;
    }

    public int getiId_dpto() {
        return iId_dpto;
    }

    public void setiId_dpto(int iId_dpto) {
        this.iId_dpto = iId_dpto;
    }
}
