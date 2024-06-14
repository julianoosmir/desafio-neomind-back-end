package org.example.desafio.dao;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.desafio.entities.Fornecedor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
public class FornecedorDao implements InterfaceDao<Fornecedor> {

    private PreparedStatement stmt = null;

    @Override
    public void create(Fornecedor fornecedor) {
        try {
            stmt = con.prepareStatement("insert into fornecedor(name, email, comment, cnpj) values (?,?,?,?)");
            stmt.setString(1, fornecedor.getName());
            stmt.setString(2, fornecedor.getEmail());
            stmt.setString(3, fornecedor.getComment());
            stmt.setString(4, fornecedor.getCnpj());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Fornecedor> findall() {
        ResultSet rs = null;
        List<Fornecedor> fornecedores = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM FORNECEDOR");
            rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs);
                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setId(rs.getLong("id"));
                fornecedor.setName(rs.getString("name"));
                fornecedor.setComment(rs.getString("comment"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setEmail(rs.getString("email"));


                fornecedores.add(fornecedor);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fornecedores;
    }

    @Override
    public Fornecedor findById(Long id) {
        ResultSet rs = null;
        Fornecedor fornecedor = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM FORNECEDOR where id = ?");
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            fornecedor = new Fornecedor();
            while (rs.next()) {
                fornecedor.setId(rs.getLong("id"));
                fornecedor.setName(rs.getString("name"));
                fornecedor.setComment(rs.getString("comment"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setEmail(rs.getString("email"));
            }
        }catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fornecedor;
    }

    @Override
    public void update(Fornecedor fornecedor) {
        try {
            stmt = con.prepareStatement("UPDATE fornecedor set name = ?, email = ?, comment = ?, cnpj = ? where id = ?");
            stmt.setString(1, fornecedor.getName());
            stmt.setString(2, fornecedor.getEmail());
            stmt.setString(3, fornecedor.getComment());
            stmt.setString(4, fornecedor.getCnpj());
            stmt.setLong(5, fornecedor.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void delete(Long id) {
        try {
            stmt = con.prepareStatement("DELETE FROM fornecedor WHERE id = ?");
            stmt.setLong(1, id);
            stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
