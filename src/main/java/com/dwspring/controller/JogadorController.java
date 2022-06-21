package com.dwspring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dwspring.entity.Jogador;
import com.dwspring.repository.JogadorRepository;

@RestController
@RequestMapping("/api/jogador")
public class JogadorController {
  @Autowired
  private JogadorRepository _jogadorRepository;

  @PostMapping() // CRIAR
  public ResponseEntity<Jogador> Post(@RequestBody Jogador jogador) {
    try {
      System.out.println(jogador.getDataNasc());
      Jogador _j = _jogadorRepository.save(new Jogador(jogador.getNome(), jogador.getEmail(), jogador.getDataNasc()));

      return new ResponseEntity<Jogador>(_j, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping() // LISTAR TODOS
  public ResponseEntity<List<Jogador>> Get() {
    try {
      List<Jogador> _j = _jogadorRepository.findAll();
      System.out.println(_j);
      if (_j.isEmpty())
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

      return new ResponseEntity<>(_j, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/{cod_jogador}") // RECUPERAR POR ID
  public ResponseEntity<Jogador> GetById(@PathVariable("cod_jogador") int cod_jogador) {
    try {
      Optional<Jogador> _j = _jogadorRepository.findById(cod_jogador);
  
      if(_j.isPresent())
        return new ResponseEntity<Jogador>(_j.get(), HttpStatus.OK);
      
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/{cod_jogador}") // ATUALIZAR POR ID
  public ResponseEntity<Jogador> Put(@PathVariable("cod_jogador") int cod_jogador, @RequestBody Jogador newJogador) {
    try {
      Optional<Jogador> oldJogador = _jogadorRepository.findById(cod_jogador);
      if (oldJogador.isPresent()) {
        Jogador jogador = oldJogador.get();
  
        jogador.setEmail(newJogador.getEmail());
        jogador.setNome(newJogador.getNome());
        jogador.setDataNasc(newJogador.getDataNasc());
        
        System.out.println(newJogador.getDataNasc());
        _jogadorRepository.save(jogador);
        return new ResponseEntity<Jogador>(jogador, HttpStatus.OK);
      }

      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } catch (Exception e) {
      System.out.println(e);
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/{cod_jogador}") // DELETAR POR ID
  public ResponseEntity<Object> DeleteById(@PathVariable("cod_jogador") int cod_jogador) {
    try {
      Optional<Jogador> jogador = _jogadorRepository.findById(cod_jogador);
      if(jogador.isPresent()){
        _jogadorRepository.delete(jogador.get());
        return new ResponseEntity<>(HttpStatus.OK);
      }
      
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping() // DELETAR TODOS
  public ResponseEntity<Object> Delete() {
    try {
      _jogadorRepository.deleteAll();
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}