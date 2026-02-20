package com.example.teste_spring.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teste_spring.model.Fornecedor;
import com.example.teste_spring.repository.FornecedorRepository;

@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    @Autowired
    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public Fornecedor salvarFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> listarFornecedores() {
        return fornecedorRepository.findAll();
    }

    public List<Fornecedor> listarFornecedoresPorCidade(String cidade) {
        return fornecedorRepository.findByCidade(cidade);
    }

 public Fornecedor buscarPorId(Long id) {
    return fornecedorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
}

    

           
}

    
    

