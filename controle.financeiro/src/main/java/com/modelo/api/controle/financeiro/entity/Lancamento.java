package com.modelo.api.controle.financeiro.entity;

import java.util.Date;

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
@Table(name = "lancamento")
public class Lancamento {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idLancamento;
    private String nome;
    private Double valor;
    private Date data;
    private int idSubCategoria;
    private String comentario;

    public Lancamento() {

    }

    public Lancamento(String nome, Double valor, Date data, int idSubCategoria, String comentario) {
        this.nome = nome;
        this.valor = valor;
        this.data = data;
        this.idSubCategoria = idSubCategoria;
        this.comentario = comentario;
    }
}
