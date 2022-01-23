package com.modelo.api.controle.financeiro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sub_categoria")
public class SubCategoria {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idSubCategoria;
    private String nome;
    private Long idCategoria;

    public SubCategoria () {

    }

    public SubCategoria(String nome, Long idCategoria) {
        this.nome = nome;
        this.idCategoria = idCategoria;
    }
}
