package com.modelo.api.controle.financeiro.service;

import java.util.List;

import com.modelo.api.controle.financeiro.entity.Lancamento;
import com.modelo.api.controle.financeiro.repository.LancamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LancamentoServiceImpl implements IService<Lancamento>{

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Override
    public Lancamento findOne(Long id) {
        
        return lancamentoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Lançamento not found for this id :: " + id));
    }

    @Override
    public List<Lancamento> findAll() {
        
        return lancamentoRepository.findAll();
    }

    @Override
    public Lancamento create(Lancamento entity) {
        
        return lancamentoRepository.save(entity);
    }

    @Override
    public Lancamento update(Long entityId, Lancamento entity) {
        Lancamento lancamento = lancamentoRepository.findById(entityId).orElseThrow(() -> new ResourceNotFoundException("Lançamento not found for this id :: " + entityId));
        lancamento.setNome(entity.getNome());
        lancamento.setValor(entity.getValor());
        lancamento.setData(entity.getData());
        lancamento.setIdSubCategoria(entity.getIdSubCategoria());
        lancamento.setComentario(entity.getComentario());
        return lancamentoRepository.save(entity);
    }

    @Override
    public void deleteById(Long entityId) {
        lancamentoRepository.deleteById(entityId);
    }
}
