package com.dwspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dwspring.entity.Pagamento;
import com.dwspring.entity.Jogador;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
  List<Pagamento> findByJogador(Jogador jogador);
}