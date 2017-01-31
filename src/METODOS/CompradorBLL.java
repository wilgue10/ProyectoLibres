/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package METODOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Wilmer
 */
public class CompradorBLL {

    public Connection conexion() {
        Connection conectar = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost/libresfacturaproyecto", "root", "basQUET23");
            System.out.print("SE HA CONECTADO EXITOSAMENTE A LA BASE");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return conectar;
    }

    public int Guardar(String cedula, String nombre, String direccion) {

        int resultado = 0;
        Connection con = null;
        String SSQL = "INSERT INTO comprador (CEDULA, NOMBRE, DIRECCION) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            con = conexion();
            PreparedStatement psql = con.prepareStatement(SSQL);
            psql.setString(1, cedula);
            psql.setString(2, nombre);
            psql.setString(3, direccion);
            resultado = psql.executeUpdate();
            psql.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al intentar almacenar la información:\n"
                    + e, "Error en la operación", JOptionPane.ERROR_MESSAGE);

        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
                        + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);
            }
        }
        return resultado;
    }

}


