package com.modelo.api.controle.financeiro.repository;

import com.modelo.api.controle.financeiro.entity.SubCategoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoriaRepository extends JpaRepository<SubCategoria, Integer> {
    
}
