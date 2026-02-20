package com.example.teste_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.teste_spring.model.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

   // List<Fornecedor> listarFornecedoresPorCidade(String cidade);

    List<Fornecedor> findByCidade(String cidade);

    //public List<Fornecedor> listarPorId(Long id);

    //List<Fornecedor> findByPrimeiraLetra(String letra);


   

}
