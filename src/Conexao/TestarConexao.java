/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.IntelliJTheme;
import java.security.Principal;
import javax.swing.JOptionPane;

/**
 *
 * @author aleja
 */
public class TestarConexao {

    public static void main(String[] args) {
        FlatLightLaf.setup();
        try {
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Conectado com sucesso");

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ops, aconteceu algum erro" + e);
        }
    }

}
