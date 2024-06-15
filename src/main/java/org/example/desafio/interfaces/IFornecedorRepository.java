package org.example.desafio.interfaces;

import org.example.desafio.entities.Fornecedor;

import java.util.List;

public interface IFornecedorRepository {
    void create(Fornecedor t);
    List<Fornecedor> findAll();
    Fornecedor findById(int id);
    void update(Fornecedor fornecedor);
    void deletar(Integer id);
}
