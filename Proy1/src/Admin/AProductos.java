package Admin;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import Clases.Productos;
import proy1.Proy1;

public class AProductos extends JPanel implements ActionListener{
    JButton crearp, cargarp, actualizarp, eliminarp, exportarp;
    JPanel graficap;
    static JTable tablap;
    static Object[][] datos;
    public AProductos(){
        //COLORES
        Color gris = new Color(204,201,201);
        Color azulito = new Color(112,114,231);
        
        //BOTON CREAR
        crearp = new JButton("Crear");
        crearp.setBounds(900, 10, 150, 50);
        crearp.setFont(new Font("Arial", Font.PLAIN,15));
        crearp.setBackground(azulito);
        crearp.setVisible(true);
        crearp.addActionListener(this);
        this.add(crearp);
        
        //BOTON MODIFICAR
        cargarp = new JButton("Carga Masiva");
        cargarp.setBounds(1100, 10, 150, 50);
        cargarp.setFont(new Font("Arial", Font.PLAIN,15));
        cargarp.setBackground(azulito);
        cargarp.addActionListener(this);
        cargarp.setVisible(true);
        this.add(cargarp);
        
        //BOTON ACTUALIZAR
        actualizarp = new JButton("Actualizar");
        actualizarp.setBounds(900, 70, 150, 50);
        actualizarp.setFont(new Font("Arial", Font.PLAIN,15));
        actualizarp.setBackground(azulito);
        actualizarp.setVisible(true);
        actualizarp.addActionListener(this);
        this.add(actualizarp);
        
        //BOTON ELIMINAR
        eliminarp = new JButton("Eliminar");
        eliminarp.setBounds(1100, 70, 150, 50);
        eliminarp.setFont(new Font("Arial", Font.PLAIN,15));
        eliminarp.setBackground(azulito);
        eliminarp.setVisible(true);
        eliminarp.addActionListener(this);
        this.add(eliminarp);
        
        //BOTON EXPORTAR
        exportarp = new JButton("Exportar Listado PDF");
        exportarp.setBounds(900, 130, 350, 50);
        exportarp.setFont(new Font("Arial", Font.PLAIN,15));
        exportarp.setBackground(azulito);
        exportarp.setVisible(true);
        exportarp.addActionListener(this);
        this.add(exportarp);
        
        //PANEL DE GRAFICA
        graficap = new JPanel();
        graficap.setLayout(new BorderLayout());
	graficap.setBounds(900,220,350,300);
        graficap.setBackground(azulito);
        this.add(graficap);
        
        //TABLA
        String [] encabezado = {"Código","Nombre","Cantidad","Descripcion","Precio"};
//        Object [][] fila1 = {{"1","martillo","300","herramienta","5.00"}};
        datos = Proy1.convertirDProductos();
        tablap = new JTable(datos,encabezado);
        JScrollPane sp= new JScrollPane(tablap);
        sp.setBounds(20, 10, 800, 600);
        this.add(sp);
        
        //DISEÑO PANEL
        this.setBackground(gris);
        this.setLayout(null);
    }
    String contenido = "";
    File archivo;
    FileReader fr;
    BufferedReader br;
    //METODO PARA LEER UN ARCHIVO
    public void leerArchivoP(){        
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
            convertirjson(contenido);
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
    
    //METODO PARA QUE LEA EL ARCHIVO JSON Y LO META DENTRO DE LOS OBJETOS
    public void convertirjson(String c){
        JsonParser parser = new JsonParser();
        JsonArray ja = parser.parse(c).getAsJsonArray();
        System.out.println("Tiene : " + ja.size() + " objetos");
        
        for (int i = 0; i < ja.size(); i++) {
            JsonObject jobj = ja.get(i).getAsJsonObject();
            
            int codigo = jobj.get("codigo").getAsInt();
            String nombre = jobj.get("nombre").getAsString();
            String descripcion = jobj.get("descripcion").getAsString();
            int cantidad = jobj.get("cantidad").getAsInt();
            double precio = jobj.get("precio").getAsDouble();
            
            Productos nuevo = new Productos(codigo,nombre,descripcion,cantidad,precio);
            Proy1.AgregarProducto(nuevo);
        }
        Proy1.LeerProducto();
    }
    
    //ACCIONES DE LOS BOTONES
    @Override
    public void actionPerformed(ActionEvent ae) {
        //BOTON CARGA MASIVA
        if (ae.getSource()==cargarp){
            leerArchivoP();
        }
        //BOTON CREAR PRODUCTO
        else if (ae.getSource()==crearp) {
            Formcp fcp = new Formcp();
        }
        //BOTON ACTUALIZAR PRODUCTO
        else if (ae.getSource()==actualizarp) {
            Formap fap = new Formap();
        }
        //BOTON ELIMINAR PRODUCTO
        else if (ae.getSource()==eliminarp) {
            Formep fep = new Formep();
        }
    }
}
