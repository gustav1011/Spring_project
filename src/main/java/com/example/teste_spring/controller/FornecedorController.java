package com.example.teste_spring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.teste_spring.model.Fornecedor;
import com.example.teste_spring.service.FornecedorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/fornecedor")
public class FornecedorController {

    private final FornecedorService fornecedorService;


    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }
@PostMapping("/salvar")
public Fornecedor salvar(@RequestBody @Valid Fornecedor fornecedor) {
    return fornecedorService.salvarFornecedor(fornecedor);
}

@GetMapping("/listar")
    public List<Fornecedor> listarFornecedores() {
        return fornecedorService.listarFornecedores();
    }

@GetMapping("/listar/cidade/{cidade}")
    public List<Fornecedor> listarFornecedoresPorCidade(@PathVariable String cidade) {
        return fornecedorService.listarFornecedoresPorCidade(cidade);
    }

    @GetMapping("/listar/id/{id}")
    public Fornecedor listarPorId(@PathVariable Long id) {
        return fornecedorService.buscarPorId(id);
    }




    
}
