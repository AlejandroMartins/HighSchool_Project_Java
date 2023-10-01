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
 * @author aleja
 */
public class UsuarioDAO {
    //CRUD

    public void create(Usuario p) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO Usuario (name,password)VALUES(?,?)");
            
             
            stmt.setString(1, p.getName());            
            stmt.setString(2, p.getPassword());

           

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public List<Usuario> read() {

        Connection con = Conexao.ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuario> Usuario = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Usuario");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Usuario p = new Usuario();
                Fornecedor f = new Fornecedor();

               
                p.setName(rs.getString("name"));
                p.setPassword(rs.getString("password"));
                

                Usuario.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Usuario;

    }

}

    

