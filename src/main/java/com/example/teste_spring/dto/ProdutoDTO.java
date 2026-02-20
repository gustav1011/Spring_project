package com.example.teste_spring.dto;

import com.example.teste_spring.model.Produto;

public class ProdutoDTO {
   // private Long id; o usuario não precisa saber o ID do produto, nem a todos da categoria que ele pertence
    private String nome;
    private Double preco;
    private String categoriaNome;
    private String descricao;

    public ProdutoDTO(Produto produto) {
        //this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.descricao = produto.getDescricao();
        this.categoriaNome = (produto.getCategoria() != null) 
                ? produto.getCategoria().getNome() 
                : null;
    }

    public ProdutoDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getCategoriaNome() {
        return categoriaNome;
    }

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // getters e setters
}
