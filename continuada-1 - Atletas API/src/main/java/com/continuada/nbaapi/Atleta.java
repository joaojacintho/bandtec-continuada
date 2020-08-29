package com.continuada.nbaapi;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public abstract class Atleta {

    private Integer idJogador;
    private String nome;
    private Integer idade;
    private String posicao;
    private Double salario;

    public abstract Double calcularValorIdade();
    public abstract Double calcularValorPosicao();
    public abstract Double calcularValorPontosPorJogo();

    public Atleta(Integer idJogador, String nome, Integer idade, String posicao, Double salario) {
        this.idJogador = idJogador;
        this.nome = nome;
        this.idade = idade;
        this.posicao = posicao;
        this.salario = salario;
    }

    public Integer getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(Integer idJogador) {
        this.idJogador = idJogador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }


}
