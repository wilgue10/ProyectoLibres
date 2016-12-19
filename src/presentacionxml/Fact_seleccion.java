package presentacionxml;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

//import com.mysql.jdbc.ResultSet;

import javax.swing.JFileChooser;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;

public class Fact_seleccion extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private Fact_Db con=new Fact_Db();
    private String primero, segundo, tercero, cuarto, quinto;
    private Connection connection = null;
    private java.sql.ResultSet res;
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("XML files", "xml", "XML");
    private File[] files;
    private JLabel lblRuta;
    private JLabel lblOrganizadorDeFacturas;
    private JLabel lblSeCargaron;
    private JLabel lblNumFacturas;
    private JLabel lblFacturasALa;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Fact_seleccion frame = new Fact_seleccion();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Fact_seleccion() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\David\\Desktop\\sriPais.jpg"));
        setTitle("Organizador de Facturas");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 474, 261);
        contentPane = new JPanel();
        contentPane.setForeground(Color.GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        Button button = new Button("Buscar Facturas");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String userhome = System.getProperty("user.home");
                JFileChooser fc = new JFileChooser(userhome + "\\Desktop");
                fc.setPreferredSize(new Dimension(800, 900));
                fc.setFileFilter(filter);
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                if (!fc.isMultiSelectionEnabled()) {
                    fc.setMultiSelectionEnabled(true);
                }
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    System.out.println("Where is your MySQL JDBC Driver?");
                    e.printStackTrace();
                    return;
                }

                System.out.println("MySQL JDBC Driver Registered!");

                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebafacturas", "root", "basQUET23");

                } catch (SQLException e) {
                    System.out.println("Connection Failed! Check output console");
                    e.printStackTrace();
                    return;
                }

                if (connection != null) {
                    System.out.println("You made it, take control your database now!");
                } else {
                    System.out.println("Failed to make connection!");
                }////conexi�n

                //Abrimos la ventana, guardamos la opcion seleccionada por el usuario
                int seleccion = fc.showOpenDialog(contentPane);

                //Si el usuario, pincha en aceptar
                if (seleccion == JFileChooser.APPROVE_OPTION) {

                    //Seleccionamos el fichero
                    files = fc.getSelectedFiles();

					//Escribe la ruta del fichero seleccionado en el campo de texto
                }
                lblSeCargaron.setVisible(true);
                lblNumFacturas.setVisible(true);
                lblNumFacturas.setText(String.valueOf(files.length));
                lblFacturasALa.setVisible(true);
            }
        });
        button.setBounds(168, 90, 117, 22);
        contentPane.add(button);

        textField = new JTextField();
        textField.setBounds(105, 146, 269, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        lblRuta = new JLabel("Ruta:");
        lblRuta.setBounds(61, 149, 34, 14);
        contentPane.add(lblRuta);

        lblOrganizadorDeFacturas = new JLabel(" ORGANIZADOR DE FACTURAS");
        lblOrganizadorDeFacturas.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblOrganizadorDeFacturas.setBounds(10, 23, 438, 89);
        contentPane.add(lblOrganizadorDeFacturas);

        JButton btnCargarEnBase = new JButton("Cargar Facturas en Base de Datos");
        btnCargarEnBase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean paso = true;
                for (int i = 0; i < files.length; i++) {
                    cargar(files[i].getAbsolutePath());
                    System.out.println(primero);
                    textField.setText(files[i].getAbsolutePath());
                    try {
                        connection.createStatement().execute(primero);
                        connection.createStatement().execute(tercero);
                        connection.createStatement().execute(cuarto);
                        connection.createStatement().execute(quinto);
                        connection.createStatement().execute(segundo);
                        res = connection.createStatement().executeQuery("select secuencial from infotributaria where id=(select max(id) as secuencial from infotributaria) ");
                        System.out.println();
                        String secuencial = "";
                        while (res.next()) {

                            secuencial = res.getString("secuencial");
                        }
                        System.out.println(secuencial);
                        res = connection.createStatement().executeQuery("select count(secuencial) from infotributaria where secuencial=" + secuencial);
                        int existe = 0;
                        while (res.next()) {

                            existe = res.getInt("count(secuencial)");
                        }
                        System.out.println(existe);
                        if (existe > 1) {
                            JOptionPane.showMessageDialog(null, "factura duplicada");
                            paso = false;
                        }
                        if (paso == true) {
                            JOptionPane.showMessageDialog(null, "Factura n�: " + i + " cargada exitosamente");
                        }
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }

            }
        });
        btnCargarEnBase.setBounds(105, 177, 248, 23);
        contentPane.add(btnCargarEnBase);

        lblSeCargaron = new JLabel("Se Cargaran: ");
        lblSeCargaron.setBounds(90, 123, 90, 14);
        contentPane.add(lblSeCargaron);
        lblSeCargaron.setVisible(false);

        lblNumFacturas = new JLabel("");
        lblNumFacturas.setBounds(195, 123, 29, 14);
        contentPane.add(lblNumFacturas);
        lblNumFacturas.setVisible(false);

        lblFacturasALa = new JLabel("Facturas a la base de datos");
        lblFacturasALa.setBounds(239, 123, 188, 14);
        contentPane.add(lblFacturasALa);
        lblFacturasALa.setVisible(false);
    }

    private void cargar(String ruta) {

        String cadena = ruta;
        cadena = cadena.replace('\\', '/');
        System.out.println(cadena);
        primero = "LOAD XML LOCAL INFILE '" + cadena + "' INTO TABLE infotributaria ROWS IDENTIFIED BY '<infoTributaria>';";
        segundo = "LOAD XML LOCAL INFILE '" + cadena + "' INTO TABLE infoFactura ROWS IDENTIFIED BY '<infoFactura>';";
        tercero = "LOAD XML LOCAL INFILE '" + cadena + "' INTO TABLE detalle ROWS IDENTIFIED BY '<detalle>';";
        cuarto = "LOAD XML LOCAL INFILE '" + cadena + "' INTO TABLE impuesto ROWS IDENTIFIED BY '<impuesto>';";
        quinto = "LOAD XML LOCAL INFILE '" + cadena + "' INTO TABLE infoAdicional ROWS IDENTIFIED BY '<infoAdicional>';";

    }
}
