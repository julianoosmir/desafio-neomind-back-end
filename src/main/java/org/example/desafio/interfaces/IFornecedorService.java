package org.example.desafio.interfaces;


import org.example.desafio.entities.Fornecedor;

import java.util.List;

public interface IFornecedorService {

    List<Fornecedor> getAll();
    Fornecedor getById(int id);
    void save(Fornecedor fornecedor);
    void update(Fornecedor fornecedor);
    Void delete(int fornecedor);
}