package com.continuada.nbaapi.Controller;

import com.continuada.nbaapi.Atleta;
import com.continuada.nbaapi.JogadorBasquete;
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

    // Cadastrar jogador ao time
    @PostMapping("/cadastrar/jogador/basquete/{id}")
    public String cadastrarJogadorAoTime(@RequestBody JogadorBasquete jogadorBasquete, @PathVariable int id){
        if (!listaTime.isEmpty()){
            listaTime.get(id - 1).getListaAtleta().add(id - 1 , jogadorBasquete);
            return "Jogador cadastrado com sucesso";
        }
        return "Time não cadastrado";
    }
}
