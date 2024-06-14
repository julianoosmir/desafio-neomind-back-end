package org.example.desafio.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.desafio.dao.FornecedorDao;
import org.example.desafio.entities.Fornecedor;
import org.example.desafio.interfaces.IFornecedorService;

import java.util.List;

@ApplicationScoped
public class FornecedorService implements IFornecedorService {

    @Inject
    private FornecedorDao fornecedorDao;


    public List<Fornecedor> getAll() {
        return fornecedorDao.findall();
    }

    public Fornecedor getById(Long id) {
        return fornecedorDao.findById(id);
    }

    public void save(Fornecedor fornecedor) {
        this.fornecedorDao.create(fornecedor);
    }

    public void update(Fornecedor fornecedor) {
        this.fornecedorDao.update(fornecedor);
    }

    public Void delete(Long id) {
        this.fornecedorDao.delete(id);
        return null;
    }
}