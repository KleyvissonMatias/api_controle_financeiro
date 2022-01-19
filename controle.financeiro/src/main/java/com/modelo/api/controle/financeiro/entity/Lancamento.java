package com.modelo.api.controle.financeiro.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Lancamento {
    
    @Id
    @GeneratedValue
    private Long idLancamento;
    private String nome;
    private Double valor;
    private Date data;
    private Long idSubCategoria;
    private String comentario;

    public Lancamento() {
        
    }

    public Lancamento(String nome, Double valor, Date data, Long idSubCategoria, String comentario) {
        this.nome = nome;
        this.valor = valor;
        this.data = data;
        this.idSubCategoria = idSubCategoria;
        this.comentario = comentario;
    }

    
}
