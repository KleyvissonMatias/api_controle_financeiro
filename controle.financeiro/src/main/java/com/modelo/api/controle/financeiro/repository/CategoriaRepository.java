package com.modelo.api.controle.financeiro.repository;

import com.modelo.api.controle.financeiro.entity.Categoria;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long>, JpaSpecificationExecutor<Categoria>  {
    
}
