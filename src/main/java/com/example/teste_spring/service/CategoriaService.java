package com.example.teste_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.teste_spring.repository.CategoriaRepository;
import com.example.teste_spring.model.Categoria;
import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;  

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria salvarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listarTodasCategorias() {
        return categoriaRepository.findAll();
    }
    
}
