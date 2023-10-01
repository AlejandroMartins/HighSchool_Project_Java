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
public class IngredienteDAO {

    public void create(Ingrediente p) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO Ingrediente (nome,fornecedor_id,estoque,valor,unid) VALUES(?,?,?,?,?)");
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

    public List<Ingrediente> read() {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Ingrediente> Ingrediente = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT i.id_ingrediente, i.nome, f.nome, i.estoque, i.unid, i.valor FROM Ingrediente i, Fornecedor f WHERE i.fornecedor_id = f.id_fornecedor");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Ingrediente p = new Ingrediente();
                Fornecedor f = new Fornecedor();
                
                p.setId(rs.getInt("i.id_ingrediente"));
                p.setNome(rs.getString("i.nome"));
                f.setNome(rs.getString("f.nome"));
                p.setEstoque(rs.getInt("i.estoque"));
                p.setUnidade(rs.getString("i.unid"));
                p.setValor(rs.getFloat("i.valor"));
                p.setFornecedor(f);
                
                
                Ingrediente.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(IngredienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Ingrediente;

    }

    public List<Ingrediente> readForDesc(String desc) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Ingrediente> Ingredientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Ingrediente WHERE nome LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Ingrediente p = new Ingrediente();
                Ingredientes.add(p);

            }

        } catch (SQLException ex) {
            Logger.getLogger(IngredienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Ingredientes;

    }

    public void update(Ingrediente p) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Ingrediente SET nome = ? ,fornecedor_id = ?, estoque = ? ,valor = ?,unid = ? WHERE id_Ingrediente = ?");
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

    public void delete(Ingrediente p) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM Ingrediente WHERE id_ingrediente = ?");
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
