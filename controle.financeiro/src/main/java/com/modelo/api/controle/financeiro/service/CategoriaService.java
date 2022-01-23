package com.modelo.api.controle.financeiro.service;

import java.util.List;

import com.modelo.api.controle.financeiro.entity.Categoria;
import com.modelo.api.controle.financeiro.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
   
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria getCategoriaById(Long CategoriaId) {
        return categoriaRepository.findById(CategoriaId).orElseThrow(() -> new ResourceNotFoundException("Categoria not found for this id :: " + CategoriaId));
    }

    public Categoria createCategoria(Categoria Categoria) {
        return categoriaRepository.save(Categoria);
    }

    public Categoria updateCategoria(Long CategoriaId, Categoria CategoriaDetails) {
        Categoria Categoria = categoriaRepository.findById(CategoriaId).orElseThrow(() -> new ResourceNotFoundException("Categoria not found for this id :: " + CategoriaId));
        Categoria.setNome(CategoriaDetails.getNome());
        return categoriaRepository.save(Categoria);
    }

    public void deleteCategoria(Long CategoriaId) {
        categoriaRepository.deleteById(CategoriaId);
    }
}
