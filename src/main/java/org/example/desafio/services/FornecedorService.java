package org.example.desafio.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.desafio.dao.FornecedorDao;
import org.example.desafio.entities.Fornecedor;
import org.example.desafio.interfaces.IFornecedorService;
import org.example.desafio.repository.FornecedorRepository;

import java.util.List;

@ApplicationScoped
public class FornecedorService implements IFornecedorService {

    @Inject
    private FornecedorDao fornecedorDao;

    @Inject
    private FornecedorRepository repository;

    public List<Fornecedor> getAll() {
        return repository.findAll();
    }

    public Fornecedor getById(int id) {
        return repository.getById(id);
    }

    public void save(Fornecedor fornecedor) {
        this.repository.salvar(fornecedor);
    }

    public void update(Fornecedor fornecedor) {
        this.repository.alterar(fornecedor);
    }

    public Void delete(int id) {
        this.repository.deletar(id);
        return null;
    }
}