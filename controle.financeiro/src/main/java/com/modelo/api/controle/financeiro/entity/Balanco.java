package com.modelo.api.controle.financeiro.entity;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Balanco {
    private Categoria categoria;
    private Double receita;
    private Double despesa;
    private Double saldo;

    public Balanco() {

    }

    public Balanco(Categoria categoria, Double receita, Double despesa, Double saldo) {
        this.categoria = categoria;
        this.receita = receita;
        this.despesa = despesa;
        this.saldo = saldo;
    }
}

