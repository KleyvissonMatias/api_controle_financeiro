package com.modelo.api.controle.financeiro.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.modelo.api.controle.financeiro.entity.Categoria;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CategoriaController {
    
    @GetMapping("/Categorias")
    public List<Categoria> getAllCategorias() {
        return null;
    }

    @GetMapping("/Categorias/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable(value = "id") Long CategoriaId)
        throws ResourceNotFoundException {
        return null;
    }
    
    @PostMapping("/Categorias")
    public Categoria createCategoria(@Valid @RequestBody Categoria Categoria) {
        return null;
    }

    @PutMapping("/Categorias/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable(value = "id") Long CategoriaId,
         @Valid @RequestBody Categoria CategoriaDetails) throws ResourceNotFoundException {
        return null;
    }

    @DeleteMapping("/Categorias/{id}")
    public Map<String, Boolean> deleteCategoria(@PathVariable(value = "id") Long CategoriaId)
         throws ResourceNotFoundException {
        return null;
    }
}
