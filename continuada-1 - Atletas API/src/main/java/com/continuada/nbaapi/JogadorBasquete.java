package com.continuada.nbaapi;

public class JogadorBasquete extends Atleta {

    private Double pontosPorJogo;


    public JogadorBasquete(Integer idJogador, String nome, Integer idade, String posicao, Double salario, Double pontosPorJogo) {
        super(idJogador, nome, idade, posicao, salario);
        this.pontosPorJogo = pontosPorJogo;
    }

    public Double calcularValorMercado() {
        return calcularValorIdade() + calcularValorPontosPorJogo() + calcularValorPosicao();
    }

    @Override
    public Double calcularValorIdade() {
        if(getIdade() >= 18 && getIdade() <= 24){
            return getSalario() * 70.0;
        }else if(getIdade() > 24 && getIdade()<= 26){
            return getSalario() * 50.0;
        }else if(getIdade() > 26 && getIdade() <= 30){
            return getSalario() * 30.0;
        }else if(getIdade() > 30){
            return getSalario() * 15.0;
        }else{
            return getSalario() * 1.0;
        }
    }

    @Override
    public Double calcularValorPosicao() {
        switch (getPosicao()) {
            case "PG":
                return getSalario() * 8.0;
            case "SG":
                return getSalario() * 5.0;
            case "SF":
                return getSalario() * 4.0;
            case "PF":
                return getSalario() * 3.0;
            case "C":
                return getSalario() * 2.0;
            default:
                return getSalario() * 1.0;
        }
    }

    @Override
    public Double calcularValorPontosPorJogo() {
        if(this.pontosPorJogo < 5.0){
            return getSalario() * 0.5;
        }else if(this.pontosPorJogo < 10.0){
            return getSalario() * 0.7;
        }else if(this.pontosPorJogo < 15.0){
            return getSalario() * 0.9;
        }else if(this.pontosPorJogo < 20.0){
            return getSalario() * 1.0;
        }else if(this.pontosPorJogo < 80.0){
            return getSalario() * 3.0;
        }else{
            return getSalario() * 1.0;
        }
    }

    public Double getPontosPorJogo() {
        return pontosPorJogo;
    }

    public void setPontosPorJogo(Double pontosPorJogo) {
        this.pontosPorJogo = pontosPorJogo;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "pontosPorJogo=" + pontosPorJogo +
                "} " + super.toString();
    }
}
