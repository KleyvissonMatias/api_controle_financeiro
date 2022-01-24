package com.modelo.api.controle.financeiro.controller;

import static com.modelo.api.controle.financeiro.constants.endpoint.CATEGORIAS;
import static com.modelo.api.controle.financeiro.constants.endpoint.CATEGORIAS_ID;
import static com.modelo.api.controle.financeiro.constants.endpoint.URL_REQUEST_MAPPING;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.modelo.api.controle.financeiro.entity.Categoria;
import com.modelo.api.controle.financeiro.service.CategoriaServiceImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(URL_REQUEST_MAPPING)
public class CategoriaController {

    @Value("${api.key}")
    private String apiKey;

    private CategoriaServiceImpl categoriaService;

    @GetMapping(CATEGORIAS)
    public List<Categoria> getAllCategorias(@RequestHeader(name = "api-key") String headerApiKey) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("api-key", apiKey);
        if (headerApiKey.equals(apiKey)) {
            return categoriaService.findAll();
        } else {
            throw new ResourceNotFoundException("Api key inválida");
        }
    }

    @GetMapping(CATEGORIAS_ID)
    public ResponseEntity<Categoria> getCategoriaById(@RequestHeader(name = "api-key") String headerApiKey,
            @PathVariable(value = "id") Long CategoriaId)
            throws ResourceNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("api-key", apiKey);
        if (headerApiKey.equals(apiKey)) {
            Categoria Categoria = categoriaService.findOne(CategoriaId);
            return ResponseEntity.ok().headers(headers).body(Categoria);
        } else {
            throw new ResourceNotFoundException("Api key inválida");
        }
    }

    @PostMapping(CATEGORIAS)
    public Categoria createCategoria(@RequestHeader(name = "api-key") String headerApiKey,
            @Valid @RequestBody Categoria Categoria) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("api-key", apiKey);
        if (headerApiKey.equals(apiKey)) {
            return categoriaService.create(Categoria);
        } else {
            throw new ResourceNotFoundException("Api key inválida");
        }
    }

    @PutMapping(CATEGORIAS_ID)
    public ResponseEntity<Categoria> updateCategoria(@RequestHeader(name = "api-key") String headerApiKey,
            @PathVariable(value = "id") Long CategoriaId,
            @Valid @RequestBody Categoria CategoriaDetails) throws ResourceNotFoundException {

        HttpHeaders headers = new HttpHeaders();
        headers.add("api-key", apiKey);
        if (headerApiKey.equals(apiKey)) {
            Categoria Categoria = categoriaService.update(CategoriaId, CategoriaDetails);
            return ResponseEntity.ok().headers(headers).body(Categoria);
        } else {
            throw new ResourceNotFoundException("Api key inválida");
        }
    }

    @DeleteMapping(CATEGORIAS_ID)
    public Map<String, Boolean> deleteCategoria(@RequestHeader(name = "api-key") String headerApiKey,
            @PathVariable(value = "id") Long CategoriaId)
            throws ResourceNotFoundException {

        HttpHeaders headers = new HttpHeaders();
        headers.add("api-key", apiKey);
        if (headerApiKey.equals(apiKey)) {
            categoriaService.deleteById(CategoriaId);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return response;
        } else {
            throw new ResourceNotFoundException("Api key inválida");
        }
    }
}
