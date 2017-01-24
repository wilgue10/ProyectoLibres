package conexionbddxml;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shanty
 */
public class Conectar {
    Connection conectar = null;
    
    public Connection conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost/libresfacturaepn","root","cubos1301");
        System.out.print("SE HA CONECTADO EXITOSAMENTE A LA BASE");
        } 
        catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return conectar;
    }
}
