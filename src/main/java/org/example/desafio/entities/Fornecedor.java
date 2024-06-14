package org.example.desafio.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


public class Fornecedor {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String comment;
    private String cnpj;

    public Fornecedor() {
    }

    public Fornecedor(Long id, String name, String email, String cnpj, String comment) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cnpj = cnpj;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}