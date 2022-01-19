package com.modelo.api.controle.financeiro.controller;

import java.util.List;

import com.modelo.api.controle.financeiro.entity.Balanco;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BalancoController {
    
    @GetMapping("/Balanco")
    public List<Balanco> getAllCategorias() {
        return null;
    }
}
