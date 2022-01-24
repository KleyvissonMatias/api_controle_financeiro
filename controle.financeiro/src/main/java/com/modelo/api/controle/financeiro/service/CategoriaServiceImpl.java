package com.modelo.api.controle.financeiro.service;

import java.util.List;

import com.modelo.api.controle.financeiro.entity.Categoria;
import com.modelo.api.controle.financeiro.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements IService<Categoria> {
   
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria findOne(int CategoriaId) {
        return categoriaRepository.findById(CategoriaId).orElseThrow(() -> new ResourceNotFoundException("Categoria com este ID não existe :: " + CategoriaId));
    }
    
    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria create(Categoria Categoria) {
        return categoriaRepository.save(Categoria);
    }

    @Override
    public Categoria update(int CategoriaId, Categoria CategoriaDetails) {
        Categoria Categoria = categoriaRepository.findById(CategoriaId).orElseThrow(() -> new ResourceNotFoundException("Categoria com este ID não existe :: " + CategoriaId));
        Categoria.setNome(CategoriaDetails.getNome());
        return categoriaRepository.save(Categoria);
    }

    @Override
    public void deleteById(int CategoriaId) {
        categoriaRepository.deleteById(CategoriaId);
    }
}
