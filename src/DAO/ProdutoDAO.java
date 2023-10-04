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
import java.util.HashSet;

/**
 *
 * @author Samuelson
 */
public class ProdutoDAO {

    public void create(Produto p) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
           stmt = con.prepareStatement("INSERT INTO Produto (nome,fornecedor_id,estoque,valor,unid) VALUES(?,?,?,?,?)");
            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getFornecedor().getId());
            stmt.setInt(3, p.getEstoque());
            stmt.setFloat(4, p.getValor());
            stmt.setString(5, p.getUnidade());
            

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Produto> read() {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> Produto = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT i.id_Produto, i.nome, f.nome, i.estoque, i.unid, i.valor FROM Produto i, Fornecedor f WHERE i.fornecedor_id = f.id_fornecedor");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto p = new Produto();
                Fornecedor f = new Fornecedor();

                p.setId(rs.getInt("i.id_Produto"));
                p.setNome(rs.getString("i.nome"));
                f.setNome(rs.getString("f.nome"));
                p.setEstoque(rs.getInt("i.estoque"));
                p.setUnidade(rs.getString("i.unid"));
                p.setValor(rs.getFloat("i.valor"));
                p.setFornecedor(f);

                Produto.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Produto;

    }

    public List<Produto> readForDesc(String desc) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> Produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Produto WHERE nome LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto p = new Produto();
                Produtos.add(p);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Produtos;

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

    public void update(Produto p) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Produto SET nome = ? ,fornecedor_id = ?, estoque = ? ,valor = ?,unid = ? WHERE id_Produto = ?");
            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getFornecedor().getId());
            stmt.setInt(3, p.getEstoque());
            stmt.setFloat(4, p.getValor());
            stmt.setString(5, p.getUnidade());
            stmt.setInt(6, p.getId());
            

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void delete(Produto p) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM Produto WHERE id_Produto = ?");
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
