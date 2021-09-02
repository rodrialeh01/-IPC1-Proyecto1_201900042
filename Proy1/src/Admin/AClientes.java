package Admin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
public class AClientes extends JPanel implements ActionListener{
    JButton crearc, cargarc, actualizarc, eliminarc, exportarc;
    JPanel graficac;
    JTable tablac;
    public AClientes(){
        //COLORES
        Color gris = new Color(204,201,201);
        Color azulito = new Color(112,114,231);
        
        //BOTON CREAR
        crearc = new JButton("Crear");
        crearc.setBounds(900, 10, 150, 50);
        crearc.setFont(new Font("Arial", Font.PLAIN,15));
        crearc.setBackground(azulito);
        crearc.setVisible(true);
        this.add(crearc);
        
        //BOTON MODIFICAR
        cargarc = new JButton("Carga Masiva");
        cargarc.setBounds(1100, 10, 150, 50);
        cargarc.setFont(new Font("Arial", Font.PLAIN,15));
        cargarc.setBackground(azulito);
        cargarc.setVisible(true);
        cargarc.addActionListener(this);
        this.add(cargarc);
        
        //BOTON ACTUALIZAR
        actualizarc = new JButton("Actualizar");
        actualizarc.setBounds(900, 70, 150, 50);
        actualizarc.setFont(new Font("Arial", Font.PLAIN,15));
        actualizarc.setBackground(azulito);
        actualizarc.setVisible(true);
        this.add(actualizarc);
        
        //BOTON ELIMINAR
        eliminarc = new JButton("Eliminar");
        eliminarc.setBounds(1100, 70, 150, 50);
        eliminarc.setFont(new Font("Arial", Font.PLAIN,15));
        eliminarc.setBackground(azulito);
        eliminarc.setVisible(true);
        this.add(eliminarc);
        
        //BOTON EXPORTAR
        exportarc = new JButton("Exportar Listado PDF");
        exportarc.setBounds(900, 130, 350, 50);
        exportarc.setFont(new Font("Arial", Font.PLAIN,15));
        exportarc.setBackground(azulito);
        exportarc.setVisible(true);
        this.add(exportarc);
        
        //PANEL DE GRAFICA
        graficac = new JPanel();
        graficac.setLayout(new BorderLayout());
	graficac.setBounds(900,220,350,300);
        graficac.setBackground(azulito);
        this.add(graficac);
        
        //TABLA
        String [] encabezado = {"Código","Nombre","NIT","Correo","Género"};
        Object [][] fila1 = {{"1","ale","1234567","rodrialehdl@gmail.com", "m"}};
        tablac = new JTable(fila1,encabezado);
        JScrollPane sp= new JScrollPane(tablac);
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
    public void leerArchivoC(){        
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
        if (ae.getSource()==cargarc){
            leerArchivoC();
        }
    }
}
