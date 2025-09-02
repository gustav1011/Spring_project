package com.example.teste_spring.unit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.teste_spring.model.Produto;
import com.example.teste_spring.repository.ProdutoRepository;
import com.example.teste_spring.service.ProdutoService;


@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTest {

    public ProdutoServiceTest() {
    }

    @InjectMocks
    private ProdutoService produtoService;

    @Mock
    private ProdutoRepository produtoRepository;

    @Test
    public void retornaProdutos(){
        Produto produto1 = new Produto(1L, "Produto A", 10.0, null, null);
    System.out.println(produtoService.listarTodos());
}

//@Test


}
