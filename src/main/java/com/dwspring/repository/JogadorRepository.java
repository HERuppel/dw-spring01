package com.dwspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dwspring.entity.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Integer> {}