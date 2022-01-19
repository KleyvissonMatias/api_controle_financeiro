package com.modelo.api.controle.financeiro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SubCategoria {
    
    @Id
    @GeneratedValue
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
