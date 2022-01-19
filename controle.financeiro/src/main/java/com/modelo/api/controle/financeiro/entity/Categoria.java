package com.modelo.api.controle.financeiro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Categoria {

    @Id
    @GeneratedValue
    private Long idCategoria;
    private String nome;

    public Categoria() {
        
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

}
