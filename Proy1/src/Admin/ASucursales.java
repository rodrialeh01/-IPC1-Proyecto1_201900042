package Admin;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.*;
public class ASucursales extends JPanel implements ActionListener{
    JButton crears, cargars, actualizars, eliminars, exportars;
    JTable tablas;
    JPanel esptab;
    public ASucursales(){
        //COLORES
        Color gris = new Color(204,201,201);
        Color azulito = new Color(112,114,231);
        
        //BOTON CREAR
        crears = new JButton("Crear");
        crears.setBounds(900, 10, 150, 50);
        crears.setFont(new Font("Arial", Font.PLAIN,15));
        crears.setBackground(azulito);
        crears.setVisible(true);
        this.add(crears);
        
        //BOTON CARGA MASIVA
        cargars = new JButton("Carga Masiva");
        cargars.setBounds(1100, 10, 150, 50);
        cargars.setFont(new Font("Arial", Font.PLAIN,15));
        cargars.setBackground(azulito);
        cargars.setVisible(true);
        cargars.addActionListener(this);
        this.add(cargars);
        
        //BOTON ACTUALIZAR
        actualizars = new JButton("Actualizar");
        actualizars.setBounds(900, 70, 150, 50);
        actualizars.setFont(new Font("Arial", Font.PLAIN,15));
        actualizars.setBackground(azulito);
        actualizars.setVisible(true);
        this.add(actualizars);
        
        //BOTON ELIMINAR
        eliminars = new JButton("Eliminar");
        eliminars.setBounds(1100, 70, 150, 50);
        eliminars.setFont(new Font("Arial", Font.PLAIN,15));
        eliminars.setBackground(azulito);
        eliminars.setVisible(true);
        this.add(eliminars);
        
        //BOTON EXPORTAR
        exportars = new JButton("Exportar Listado PDF");
        exportars.setBounds(900, 130, 350, 50);
        exportars.setFont(new Font("Arial", Font.PLAIN,15));
        exportars.setBackground(azulito);
        exportars.setVisible(true);
        this.add(exportars);
        
//        //PANEL PARA LA TABLA
//        esptab = new JPanel();
//        esptab.setBounds(20,10,620,600);
//        esptab.setBackground(azulito);
//        this.add(esptab);
        
        String [] encabezado = {"Código","Nombre","Dirreción","Correo","Teléfono"};
        Object [][] fila1 = {{"1","Gasolinita","san lucas","gasolinita@g.com","53085107"}};
        tablas = new JTable(fila1,encabezado);
        JScrollPane sp= new JScrollPane(tablas);
        sp.setBounds(20, 10, 800, 600);
        this.add(sp);
        
        //DISEÑO PANEL
        this.setLayout(null);
        this.setBackground(gris);
    }
    
    String contenido = "";
    File archivo;
    FileReader fr;
    BufferedReader br;
    //METODO PARA LEER UN ARCHIVO
    public void leerArchivoS(){        
        try{
            //SE USA UN JFILECHOOSER PARA QUE SE ABRA UNA VENTANA QUE ABRA UN ARCHIVO
            JFileChooser fc = new JFileChooser();
            int op = fc.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {
                System.out.println(fc.getSelectedFile());
                archivo = fc.getSelectedFile();
            }
            //SE LEE EL ARCHIVO
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            // LEERA EL ARCHIVO LINEA POR LINEA
            while ((linea = br.readLine()) != null) {
                // Solo agregamos el contenido a un String
                contenido += linea;
            }
            System.out.println(contenido);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "No se pudo abrir el archivo");
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==cargars){
            leerArchivoS();
        }
    }
}
