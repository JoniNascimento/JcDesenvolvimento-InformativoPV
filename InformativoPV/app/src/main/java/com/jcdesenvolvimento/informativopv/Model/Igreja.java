package com.jcdesenvolvimento.informativopv.Model;


/**
 * Created by joni on 20/11/2017.
 */

public class Igreja {
    private int id;
    private String sDescricao;
    private String sResponsavel;
    private String sEndereco;
    private String sBairro;
    private String sCidade;
    private String sEstado;
    private byte[] bLogo;
    private String sSobre;

    public Igreja() {
    }

    public Igreja(int id, String descricao, String responsavel, String endereco, String bairro, String cidade, String estado, byte[] logo, String sobre) {
        this.id = id;
        this.sDescricao = descricao;
        this.sResponsavel = responsavel;
        this.sEndereco = endereco;
        this.sBairro = bairro;
        this.sCidade = cidade;
        this.sEstado = estado;
        this.bLogo = logo;
        this.sSobre = sobre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getsDescricao() {
        return sDescricao;
    }

    public void setsDescricao(String sDescricao) {
        this.sDescricao = sDescricao;
    }

    public String getsResponsavel() {
        return sResponsavel;
    }

    public void setsResponsavel(String sResponsavel) {
        this.sResponsavel = sResponsavel;
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

    public String getsCidade() {
        return sCidade;
    }

    public void setsCidade(String sCidade) {
        this.sCidade = sCidade;
    }

    public String getsEstado() {
        return sEstado;
    }

    public void setsEstado(String sEstado) {
        this.sEstado = sEstado;
    }

    public byte[] getbLogo() {
        return bLogo;
    }

    public void setbLogo(byte[] iLogo) {
        this.bLogo = iLogo;
    }

    public String getsSobre() {
        return sSobre;
    }

    public void setsSobre(String sSobre) {
        this.sSobre = sSobre;
    }
}
