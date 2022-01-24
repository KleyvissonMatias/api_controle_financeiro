package com.modelo.api.controle.financeiro.service;

import java.util.List;

import com.modelo.api.controle.financeiro.entity.Categoria;
import com.modelo.api.controle.financeiro.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements ICategoriaService<Categoria> {
   
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria findOne(Long CategoriaId) {
        return categoriaRepository.findById(CategoriaId).orElseThrow(() -> new ResourceNotFoundException("Categoria not found for this id :: " + CategoriaId));
    }

    @Override
    public Categoria create(Categoria Categoria) {
        return categoriaRepository.save(Categoria);
    }

    @Override
    public Categoria update(Long CategoriaId, Categoria CategoriaDetails) {
        Categoria Categoria = categoriaRepository.findById(CategoriaId).orElseThrow(() -> new ResourceNotFoundException("Categoria not found for this id :: " + CategoriaId));
        Categoria.setNome(CategoriaDetails.getNome());
        return categoriaRepository.save(Categoria);
    }

    @Override
    public void deleteById(Long CategoriaId) {
        categoriaRepository.deleteById(CategoriaId);
    }
}
