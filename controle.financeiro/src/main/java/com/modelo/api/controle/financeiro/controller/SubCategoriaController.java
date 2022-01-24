package com.modelo.api.controle.financeiro.controller;
import static com.modelo.api.controle.financeiro.constants.endpoint.URL_REQUEST_MAPPING;
import static com.modelo.api.controle.financeiro.constants.endpoint.SUB_CATEGORIAS;
import static com.modelo.api.controle.financeiro.constants.endpoint.SUB_CATEGORIAS_ID;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.modelo.api.controle.financeiro.entity.SubCategoria;
import com.modelo.api.controle.financeiro.service.SubCategoriaServiceImpl;

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
public class SubCategoriaController {
    
    @Value("${api.key}")
    private String apiKey;

    private SubCategoriaServiceImpl subCategoriaService;

    @GetMapping(SUB_CATEGORIAS)
    public List<SubCategoria> getAllSubCategorias(@RequestHeader(name = "api-key") String headerApiKey) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("api-key", apiKey);
        if (headerApiKey.equals(apiKey)) {
            return subCategoriaService.findAll();
        } else {
            throw new ResourceNotFoundException("Api key inválida");
        }
    }

    @GetMapping(SUB_CATEGORIAS_ID)
    public ResponseEntity<SubCategoria> getSubCategoriaById(@RequestHeader(name = "api-key") String headerApiKey,
            @PathVariable(value = "id") Long SubCategoriaId)
            throws ResourceNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("api-key", apiKey);
        if (headerApiKey.equals(apiKey)) {
            SubCategoria SubCategoria = subCategoriaService.findOne(SubCategoriaId);
            return ResponseEntity.ok().body(SubCategoria);
        } else {
            throw new ResourceNotFoundException("Api key inválida");
        }
    }

    @PostMapping(SUB_CATEGORIAS)
    public SubCategoria creatSubCategoria(@RequestHeader(name = "api-key") String headerApiKey,
            @Valid @RequestBody SubCategoria SubCategoria) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("api-key", apiKey);
        if (headerApiKey.equals(apiKey)) {
            return subCategoriaService.create(SubCategoria);
        } else {
            throw new ResourceNotFoundException("Api key inválida");
        }
    }

    @PutMapping(SUB_CATEGORIAS_ID)
    public ResponseEntity<SubCategoria> updateSubCategoria(@RequestHeader(name = "api-key") String headerApiKey,
            @PathVariable(value = "id") Long SubCategoriaId,
            @Valid @RequestBody SubCategoria SubCategoriaDetails) throws ResourceNotFoundException {

        HttpHeaders headers = new HttpHeaders();
        headers.add("api-key", apiKey);
        if (headerApiKey.equals(apiKey)) {
            SubCategoria SubCategoria = subCategoriaService.update(SubCategoriaId, SubCategoriaDetails);
            return ResponseEntity.ok().body(SubCategoria);
        } else {
            throw new ResourceNotFoundException("Api key inválida");
        }
    }

    @DeleteMapping(SUB_CATEGORIAS_ID)
    public Map<String, Boolean> deleteSubCategoria(@RequestHeader(name = "api-key") String headerApiKey,
            @PathVariable(value = "id") Long SubCategoriaId)
            throws ResourceNotFoundException {

        HttpHeaders headers = new HttpHeaders();
        headers.add("api-key", apiKey);
        if (headerApiKey.equals(apiKey)) {
            subCategoriaService.deleteById(SubCategoriaId);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return response;
        } else {
            throw new ResourceNotFoundException("Api key inválida");
        }
    }
}
