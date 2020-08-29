package com.continuada.nbaapi.Controller;

import com.continuada.nbaapi.JogadorBasquete;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jogador/basquete")
public class JogadorBasqueteController {

    List<JogadorBasquete> listaJogadores = new ArrayList<>();

    @GetMapping
    public List<JogadorBasquete> listarJogadores(){
        return listaJogadores;
    }

//    Cadastrar jogador
    @PostMapping("/cadastrar")
    public void cadastrarJogador(@RequestBody List<JogadorBasquete> jogadorBasquete){
        listaJogadores.addAll(jogadorBasquete);
    }

//    Atualizar Jogador
    @PutMapping("/atualizar/{id}")
    public String cadastrarJogador(@RequestBody JogadorBasquete jogadorBasquete, @PathVariable int id){
        if(!listaJogadores.isEmpty()){
            listaJogadores.remove(id - 1);
            listaJogadores.add(id - 1, jogadorBasquete);
            return "Jogador atualizado com sucesso!";
        }
        return "Jogador não encontrado";
    }

//    Deletar jogador
    @DeleteMapping("/deletar/{id}")
    public String deletarJogador(@PathVariable int id){
        listaJogadores.remove(id - 1);
        return "Jogador removido";
    }

}
