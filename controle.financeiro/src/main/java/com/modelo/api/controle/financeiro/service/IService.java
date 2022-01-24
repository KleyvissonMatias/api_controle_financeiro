package com.modelo.api.controle.financeiro.service;

import java.util.List;

public interface IService<T> {
    
    T findOne(int id);

    List<T> findAll();

    T create(T entity);

    T update(int entityId, T entity);

    void deleteById(int entityId);
}
