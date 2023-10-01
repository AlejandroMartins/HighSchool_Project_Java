/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Modelagem.*;

/**
 *
 * @author Samuelson
 */
public class FornecedorDAO {

    public void create(Fornecedor p) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO Fornecedor (nome,cnpj,email,celular,cep,rua,cidade,estado,bairro,complemento,numero)VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCnpj());
            stmt.setString(3, p.getEmail());
            stmt.setString(4, p.getCelular());
            stmt.setString(5, p.getCep());
            stmt.setString(6, p.getRua());
            stmt.setString(7, p.getCidade());
            stmt.setString(8, p.getEstado());
            stmt.setString(9, p.getBairro());
            stmt.setString(10, p.getComplemento());
            stmt.setInt(11, p.getNumero());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Fornecedor> read() {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Fornecedor> Fornecedor = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Fornecedor");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Fornecedor p = new Fornecedor();

                p.setId(rs.getInt("id_fornecedor"));
                p.setNome(rs.getString("nome"));
                p.setCnpj(rs.getString("cnpj"));
                p.setEmail(rs.getString("email"));
                p.setCelular(rs.getString("celular"));
                p.setCep(rs.getString("cep"));
                p.setRua(rs.getString("rua"));
                p.setCidade(rs.getString("cidade"));
                p.setEstado(rs.getString("estado"));
                p.setBairro(rs.getString("bairro"));
                p.setComplemento(rs.getString("complemento"));
                p.setNumero(rs.getInt("numero"));

                Fornecedor.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Fornecedor;

    }

    public List<Fornecedor> readForDesc(String desc) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Fornecedor> Fornecedors = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Fornecedor WHERE nome LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Fornecedor p = new Fornecedor();
                p.setId(rs.getInt("id_fornecedor"));
                p.setNome(rs.getString("nome"));
                p.setCnpj(rs.getString("cnpj"));
                p.setEmail(rs.getString("email"));
                p.setCelular(rs.getString("celular"));
                p.setCep(rs.getString("cep"));
                p.setRua(rs.getString("rua"));
                p.setCidade(rs.getString("cidade"));
                p.setEstado(rs.getString("estado"));
                p.setBairro(rs.getString("bairro"));
                p.setComplemento(rs.getString("complemento"));
                p.setNumero(rs.getInt("numero"));
                Fornecedors.add(p);

            }

        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Fornecedors;

    }

    public Fornecedor readDesc(String desc) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Fornecedor p = new Fornecedor();

        try {
            stmt = con.prepareStatement("SELECT * FROM Fornecedor WHERE nome LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                p.setId(rs.getInt("id_fornecedor"));
                p.setNome(rs.getString("nome"));
                p.setCnpj(rs.getString("cnpj"));
                p.setEmail(rs.getString("email"));
                p.setCelular(rs.getString("celular"));
                p.setCep(rs.getString("cep"));
                p.setRua(rs.getString("rua"));
                p.setCidade(rs.getString("cidade"));
                p.setEstado(rs.getString("estado"));
                p.setBairro(rs.getString("bairro"));
                p.setComplemento(rs.getString("complemento"));
                p.setNumero(rs.getInt("numero"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return p;

    }

    public void update(Fornecedor p) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Fornecedor SET nome = ? ,cnpj = ?, email = ? ,celular = ?,cep = ?,rua = ?, cidade = ?, estado = ?, bairro = ?, complemento = ?, numero = ? WHERE id_Fornecedor = ?");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCnpj());
            stmt.setString(3, p.getEmail());
            stmt.setString(4, p.getCelular());
            stmt.setString(5, p.getCep());
            stmt.setString(6, p.getRua());
            stmt.setString(7, p.getCidade());
            stmt.setString(8, p.getEstado());
            stmt.setString(9, p.getBairro());
            stmt.setString(10, p.getComplemento());
            stmt.setInt(11, p.getNumero());
            stmt.setInt(12, p.getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void delete(Fornecedor p) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM Fornecedor WHERE id_fornecedor = ?");
            stmt.setInt(1, p.getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

}
