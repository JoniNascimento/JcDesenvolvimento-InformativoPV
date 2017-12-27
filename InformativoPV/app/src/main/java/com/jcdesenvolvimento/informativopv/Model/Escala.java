package com.jcdesenvolvimento.informativopv.Model;

import java.sql.Blob;
import java.util.List;

/**
 * Created by joni on 20/11/2017.
 */

public class Escala {
    private int iId;
    private int iId_Boletim;
    private int iDia_mes;
    private int idMembroDiretor;
    private String sDiretor;
    private int idMembroPregador;
    private String sPregador;
    private int idMembroLouvor;
    private String sLouvor;
    private int idMembroSecretario_EB;
    private String sSecretario_EB;
    private int idMembroProfessor_EB;
    private String sProfessor_EB;
    private int idMembroCoordenador_EB;
    private String sCoordenador_EB;
    private int idMembroPatio;
    private String sPatio;
    private String sTipo_Escala;
    private List<Integer> idMembroOferta;
    private String sOferta;
    private List<Integer> idMembroOfertaEB;
    private String sOfertaEB;
    private byte[] iImagem;

    public Escala(){
        this.iId = 0;
        this.iId_Boletim = 0;
        this.iDia_mes = 0;
        this.idMembroDiretor = 0;
        this.sDiretor = "";
        this.idMembroPregador = 0;
        this.sPregador = "";
        this.idMembroLouvor = 0;
        this.sLouvor = "";
        this.idMembroSecretario_EB = 0;
        this.sSecretario_EB = "";
        this.idMembroProfessor_EB = 0;
        this.sProfessor_EB = "";
        this.idMembroCoordenador_EB = 0;
        this.sCoordenador_EB = "";
        this.idMembroPatio = 0;
        this.sPatio = "";
        this.sTipo_Escala = "";
        this.iImagem = null;

    }

    public Escala(int iId, int iId_Boletim, int iDia_mes, int idMembroDiretor, String sDiretor, int idMembroPregador, String sPregador, int idMembroLouvor, String sLouvor, int idMembroSecretario_EB, String sSecretario_EB, int idMembroProfessor_EB, String sProfessor_EB, int idMembroCoordenador_EB, String sCoordenador_EB, int idMembroPatio, String sPatio, String sTipo_Escala, String sOferta, String sOfertaEB, byte[] iImagem) {
        this.iId = iId;
        this.iId_Boletim = iId_Boletim;
        this.iDia_mes = iDia_mes;
        this.idMembroDiretor = idMembroDiretor;
        this.sDiretor = sDiretor;
        this.idMembroPregador = idMembroPregador;
        this.sPregador = sPregador;
        this.idMembroLouvor = idMembroLouvor;
        this.sLouvor = sLouvor;
        this.idMembroSecretario_EB = idMembroSecretario_EB;
        this.sSecretario_EB = sSecretario_EB;
        this.idMembroProfessor_EB = idMembroProfessor_EB;
        this.sProfessor_EB = sProfessor_EB;
        this.idMembroCoordenador_EB = idMembroCoordenador_EB;
        this.sCoordenador_EB = sCoordenador_EB;
        this.idMembroPatio = idMembroPatio;
        this.sPatio = sPatio;
        this.sTipo_Escala = sTipo_Escala;
        this.sOferta = sOferta;
        this.sOfertaEB = sOfertaEB;
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

    public byte[] getiImagem() {
        return iImagem;
    }

    public String getsOferta() {
        return sOferta;
    }

    public void setsOferta(String sOferta) {
        this.sOferta = sOferta;
    }

    public int getIdMembroPatio() {
        return idMembroPatio;
    }

    public void setIdMembroPatio(int idMembroPatio) {
        this.idMembroPatio = idMembroPatio;
    }

    public String getsOfertaEB() {
        return sOfertaEB;
    }

    public void setsOfertaEB(String sOfertaEB) {
        this.sOfertaEB = sOfertaEB;
    }

    public int getIdMembroDiretor() {
        return idMembroDiretor;
    }

    public void setIdMembroDiretor(int idMembroDiretor) {
        this.idMembroDiretor = idMembroDiretor;
    }

    public int getIdMembroPregador() {
        return idMembroPregador;
    }

    public void setIdMembroPregador(int idMembroPregador) {
        this.idMembroPregador = idMembroPregador;
    }

    public int getIdMembroLouvor() {
        return idMembroLouvor;
    }

    public void setIdMembroLouvor(int idMembroLouvor) {
        this.idMembroLouvor = idMembroLouvor;
    }

    public int getIdMembroSecretario_EB() {
        return idMembroSecretario_EB;
    }

    public void setIdMembroSecretario_EB(int idMembroSecretario_EB) {
        this.idMembroSecretario_EB = idMembroSecretario_EB;
    }

    public int getIdMembroProfessor_EB() {
        return idMembroProfessor_EB;
    }

    public void setIdMembroProfessor_EB(int idMembroProfessor_EB) {
        this.idMembroProfessor_EB = idMembroProfessor_EB;
    }

    public int getIdMembroCoordenador_EB() {
        return idMembroCoordenador_EB;
    }

    public void setIdMembroCoordenador_EB(int idMembroCoordenador_EB) {
        this.idMembroCoordenador_EB = idMembroCoordenador_EB;
    }

    public int getIdMembroPatio_EB() {
        return idMembroPatio;
    }

    public void setIdMembroPatio_EB(int idMembroPatio_EB) {
        this.idMembroPatio = idMembroPatio_EB;
    }

    public void setiImagem(byte[] iImagem) {
        this.iImagem = iImagem;
    }
}
