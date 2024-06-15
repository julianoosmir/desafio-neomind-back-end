package org.example.desafio.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.desafio.entities.Fornecedor;
import org.example.desafio.interfaces.IFornecedorRepository;
import org.example.desafio.interfaces.IFornecedorService;


import java.util.List;

@ApplicationScoped
public class FornecedorService implements IFornecedorService {

    @Inject
    private IFornecedorRepository repository;

    public List<Fornecedor> getAll() {
        return repository.findAll();
    }

    public Fornecedor getById(int id) {
        return repository.findById(id);
    }

    public void save(Fornecedor fornecedor) {
        this.repository.create(fornecedor);
    }

    public void update(Fornecedor fornecedor) {
        this.repository.update(fornecedor);
    }

    public Void delete(int id) {
        this.repository.deletar(id);
        return null;
    }
}