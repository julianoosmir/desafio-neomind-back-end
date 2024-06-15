package org.example.desafio.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.desafio.entities.Fornecedor;
import jakarta.transaction.Transactional;


import java.util.List;

@ApplicationScoped
public class FornecedorRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Fornecedor> findAll(){
        return entityManager.createQuery("SELECT e FROM Fornecedor e", Fornecedor.class).getResultList();
    }

    public Fornecedor getById(int id){
        return entityManager.createQuery("SELECT e FROM Fornecedor e where e.id = :id", Fornecedor.class)
                .setParameter("id", id).getSingleResult();

    }

    @Transactional
    public void salvar(Fornecedor fornecedor) {
        this.entityManager.merge(fornecedor);
    }
    @Transactional
    public void alterar(Fornecedor fornecedor) {
        this.entityManager.createQuery("UPDATE Fornecedor f set f.name = :name, f.email = :email," +
                                        "f.comment = :comment, f.cnpj = :cnpj where f.id = :id")
                .setParameter("name", fornecedor.getName())
                .setParameter("email", fornecedor.getEmail())
                .setParameter("comment", fornecedor.getComment())
                .setParameter("cnpj", fornecedor.getCnpj())
                .setParameter("id", fornecedor.getId())
                .executeUpdate();
    }

    @Transactional
    public void deletar(Integer id) {
        this.entityManager
                .createQuery("DELETE FROM Fornecedor e WHERE e.id = :id")
                .setParameter("id", id).executeUpdate();
    }
}
