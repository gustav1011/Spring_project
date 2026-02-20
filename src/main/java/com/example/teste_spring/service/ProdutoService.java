package com.example.teste_spring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teste_spring.dto.ProdutoDTO;
import com.example.teste_spring.model.Produto;
import com.example.teste_spring.repository.CategoriaRepository;
import com.example.teste_spring.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    // Construtor
    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    // Listar todos os produtos
    public List<ProdutoDTO> listarTodos() {
        return produtoRepository.findAll().stream()
                .map(ProdutoDTO::new)
                .collect(Collectors.toList());
    }

    // Salvar novo produto
    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    // Atualizar produto pelo ID
    public Produto atualizarProdutoId(Long id, Produto produto) {
        if (produtoRepository.existsById(id)) {
            produto.setId(id);
            return produtoRepository.save(produto);
        } else {
            throw new RuntimeException("Produto não encontrado com o ID: " + id);
        }
    }

    // Atualizar preço com base no nome
    public Produto atualizarProdutoPreco(Double preco, Produto produto) {
        Produto produtoExistente = produtoRepository.findByNome(produto.getNome());
        if (produtoExistente == null) {
            throw new RuntimeException("Produto não encontrado com o nome: " + produto.getNome());
        }

        produtoExistente.setPreco(preco);
        return produtoRepository.save(produtoExistente);
    }

    // Atualizar nome do produto a partir de outro nome
    public Produto atualizarProdutoNome(String nome, Produto produtoAtualizado) {
        Produto produtoExistente = produtoRepository.findByNome(nome);
        if (produtoExistente == null) {
            throw new RuntimeException("Produto não encontrado com o nome: " + nome);
        }

        produtoExistente.setNome(produtoAtualizado.getNome());
        // Atualize outros campos conforme necessidade
        return produtoRepository.save(produtoExistente);
    }

    // Deletar produto por ID
    public void deletarId(Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            System.out.println("Produto deletado com sucesso!");
        } else {
            throw new RuntimeException("Produto não encontrado com o ID: " + id);
        }
    }

    // Buscar produtos cujo nome começa com uma letra (ignorando case)
    public List<ProdutoDTO> findByfindByNomeStartingWithIgnoreCase(String letra) {
        if(letra == null || letra.isEmpty()) {
            throw new IllegalArgumentException("A letra não pode ser nula ou vazia");
        }else if('0'<= letra.charAt(0) && letra.charAt(0) <= '9') {
            throw new IllegalArgumentException("A letra não pode ser um número");
        } else{
        if (letra.charAt(0) == '*') {
            letra = letra.substring(1);
        }
        return produtoRepository.findByNomeStartingWithIgnoreCase(letra).stream()
                .map(ProdutoDTO::new)
                .collect(Collectors.toList());
        }
    }


    // Contar número de produtos
    public int countProdutos() {
        return (int) produtoRepository.count();
    }

    // Buscar produtos por faixa de preço
    public List<ProdutoDTO> findByPrecoBetween(Double min, Double max) {
        if (min == null || max == null) {
            throw new IllegalArgumentException("Valores mínimos e máximos não podem ser nulos");
        }
        if (min > max) {
            throw new IllegalArgumentException("O valor mínimo não pode ser maior que o máximo");
        }

        return produtoRepository.findAll()
                .stream()
                .map(ProdutoDTO::new)
                .filter(produto ->
                                   produto.getPreco() >= min &&
                                   produto.getPreco() <= max)
                .collect(Collectors.toList());
    }

    public Produto AtualizarCategoria(String nome, Produto produto) {
        Produto produtoExistente = produtoRepository.findByNome(nome);
        if (produtoExistente == null) {
            throw new RuntimeException("Produto não encontrado com o nome: " + nome);
        }
        produtoExistente.setCategoria(produto.getCategoria());
        return produtoRepository.save(produtoExistente);
    }


    // Buscar produtos por categoria ID, método que verifica se a categoria existe(mais indicado para o adm, usuario não precisa saber o ID da categoria)
   public List<Produto> findByCategoria(Long categoriaId) {
        categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada com o ID: " + categoriaId));
        return produtoRepository.findAll().stream()
                .filter(produto -> produto.getCategoria() != null && produto.getCategoria().getCategoriaId().equals(categoriaId))
                .collect(Collectors.toList());
   }
        
  public List<ProdutoDTO> findByCategoriaNome(String nome) {
    if (nome == null || nome.isEmpty()) {
        throw new IllegalArgumentException("O nome da categoria não pode ser nulo ou vazio");
    }
    return produtoRepository.findByCategoriaNome(nome)
                            .stream()
                            .map(ProdutoDTO::new)
                            .collect(Collectors.toList());
}

 public String salvarDescricao(String nome,String descricao){
    Produto produtoExistente = produtoRepository.findByNome(nome);
    if (produtoExistente == null) {
        throw new RuntimeException("Produto não encontrado com o nome: " + nome);
    }
    produtoExistente.setDescricao(descricao);
    produtoRepository.save(produtoExistente);
    return "Descrição atualizada com sucesso!"; 
 }



}
