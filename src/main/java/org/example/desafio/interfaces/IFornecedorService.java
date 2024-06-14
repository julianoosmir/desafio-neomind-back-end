package org.example.desafio.interfaces;


import org.example.desafio.entities.Fornecedor;

import java.util.List;

public interface IFornecedorService {

    List<Fornecedor> getAll();
    Fornecedor getById(Long id);
    List<Fornecedor> save(Fornecedor fornecedor);
    Fornecedor update(Fornecedor fornecedor);
    Void delete(Long fornecedor);
}