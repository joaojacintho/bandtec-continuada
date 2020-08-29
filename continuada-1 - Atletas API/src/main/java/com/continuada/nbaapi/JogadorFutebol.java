package com.continuada.nbaapi;

public class JogadorFutebol extends Atleta{

    private Integer gols;

    public JogadorFutebol(Integer idJogador, String nome, Integer idade, String posicao, Double salario, Time time, Integer gols) {
        super(idJogador, nome, idade, posicao, salario);
        this.gols = gols;
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
            case "GOL":
                return getSalario() * 8.0;
            case "DEF":
                return getSalario() * 5.0;
            case "MEIA":
                return getSalario() * 4.0;
            case "AT":
                return getSalario() * 3.0;
            default:
                return getSalario() * 1.0;
        }
    }

    @Override
    public Double calcularValorPontosPorJogo() {
        if(this.gols < 1.0){
            return getSalario() * 0.5;
        }else if(this.gols < 2.0){
            return getSalario() * 0.7;
        }else if(this.gols < 3.0){
            return getSalario() * 0.9;
        }else if(this.gols < 4.0){
            return getSalario() * 1.0;
        }else if(this.gols > 5.0){
            return getSalario() * 3.0;
        }else{
            return getSalario() * 1.0;
        }
    }

    @Override
    public String toString() {
        return "JogadorFutebol{" +
                "gols=" + gols +
                "} " + super.toString();
    }
}
