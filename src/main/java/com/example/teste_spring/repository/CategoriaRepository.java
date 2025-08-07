package com.example.teste_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.teste_spring.model.Categoria;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
    //List<Produto> findByCategoria(String categoria); // Método para buscar produtos por categoria
  List<Categoria> findByNome(String letra);
}
