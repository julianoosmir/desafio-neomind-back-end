package org.example.desafio.services;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.desafio.entities.Fornecedor;
import org.example.desafio.interfaces.IFornecedorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
public class FornecedorService implements IFornecedorService {

    List<Fornecedor> fornecedores = new ArrayList<>();
    public FornecedorService() {
        fornecedores.add(new Fornecedor(1L,"joao","joao","0000000","teste"));
        fornecedores.add(new Fornecedor(2L,"joaquim","joaquim","111111","teste2"));
        fornecedores.add(new Fornecedor(3L,"paoulo","paoulo","3333333","teste3"));
        fornecedores.add(new Fornecedor(4L,"tiago","tiago","3333333333","teste49"));
    }

    public List<Fornecedor> getAll() {
        return fornecedores;
    }
    public Fornecedor getById(Long id) {
        return fornecedores.stream().filter(fornecedor -> fornecedor.getId().equals(id)).findFirst().orElse(null);
    }
    public List<Fornecedor> save(Fornecedor fornecedor) {
        fornecedor.setId(Long.valueOf(fornecedores.size() + 1));
        fornecedores.add(fornecedor);
        return fornecedores;
    }

    public Fornecedor update(Fornecedor fornecedor) {
        for(Fornecedor fo : fornecedores) {
            if(fo.getId().equals(fornecedor.getId())) {
                fo.setCnpj(fornecedor.getCnpj());
                fo.setEmail(fornecedor.getEmail());
                fo.setComment(fornecedor.getComment());
                fo.setName(fornecedor.getName());
            }
        }
        return fornecedor;
    }

    public Void delete(Long id) {
        fornecedores = fornecedores.stream()
                .filter(fornecedor -> !Objects.equals(fornecedor.getId(), id))
                .collect(Collectors.toList());
        return null;
    }
}