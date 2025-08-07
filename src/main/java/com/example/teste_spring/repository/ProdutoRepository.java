package com.example.teste_spring.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.example.teste_spring.model.Categoria;
import com.example.teste_spring.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Aqui você pode adicionar métodos personalizados se necessário
Produto findByNome(String nome);
//Produto atualizarProdutoPreco(Double preco,Produto produto);
List<Produto> findByNomeStartingWithIgnoreCase(String letra);
//Produto atualizarProdutoNome(String nome, Produto produtoAtualizado);
//Produto atualizarProdutoPreco(Double preco, Produto produto);
List<Produto> findByPrecoBetween(Double min, Double max);
//List<Produto> findByCategoria(Long categoriaId); // Método para buscar produtos por categoria
List<Produto> findByCategoriaNome(String nome);



}
