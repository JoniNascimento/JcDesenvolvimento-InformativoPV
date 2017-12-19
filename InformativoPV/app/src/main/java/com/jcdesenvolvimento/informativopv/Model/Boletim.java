package com.jcdesenvolvimento.informativopv.Model;

import java.io.Serializable;
import java.sql.Blob;

/**
 * Created by joni on 20/11/2017.
 */

public class Boletim  implements Serializable{

    private int iId;
    private String Titulo;
    private int iMes;
    private int iAno;
    private String sPalavra;
    private String sTema;
    private byte[] iImagem;

    public Boletim() {
    }

    public Boletim(int iId, int iMes, String sPalavra, String sTema, byte[] iImagem) {
        this.iId = iId;
        this.iMes = iMes;
        this.sPalavra = sPalavra;
        this.sTema = sTema;
        this.iImagem = iImagem;
    }


    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public int getiMes() {
        return iMes;
    }

    public int getiAno() {
        return iAno;
    }

    public void setiAno(int iAno) {
        this.iAno = iAno;
    }

    public void setiMes(int iMes) {
        this.iMes = iMes;
    }

    public String getsPalavra() {
        return sPalavra;
    }

    public void setsPalavra(String sPalavra) {
        this.sPalavra = sPalavra;
    }

    public String getsTema() {
        return sTema;
    }

    public void setsTema(String sTema) {
        this.sTema = sTema;
    }

    public byte[] getiImagem() {
        return iImagem;
    }

    public void setiImagem(byte[] iImagem) {
        this.iImagem = iImagem;
    }
}
