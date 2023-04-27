/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jvall
 */
public class ConexionSQL {
    Connection conectar = null;
    
    public Connection conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");//que driver usar
            conectar = DriverManager.getConnection("jdbc:mysql://localhost/proyectofinal2", "root", "toor");
            JOptionPane.showMessageDialog(null, "Conexion Exitosa");
        } catch(HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Conexion Fallida"+e.getMessage());
        }
        return conectar;
    }
}
