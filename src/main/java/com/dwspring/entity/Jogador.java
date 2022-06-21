package com.dwspring.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity

public class Jogador {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Integer cod_jogador;

  @Column(nullable = false)
  private String nome;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private Date datanasc;

  public Jogador() {}

  public Jogador(String nome, String email, Date datanasc) {
		this.nome = nome;
		this.email = email;
		this.datanasc = datanasc;
	}

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

  public Date getDatanasc() {
    return datanasc;
  }

  public void setDatanasc(Date datanasc) {
    this.datanasc = datanasc;
  }

}