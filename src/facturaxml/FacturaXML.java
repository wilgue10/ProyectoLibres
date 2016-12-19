/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturaxml;
import presentacionxml.Fact_LoginForm;
import conexionbddxml.Conectar;

/**
 *
 * @author Wilmer
 */
public class FacturaXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Conectar conenexion=new Conectar();
        conenexion.conexion();
       new Fact_LoginForm().setVisible(true);
//        new controDatosXML().setVisible(true);
    }
    
}
