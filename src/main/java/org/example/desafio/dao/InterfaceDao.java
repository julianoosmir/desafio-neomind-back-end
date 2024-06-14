package org.example.desafio.dao;

import org.example.desafio.server.ConnectionFactory;

import java.sql.Connection;
import java.util.List;

public interface InterfaceDao<T> {
    Connection con = ConnectionFactory.getConnection();
    void create(T t);
    List<T> findall();
    T findById(Long id);
    void delete(Long id);
}