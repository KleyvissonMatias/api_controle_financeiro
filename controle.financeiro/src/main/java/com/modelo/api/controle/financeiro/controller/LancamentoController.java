package com.modelo.api.controle.financeiro.controller;
import static com.modelo.api.controle.financeiro.constants.endpoint.URL_REQUEST_MAPPING;
import static com.modelo.api.controle.financeiro.constants.endpoint.LANCAMENTOS;
import static com.modelo.api.controle.financeiro.constants.endpoint.LANCAMENTOS_ID;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.modelo.api.controle.financeiro.entity.Lancamento;
import com.modelo.api.controle.financeiro.service.LancamentoServiceImpl;

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
public class LancamentoController {
    
    @Value("${api.key}")
    private String apiKey;

    private LancamentoServiceImpl lancamentoService;

    @GetMapping(LANCAMENTOS)
    public List<Lancamento> getAllLancamentos(@RequestHeader(name = "api-key") String headerApiKey) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("api-key", apiKey);
        if (headerApiKey.equals(apiKey)) {
            return lancamentoService.findAll();
        } else {
            throw new ResourceNotFoundException("Api key inválida");
        }
    }

    @GetMapping(LANCAMENTOS_ID)
    public ResponseEntity<Lancamento> getLancamentoById(@RequestHeader(name = "api-key") String headerApiKey,
            @PathVariable(value = "id") int LancamentoId)
            throws ResourceNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("api-key", apiKey);
        if (headerApiKey.equals(apiKey)) {
            Lancamento lancamento = lancamentoService.findOne(LancamentoId);
            return ResponseEntity.ok().body(lancamento);
        } else {
            throw new ResourceNotFoundException("Api key inválida");
        }
    }

    @PostMapping(LANCAMENTOS)
    public Lancamento creatLancamento(@RequestHeader(name = "api-key") String headerApiKey,
            @Valid @RequestBody Lancamento Lancamento) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("api-key", apiKey);
        if (headerApiKey.equals(apiKey)) {
            return lancamentoService.create(Lancamento);
        } else {
            throw new ResourceNotFoundException("Api key inválida");
        }
    }

    @PutMapping(LANCAMENTOS_ID)
    public ResponseEntity<Lancamento> updateLancamento(@RequestHeader(name = "api-key") String headerApiKey,
            @PathVariable(value = "id") int LancamentoId,
            @Valid @RequestBody Lancamento LancamentoDetails) throws ResourceNotFoundException {

        HttpHeaders headers = new HttpHeaders();
        headers.add("api-key", apiKey);
        if (headerApiKey.equals(apiKey)) {
            Lancamento Lancamento = lancamentoService.update(LancamentoId, LancamentoDetails);
            return ResponseEntity.ok().body(Lancamento);
        } else {
            throw new ResourceNotFoundException("Api key inválida");
        }
    }

    @DeleteMapping(LANCAMENTOS_ID)
    public Map<String, Boolean> deleteLancamento(@RequestHeader(name = "api-key") String headerApiKey,
            @PathVariable(value = "id") int LancamentoId)
            throws ResourceNotFoundException {

        HttpHeaders headers = new HttpHeaders();
        headers.add("api-key", apiKey);
        if (headerApiKey.equals(apiKey)) {
            lancamentoService.deleteById(LancamentoId);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return response;
        } else {
            throw new ResourceNotFoundException("Api key inválida");
        }
    }
}
