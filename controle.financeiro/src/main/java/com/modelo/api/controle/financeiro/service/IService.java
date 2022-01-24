package com.modelo.api.controle.financeiro.service;

import java.util.List;

public interface IService<T> {
    
    T findOne(Long id);

    List<T> findAll();

    T create(T entity);

    T update(Long entityId, T entity);

    void deleteById(Long entityId);
}
