package com.example.teste_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.teste_spring.model.Categoria;
import com.example.teste_spring.service.CategoriaService;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) { // contrutor para injeção de dependência
        this.categoriaService = categoriaService;
    }

    @PostMapping("/salvarCategoria")
    public Categoria salvarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.salvarCategoria(categoria);
    }

    @GetMapping("/listarCategorias")
    public List<Categoria> listarTodasCategorias() {
        return categoriaService.listarTodasCategorias();
    }
    
    @GetMapping("/quantidadeCategorias")
        public int quantidadeCategorias() {
            return categoriaService.listarTodasCategorias().size();
        }

    @DeleteMapping("/deletarCategoria/{id}")
        public void deletarCategoria(@PathVariable Long id) {
            categoriaService.deletarCategoria(id);
    }
}
    

