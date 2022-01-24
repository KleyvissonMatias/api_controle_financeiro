package com.modelo.api.controle.financeiro.repository;

import com.modelo.api.controle.financeiro.entity.Lancamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Integer> {
    
}
