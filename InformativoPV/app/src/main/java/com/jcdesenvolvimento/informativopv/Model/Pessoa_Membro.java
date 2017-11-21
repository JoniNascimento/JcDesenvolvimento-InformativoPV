package com.jcdesenvolvimento.informativopv.Model;

import java.util.Date;

/**
 * Created by joni on 20/11/2017.
 */

public class Pessoa_Membro {

    private int iId;
    private String sNome;
    private Date dNascimento;

    public Pessoa_Membro() {
    }

    public Pessoa_Membro(int iId, String sNome, Date dNascimento) {
        this.iId = iId;
        this.sNome = sNome;
        this.dNascimento = dNascimento;
    }

    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public String getsNome() {
        return sNome;
    }

    public void setsNome(String sNome) {
        this.sNome = sNome;
    }

    public Date getdNascimento() {
        return dNascimento;
    }

    public void setdNascimento(Date dNascimento) {
        this.dNascimento = dNascimento;
    }
}
