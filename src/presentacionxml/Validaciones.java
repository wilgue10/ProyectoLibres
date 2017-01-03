/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacionxml;

import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Brayan
 */
public class Validaciones {

    public boolean validadorDeCedula(String cedula) {
        boolean cedulaCorrecta = false;

        try {

            if (cedula.length() == 10) // ConstantesApp.LongitudCedula
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
// Coeficientes de validación cédula
// El decimo digito se lo considera dígito verificador
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            System.out.println("Una excepcion ocurrio en el proceso de validadcion");
            cedulaCorrecta = false;
        }

        if (!cedulaCorrecta) {
            System.out.println("La Cédula ingresada es Incorrecta");
        }
        return cedulaCorrecta;
    }

    String _mensaje;
    String msgCampoDigitosDiez = "El campo debe poseer 10 dígitos";

    //Hecho por wilmer
    public boolean VerificarNumero(String e) {
        try {
            Integer.parseInt(e);
            return true;
        } catch (Exception error) {
            return false;
            //throw;
        }
    }

    public boolean VerificarDecimal(String e) {
        try {

            Double.parseDouble(e);
            return true;
        } catch (Exception error) {
            return false;
            //throw;
        }
    }

    public boolean verificarfecha(Date fecha1, Date fecha2) {
        if (fecha1.after(fecha2)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean VerificarNumeroPositvo(String e) {
        try {
            if (Integer.parseInt(e) >= 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception error) {
            return false;
            //throw;
        }
    }

    public void password(String pas1,  String pas2) {
//        String pas1 = "", pas2 = "";
//        pas1 = password_1.getText().trim();
//        pas2 = password_2.getText();
        if (pas1.matches("[A-Za-z][0-9]{10}")) {
            char clave;
            byte contLetra = 0, conNumero = 0;
            for (byte i = 0; i <= pas1.length(); i++) {
                clave = pas1.charAt(i);
                pas2 = String.valueOf(clave);
                if (pas2.matches("[a-zA-Z]")) {
                    contLetra++;
                    System.out.println(contLetra);
                } else if (pas2.matches("[0-9]")) {
                    conNumero++;
                    System.out.println(conNumero);
                }
            }
            if (contLetra == conNumero) {
                JOptionPane.showMessageDialog(null, "Tu contraseña tiene un nivel alto de complejidiad");
            } else if (conNumero == 0) {
                JOptionPane.showConfirmDialog(null, "Para tener una contraseña mas confiable por favor introduce un numero como mínimo.");
            } else if (conNumero == 2 && contLetra <= 3) {
                JOptionPane.showMessageDialog(null, "la contraseña necesita mas de 7 digitos entre numeros y letras");
            }
        } else {
            JOptionPane.showMessageDialog(null, "La contraseña no puede tener caracteres especiales como %-&-$.");
        }
    }

}
