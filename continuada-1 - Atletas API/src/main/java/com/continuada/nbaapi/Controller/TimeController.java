package com.continuada.nbaapi.Controller;

import com.continuada.nbaapi.Atleta;
import com.continuada.nbaapi.JogadorBasquete;
import com.continuada.nbaapi.JogadorFutebol;
import com.continuada.nbaapi.Time;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/time")
public class TimeController {

    private List<Time> listaTime = new ArrayList<>();
    Time timeCadastrado = new Time();

    // Listar times cadastrados
    @GetMapping
    public List<Time> listarTimesCadastrados(){
        return listaTime;
    }

    //  Cadastrar time novo
    @PostMapping("/cadastrar")
    public void cadastrarTime(@RequestBody List<Time> time){
        listaTime.addAll(time);
    }

    // Atualizar time
    @PutMapping("/atualizar/{id}")
    public String atualizarTime(@RequestBody Time time, @PathVariable int id){
        if(!listaTime.isEmpty()){
            listaTime.remove(id - 1);
            listaTime.add(id - 1, time);
            return "Time atualizado com sucesso!";
        }
        return "Time não foi encontrado";
    }

    // Deletar time
    @DeleteMapping("/deletar/{id}")
    public String deletarTime(@PathVariable int id){
        listaTime.remove(id - 1);
        return "Time foi removido";
    }

    // Cadastrar jogador ao time, sendo cadatrado com sucesso o valor é subtraido do dinheiro em caixa do time
    @PostMapping("/cadastrar/jogador/basquete/{id}")
    public String cadastrarJogadorBasquete(@RequestBody JogadorBasquete jogadorBasquete, @PathVariable int id){
        Double salario = jogadorBasquete.getSalario();

        if (!listaTime.isEmpty() && listaTime.get(id - 1).getDinheiroCaixa() > salario){
            listaTime.get(id - 1).getListaAtleta().add(id - 1 , jogadorBasquete);
            listaTime.get(id - 1).setDinheiroCaixa(listaTime.get(id - 1).getDinheiroCaixa() - salario);
            return "Jogador cadastrado com sucesso";
        }else if(listaTime.get(id - 1).getDinheiroCaixa() < salario){
            return "Saldo em caixa insuficiente";
        }
        return "Time não encontrado";
    }
    // Cadastrar jogador ao time, sendo cadatrado com sucesso o valor é subtraido do dinheiro em caixa do time
    @PostMapping("/cadastrar/jogador/futebol/{id}")
    public String cadastrarJogadorFutebol(@RequestBody JogadorFutebol jogadorFutebol, @PathVariable int id){
        Double salario = jogadorFutebol.getSalario();

        if (!listaTime.isEmpty() && listaTime.get(id - 1).getDinheiroCaixa() > salario){
            listaTime.get(id - 1).getListaAtleta().add(id - 1 , jogadorFutebol);
            listaTime.get(id - 1).setDinheiroCaixa(listaTime.get(id - 1).getDinheiroCaixa() - salario);
            return "Jogador cadastrado com sucesso";
        }else if(listaTime.get(id - 1).getDinheiroCaixa() < salario){
            return "Saldo em caixa insuficiente";
        }
        return "Time não encontrado";
    }
}
