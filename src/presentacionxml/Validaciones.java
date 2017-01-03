/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacionxml;

import java.util.Date;

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

}
