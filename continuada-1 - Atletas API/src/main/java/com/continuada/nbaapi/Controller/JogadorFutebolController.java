package com.continuada.nbaapi.Controller;
import com.continuada.nbaapi.JogadorFutebol;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jogador/futebol")
public class JogadorFutebolController {

    List<JogadorFutebol> listaJogadores = new ArrayList<>();

    @GetMapping
    public List<JogadorFutebol> listarJogadores(){
        return listaJogadores;
    }

//    Cadastrar jogador
    @PostMapping("/cadastrar")
    public void cadastrarJogador(@RequestBody List<JogadorFutebol> jogadorFutebol){
        listaJogadores.addAll(jogadorFutebol);
    }

//    Atualizar Jogador
    @PutMapping("/atualizar/{id}")
    public String cadastrarJogador(@RequestBody JogadorFutebol jogadorFutebol, @PathVariable int id){
        if(!listaJogadores.isEmpty()){
            listaJogadores.remove(id - 1);
            listaJogadores.add(id - 1, jogadorFutebol);
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
