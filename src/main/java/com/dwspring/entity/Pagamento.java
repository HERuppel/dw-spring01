package com.dwspring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity

public class Pagamento {
  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pagamento_sequence")
  @SequenceGenerator(name="pagamento_sequence", sequenceName="pagamento_sequence")
  private Integer cod_pagamento;

  @Column(nullable = false)
  private Integer ano;

  @Column(nullable = false)
  private Integer mes;

  @Column(nullable = false)
  private Double valor;

  @ManyToOne
  @JoinColumn(name = "cod_jogador")
  private Jogador jogador;

  public Pagamento () {}

  public Pagamento (Integer ano, Integer mes, Double valor, Jogador jogador) {
    this.ano = ano;
    this.mes = mes;
    this.valor = valor;
    this.jogador = jogador;
  }
    
  public Integer getId() {
    return cod_pagamento;
  }

  public void setId(Integer cod_pagamento) {
    this.cod_pagamento = cod_pagamento;
}

  public Integer getAno() {
    return ano;
  }

  public void setAno(Integer ano) {
    this.ano = ano;
  }

  public Integer getMes() {
    return mes;
  }

  public void setMes(Integer mes) {
    this.mes = mes;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }
  
  public Jogador getJogador() {
    return jogador;
  }

  public void setJogador(Jogador Jogador) {
    this.jogador = Jogador;
  }
}