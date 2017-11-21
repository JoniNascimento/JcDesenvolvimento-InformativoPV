package com.jcdesenvolvimento.informativopv.Model;

import java.sql.Blob;

/**
 * Created by joni on 20/11/2017.
 */

public class Escala {
    private int iId;
    private int iId_Boletim;
    private int iDia_mes;
    private String sDiretor;
    private String sPregador;
    private String sLouvor;
    private String sSecretario_EB;
    private String sProfessor_EB;
    private String sCoordenador_EB;
    private String sPatio;
    private String sTipo_Escala;
    private Blob iImagem;

    public Escala() {
    }

    public Escala(int iId, int iId_Boletim, int iDia_mes, String sDiretor, String sPregador, String sLouvor, String sSecretario_EB, String sProfessor_EB, String sCoordenador_EB, String sPatio, String sTipo_Escala, Blob iImagem) {
        this.iId = iId;
        this.iId_Boletim = iId_Boletim;
        this.iDia_mes = iDia_mes;
        this.sDiretor = sDiretor;
        this.sPregador = sPregador;
        this.sLouvor = sLouvor;
        this.sSecretario_EB = sSecretario_EB;
        this.sProfessor_EB = sProfessor_EB;
        this.sCoordenador_EB = sCoordenador_EB;
        this.sPatio = sPatio;
        this.sTipo_Escala = sTipo_Escala;
        this.iImagem = iImagem;
    }

    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public int getiId_Boletim() {
        return iId_Boletim;
    }

    public void setiId_Boletim(int iId_Boletim) {
        this.iId_Boletim = iId_Boletim;
    }

    public int getiDia_mes() {
        return iDia_mes;
    }

    public void setiDia_mes(int iDia_mes) {
        this.iDia_mes = iDia_mes;
    }

    public String getsDiretor() {
        return sDiretor;
    }

    public void setsDiretor(String sDiretor) {
        this.sDiretor = sDiretor;
    }

    public String getsPregador() {
        return sPregador;
    }

    public void setsPregador(String sPregador) {
        this.sPregador = sPregador;
    }

    public String getsLouvor() {
        return sLouvor;
    }

    public void setsLouvor(String sLouvor) {
        this.sLouvor = sLouvor;
    }

    public String getsSecretario_EB() {
        return sSecretario_EB;
    }

    public void setsSecretario_EB(String sSecretario_EB) {
        this.sSecretario_EB = sSecretario_EB;
    }

    public String getsProfessor_EB() {
        return sProfessor_EB;
    }

    public void setsProfessor_EB(String sProfessor_EB) {
        this.sProfessor_EB = sProfessor_EB;
    }

    public String getsCoordenador_EB() {
        return sCoordenador_EB;
    }

    public void setsCoordenador_EB(String sCoordenador_EB) {
        this.sCoordenador_EB = sCoordenador_EB;
    }

    public String getsPatio() {
        return sPatio;
    }

    public void setsPatio(String sPatio) {
        this.sPatio = sPatio;
    }

    public String getsTipo_Escala() {
        return sTipo_Escala;
    }

    public void setsTipo_Escala(String sTipo_Escala) {
        this.sTipo_Escala = sTipo_Escala;
    }

    public Blob getiImagem() {
        return iImagem;
    }

    public void setiImagem(Blob iImagem) {
        this.iImagem = iImagem;
    }
}
