package com.example.teste_spring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.teste_spring.dto.ProdutoDTO;
import com.example.teste_spring.model.Produto;
import com.example.teste_spring.repository.CategoriaRepository;
import com.example.teste_spring.service.ProdutoService;
//import com.example.teste_spring.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

private final ProdutoService produtoService;
//private final CategoriaRepository categoriaRepository;

@Autowired
public ProdutoController(ProdutoService produtoService, CategoriaRepository categoriaRepository) {
        this.produtoService = produtoService;
   //     this.categoriaRepository = categoriaRepository;
    }   

@GetMapping("/listar")
public List<ProdutoDTO> listarTodos() {
        return produtoService.listarTodos();
    }

@PostMapping("/salvar")
public Produto salvarProduto(@RequestBody Produto produto) {
    return produtoService.salvarProduto(produto); 
}
  

@PutMapping("/atualizar/id/{id}")
public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
    return produtoService.atualizarProdutoId(id, produto);
}

@PutMapping("/atualizar/nome/{nome}")
 public Produto atualizarProdutoNome(@PathVariable String nome, @RequestBody Produto produto) {
    return produtoService.atualizarProdutoNome(nome, produto);
}

@DeleteMapping("/deletar/id/{id}")
public void deletarProduto(@PathVariable Long id) {
    produtoService.deletarId(id);
}

@GetMapping("/buscar/nome/{letra}")
public List<ProdutoDTO> buscarPorNome(@PathVariable String letra) {
    return produtoService.findByfindByNomeStartingWithIgnoreCase(letra);
}

@GetMapping("/quantidade")
public long contarProdutos() {
    return produtoService.countProdutos();
}

@GetMapping("/buscar/preco/min/{min}/max/{max}")
public List<ProdutoDTO> buscarPorPreco(@PathVariable Double min, @PathVariable Double max) {
    return produtoService.findByPrecoBetween(min, max);

}

@PatchMapping("/atualizar/preco/{preco}")
public Produto atualizarPreco(@PathVariable Double preco, @RequestBody Produto produto) {
    return produtoService.atualizarProdutoPreco(preco, produto);
}

@PatchMapping("/atualizar/categoria/{nome}")
public Produto atualizarCategoria(@PathVariable String nome, @RequestBody Produto produto) {
    return produtoService.AtualizarCategoria(nome, produto);
}   

@GetMapping("/buscar/categoria/{id}")
public List<Produto> buscarPorCategoriaId(@PathVariable Long id) {
    return produtoService.findByCategoria(id);
}

@GetMapping("/buscar/categoria/nome/{nome}")
public List<ProdutoDTO> buscarPorCategoriaNome(@PathVariable String nome) {
    return produtoService.findByCategoriaNome(nome);
}

@PatchMapping("/atualizar/descricao/{nome}")
public String atualizarDescricao(@PathVariable String nome, @RequestBody ProdutoDTO produtoDTO) {
    return produtoService.salvarDescricao(nome, produtoDTO.getDescricao());
}
}


