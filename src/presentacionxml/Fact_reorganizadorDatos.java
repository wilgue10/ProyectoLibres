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
import java.util.Date;

/**
 *
 * @author Wilmer
 */
public class Fact_reorganizadorDatos {

    private Connection connectionBasePruebas = null;
    private Connection connectionBaseProyectoLibres = null;
    String[] proveedor = new String[5];

    private void conectarAbasePruebas() {
        try {
            connectionBasePruebas = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebafacturas", "root", "cubos1301");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
    }

    private void conectarAbaseProyectoLibres() {
        try {
            connectionBaseProyectoLibres = DriverManager.getConnection("jdbc:mysql://localhost:3306/libresfacturaproyecto", "root", "cubos1301");

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

    private void datosInformacionTributaria() {
        conectarAbasePruebas();
        String sql = "SELECT * FROM infotributaria ";

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

    private void datosFactura() {
        conectarAbasePruebas();
        String sql = "SELECT * FROM infofactura ";
        String[] factura = new String[14];
        try {
            Statement st = connectionBasePruebas.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                if (rs.isLast() == true) {
                    factura[1] ="1726246828";  //cedula
                    factura[2] = proveedor[0];//ruc
                    factura[3] = "";//fecha
                    factura[4] = rs.getString(7);//total sin iva

                    factura[5] = "14";// iva

                    factura[6] = rs.getString(7);//total con iva
                    factura[8] = "0.0";
                    factura[9] = "0.0";
                    factura[10] = "0.0";
                    factura[11] = "0.0";
                    factura[12] = "0.0";
                    factura[13] = "231348765";//numero de factura

                    nuevaFactura(
                            factura[1],
                            factura[2],
                            factura[3],
                            factura[4],
                            factura[5],
                            factura[6],
                            factura[7],
                            factura[8],
                            factura[9],
                            factura[10],
                            factura[11],
                            factura[12],
                            factura[13]);
                }
            }

        } catch (SQLException ex) {

        }
    }

    public void nuevaFactura(
            String cedula,
            String ruc,
            String fecha,
            String total_sin_iva,
            String iva,
            String total_con_iva,
            String vivienda,
            String alimentacion,
            String salud,
            String educacion,
            String vestimenta,
            String otros,
            String numfact) {

        try {
            conectarAbaseProyectoLibres();
            PreparedStatement pstm = connectionBaseProyectoLibres.prepareStatement("insert into "
                    + "factura(CODIGO, CEDULA, RUC, FECHA,TOTAL_SIN_IVA,"
                    + "IVA,TOTAL_CON_IVA,VIVIENDA,ALIMENTACION,SALUD,EDUCACION,"
                    + "VESTIMENTA,OTROS,NUMERO_FACTURA) "
                    + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            Date a = new Date();
            float fIva = Float.parseFloat(iva);
            float fTsinIva = Float.parseFloat(total_sin_iva);
            float fTconIva = Float.parseFloat(total_con_iva);

            pstm.setString(1, "");
            pstm.setString(2, cedula);
            pstm.setString(3, ruc);
            pstm.setDate(4, null);
            pstm.setFloat(5, fTsinIva);
            pstm.setFloat(6, fIva);
            pstm.setFloat(7, fTconIva);

            pstm.setString(8, vivienda);
            pstm.setString(9, alimentacion);
            pstm.setString(10, salud);
            pstm.setString(11, educacion);

            pstm.setString(12, vestimenta);
            pstm.setString(13, otros);
            pstm.setString(14, numfact);

            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void reorganizardatos() {

        datosInformacionTributaria();
        datosFactura();
    }

}
