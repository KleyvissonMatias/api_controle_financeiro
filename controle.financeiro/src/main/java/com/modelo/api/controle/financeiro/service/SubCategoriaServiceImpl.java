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
    public SubCategoria findOne(int id) {
        
        return subCategoriaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("SubCategoria com este ID não existe :: " + id));
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
    public SubCategoria update(int entityId, SubCategoria entity) {
        SubCategoria subCategoria = subCategoriaRepository.findById(entityId).orElseThrow(() -> new ResourceNotFoundException("SubCategoria com este ID não existe :: " + entityId));
        subCategoria.setIdCategoria(entity.getIdCategoria());
        subCategoria.setNome(entity.getNome());
        return subCategoriaRepository.save(entity);
    }

    @Override
    public void deleteById(int entityId) {
        subCategoriaRepository.deleteById(entityId);
    }
}
