package com.dwspring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Pagamento {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
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
}