package com.jcdesenvolvimento.informativopv.Model;

/**
 * Created by joni on 20/11/2017.
 */

public class Pg {

    private int iId;
    private String sLocal;
    private int iDia_semana;
    private String sEndereco;
    private String sBairro;
    private String Cidade;
    private String estado;
    private String responsavel;

    public Pg() {
    }

    public Pg(int iId, String sLocal, int iDia_semana, String sEndereco, String sBairro, String cidade, String estado, String responsavel) {
        this.iId = iId;
        this.sLocal = sLocal;
        this.iDia_semana = iDia_semana;
        this.sEndereco = sEndereco;
        this.sBairro = sBairro;
        Cidade = cidade;
        this.estado = estado;
        this.responsavel = responsavel;
    }

    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public String getsLocal() {
        return sLocal;
    }

    public void setsLocal(String sLocal) {
        this.sLocal = sLocal;
    }

    public int getiDia_semana() {
        return iDia_semana;
    }

    public void setiDia_semana(int iDia_semana) {
        this.iDia_semana = iDia_semana;
    }

    public String getsEndereco() {
        return sEndereco;
    }

    public void setsEndereco(String sEndereco) {
        this.sEndereco = sEndereco;
    }

    public String getsBairro() {
        return sBairro;
    }

    public void setsBairro(String sBairro) {
        this.sBairro = sBairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
}
