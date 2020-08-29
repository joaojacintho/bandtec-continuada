package com.continuada.nbaapi;

import java.util.ArrayList;
import java.util.List;

public class Time {

    private Integer idTime;
    private String nomeTime;
    private String conferencia;
    private Integer anoFundacao;
    private Double dinheiroCaixa;
    private List<Atleta> listaAtleta = new ArrayList<>();

    public void cadastrarJogador(List<Atleta> atleta){
        listaAtleta.addAll(atleta);
    }

    @Override
    public String toString() {
        return "Id: " + idTime + '\n' +
                "Nome do Time: " + nomeTime + '\n' +
                "Conferência: " + conferencia + '\n' +
                "Ano de Fundação: " + anoFundacao + '\n'+
                "Dinheiro em Caixa: " + dinheiroCaixa;
    }

    public Integer getIdTime() {
        return idTime;
    }

    public void setIdTime(Integer idTime) {
        this.idTime = idTime;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    public String getConferencia() {
        return conferencia;
    }

    public void setConferencia(String conferencia) {
        this.conferencia = conferencia;
    }

    public Integer getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(Integer anoFundacao) {
        this.anoFundacao = anoFundacao;
    }

    public Double getDinheiroCaixa() {
        return dinheiroCaixa;
    }

    public void setDinheiroCaixa(Double dinheiroCaixa) {
        this.dinheiroCaixa = dinheiroCaixa;
    }

    public List<Atleta> getListaAtleta() {
        return listaAtleta;
    }

    public void setListaAtleta(List<Atleta> listaAtleta) {
        this.listaAtleta = listaAtleta;
    }
}
