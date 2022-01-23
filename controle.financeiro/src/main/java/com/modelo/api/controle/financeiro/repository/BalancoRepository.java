package com.modelo.api.controle.financeiro.repository;

import com.modelo.api.controle.financeiro.entity.Balanco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalancoRepository extends JpaRepository<Balanco, Long> {
    
}