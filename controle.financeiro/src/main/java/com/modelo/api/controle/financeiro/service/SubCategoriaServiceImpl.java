package com.modelo.api.controle.financeiro.service;

import java.util.List;

import com.modelo.api.controle.financeiro.entity.SubCategoria;
import com.modelo.api.controle.financeiro.repository.SubCategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SubCategoriaServiceImpl implements IService<SubCategoria>{

    @Autowired
    private SubCategoriaRepository subCategoriaRepository;

    @Override
    public SubCategoria findOne(Long id) {
        
        return subCategoriaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("SubCategoria not found for this id :: " + id));
    }

    @Override
    public List<SubCategoria> findAll() {
        
        return subCategoriaRepository.findAll();
    }

    @Override
    public SubCategoria create(SubCategoria entity) {
        
        return subCategoriaRepository.save(entity);
    }

    @Override
    public SubCategoria update(Long entityId, SubCategoria entity) {
        SubCategoria subCategoria = subCategoriaRepository.findById(entityId).orElseThrow(() -> new ResourceNotFoundException("SubCategoria not found for this id :: " + entityId));
        subCategoria.setIdCategoria(entity.getIdCategoria());
        subCategoria.setNome(entity.getNome());
        return subCategoriaRepository.save(entity);
    }

    @Override
    public void deleteById(Long entityId) {
        subCategoriaRepository.deleteById(entityId);
    }
}
