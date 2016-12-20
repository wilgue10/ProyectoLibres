/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacionxml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Wilmer
 */
public class Fact_reorganizadorDatos {

    private Connection connectionBasePruebas = null;
    private Connection connectionBaseProyectoLibres = null;

    private void conectarAbasePruebas() {
        try {
            connectionBasePruebas = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebafacturas", "root", "basQUET23");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
    }

    private void conectarAbaseProyectoLibres() {
        try {
            connectionBaseProyectoLibres = DriverManager.getConnection("jdbc:mysql://localhost:3306/libresfacturaproyecto", "root", "basQUET23");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
    }

    public void nuevoProveedor(String ruc, String direccion, String telefono, String ciudad, String nombre) {
        try {
            conectarAbaseProyectoLibres();
            PreparedStatement pstm = connectionBaseProyectoLibres.prepareStatement("insert into "
                    + "proveedor(RUC, DIRECCION, TELEFONO, CIUDAD,NOMBRE) "
                    + " values(?,?,?,?,?)");
            pstm.setString(1, ruc);
            pstm.setString(2, direccion);
            pstm.setString(3, telefono);
            pstm.setString(4, ciudad);
            pstm.setString(5, nombre);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void reorganizardatos() {
        conectarAbasePruebas();
        String sql = "SELECT * FROM infotributaria ";
        String[] proveedor = new String[5];
        try {
            Statement st = connectionBasePruebas.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                if (rs.isLast() == true) {
                    proveedor[0] = rs.getString(5);
                    proveedor[1] = rs.getString(11);
                    proveedor[2] = "";
                    proveedor[3] = "";
                    proveedor[4] = rs.getString(3);
                    nuevoProveedor(proveedor[0], proveedor[1], proveedor[2], proveedor[3], proveedor[4]);
                }
            }

        } catch (SQLException ex) {

        }

    }

}
