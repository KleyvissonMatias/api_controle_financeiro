package com.modelo.api.controle.financeiro.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.modelo.api.controle.financeiro.entity.Categoria;
import com.modelo.api.controle.financeiro.service.CategoriaService;

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
import static com.modelo.api.controle.financeiro.constants.endpoint.URL_REQUEST_MAPPING;
import static com.modelo.api.controle.financeiro.constants.endpoint.CATEGORIAS;
import static com.modelo.api.controle.financeiro.constants.endpoint.CATEGORIAS_ID;

@RestController
@RequestMapping(URL_REQUEST_MAPPING)
public class CategoriaController {

    private CategoriaService categoriaService;

    @GetMapping(CATEGORIAS)
    public List<Categoria> getAllCategorias() {
        return categoriaService.getAllCategorias();
    }

    @GetMapping(CATEGORIAS_ID)
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable(value = "id") Long CategoriaId)
            throws ResourceNotFoundException {

        Categoria Categoria = categoriaService.getCategoriaById(CategoriaId);

        return ResponseEntity.ok().body(Categoria);
    }

    @PostMapping(CATEGORIAS)
    public Categoria createCategoria(@Valid @RequestBody Categoria Categoria) {

        return categoriaService.createCategoria(Categoria);
    }

    @PutMapping(CATEGORIAS_ID)
    public ResponseEntity<Categoria> updateCategoria(@PathVariable(value = "id") Long CategoriaId,
            @Valid @RequestBody Categoria CategoriaDetails) throws ResourceNotFoundException {

        Categoria categoriaUpdated = categoriaService.updateCategoria(CategoriaId, CategoriaDetails);

        return ResponseEntity.ok(categoriaUpdated);
    }

    @DeleteMapping(CATEGORIAS_ID)
    public Map<String, Boolean> deleteCategoria(@PathVariable(value = "id") Long CategoriaId)
            throws ResourceNotFoundException {

        categoriaService.deleteCategoria(CategoriaId);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
