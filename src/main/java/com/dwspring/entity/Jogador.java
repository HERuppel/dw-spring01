package com.dwspring.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Jogador {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer cod_jogador;

  @Column(nullable = false)
  private String nome;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private Date datanasc;

  public Integer getId() {
    return cod_jogador;
  }

  public void setId(Integer cod_jogador) {
    this.cod_jogador = cod_jogador;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getDataNasc() {
    return datanasc;
  }

  public void setDataNasc(Date datanasc) {
    this.datanasc = datanasc;
  }

}