package com.dwspring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dwspring.entity.Pagamento;
import com.dwspring.entity.Jogador;
import com.dwspring.repository.PagamentoRepository;
import com.dwspring.repository.JogadorRepository;

@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController {
  @Autowired
  private PagamentoRepository _pagamentoRepository;
  @Autowired
  private JogadorRepository _jogadorRepository;

  @PostMapping("/{cod_jogador}") // CRIAR
  public ResponseEntity<Pagamento> Post(@PathVariable("cod_jogador") int cod_jogador, @RequestBody Pagamento pagamento) {
    try {
      Optional<Jogador> _j = _jogadorRepository.findById(cod_jogador);
      
      if(_j.isPresent()) {
        Jogador jogador = _j.get();
        Pagamento _p = _pagamentoRepository.save(new Pagamento(pagamento.getAno(), pagamento.getMes(), pagamento.getValor(), jogador));
        return new ResponseEntity<Pagamento>(_p, HttpStatus.CREATED);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping() // LISTAR TODOS
  public ResponseEntity<List<Pagamento>> Get() {
    try {
      List<Pagamento> _j = _pagamentoRepository.findAll();

      if (_j.isEmpty())
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

      return new ResponseEntity<>(_j, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  @GetMapping("/{cod_jogador}") // RECUPERAR PELO JOGADOR
  public ResponseEntity<List<Pagamento>> GetByJogador(@PathVariable("cod_jogador") int cod_jogador) {
    try {
      Optional<Jogador> _j = _jogadorRepository.findById(cod_jogador);
      
      if(_j.isPresent()) {
        List<Pagamento> _p = _pagamentoRepository.findByJogador(_j.get());
  
        if (_p.isEmpty())
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  
        return new ResponseEntity<>(_p, HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}