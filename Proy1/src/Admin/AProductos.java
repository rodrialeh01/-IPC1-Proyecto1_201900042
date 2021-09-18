package Admin;

//==================LIBRERIAS===============
//LECTURA DE UN ARCHIVO JSON
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
//AWT-SWING
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//LECTURA DE ARCHIVOS
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
//JFREECHART(GRAFICAS)
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.PlotOrientation;
//UTIL MATH
import java.util.*;

//==================PAQUETES===============
import Clases.Productos;
import Listados.ListadoProductos;
import javax.swing.table.DefaultTableCellRenderer;
import proy1.Proy1;

public class AProductos extends JPanel implements ActionListener{
    JButton crearp, cargarp, actualizarp, eliminarp, exportarp;
    JPanel graficap;
    static JTable tablap;
    static Object[][] datos;
    Color azulito = new Color(112,114,231);
    public AProductos(){
        //COLORES
        Color gris = new Color(204,201,201);
        Color azul = new Color(38,36,89);
        
        //BOTON CREAR
        crearp = new JButton("Crear");
        crearp.setBounds(900, 10, 150, 50);
        crearp.setFont(new Font("Century Gothic", Font.PLAIN,15));
        crearp.setBackground(azulito);
        crearp.setVisible(true);
        crearp.addActionListener(this);
        this.add(crearp);
        
        //BOTON MODIFICAR
        cargarp = new JButton("Carga Masiva");
        cargarp.setBounds(1100, 10, 150, 50);
        cargarp.setFont(new Font("Century Gothic", Font.PLAIN,15));
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
        eliminarp.setFont(new Font("Century Gothic", Font.PLAIN,15));
        eliminarp.setBackground(azulito);
        eliminarp.setVisible(true);
        eliminarp.addActionListener(this);
        this.add(eliminarp);
        
        //BOTON EXPORTAR
        exportarp = new JButton("Exportar Listado PDF");
        exportarp.setBounds(900, 130, 350, 50);
        exportarp.setFont(new Font("Century Gothic", Font.PLAIN,15));
        exportarp.setBackground(azulito);
        exportarp.setVisible(true);
        exportarp.addActionListener(this);
        this.add(exportarp);
        
        //PANEL DE GRAFICA
        graficap = new JPanel();
	graficap.setBounds(900,220,350,300);
        graficap.setBackground(azulito);
        this.add(graficap);
        pg();
        
        //TABLA
        String [] encabezado = {"Código","Nombre","Descripcion","Cantidad","Precio"};
        datos = Proy1.convertirDProductos();
        tablap = new JTable(datos,encabezado);
        JScrollPane sp= new JScrollPane(tablap);
        sp.setBounds(20, 10, 800, 600);
        //CENTRAR LOS DATOS DE LA TABLA
        DefaultTableCellRenderer renderc = new DefaultTableCellRenderer();
        renderc.setHorizontalAlignment(SwingConstants.CENTER);
        tablap.getColumnModel().getColumn(0).setCellRenderer(renderc);
        tablap.getColumnModel().getColumn(1).setCellRenderer(renderc);
        tablap.getColumnModel().getColumn(2).setCellRenderer(renderc);
        tablap.getColumnModel().getColumn(3).setCellRenderer(renderc);
        tablap.getColumnModel().getColumn(4).setCellRenderer(renderc);
        tablap.getTableHeader().setFont(new Font("Century Gothic", Font.PLAIN,15));
        tablap.getTableHeader().setBackground(azul);
        tablap.getTableHeader().setForeground(Color.WHITE);
        tablap.setEnabled(false);
        tablap.setFont(new Font("Century Gothic", Font.PLAIN,12));
        this.add(sp);
        
        //DISEÑO PANEL
        this.setBackground(gris);
        this.setLayout(null);
    }
    
    //=============================================GRAFICA=====================================================
    //MOSTRAR LO QUE TENGA QUE MOSTRAR EN EL PANEL DE GRAFICA
    public void pg(){
        JLabel nulo = new JLabel("No hay ningun producto registrado");
        nulo.setBounds(180,135,200,30);
        nulo.setFont(new Font("Century Gothic", Font.PLAIN,20));
        graficap.add(nulo);
        if (Proy1.productos[0] == null) {
            graficap.setVisible(true);
        }else{
            graficap.setVisible(false);
            mostrargrafica();
        }        
    }
    
    //SE CREA UN ARREGLO TEMPORAL PARA ACTUAR EL ORDENAMIENTO
    public static Productos[] arraytempg = new Productos[200];
    
    //MOSTRAR LA GRAFICA
    public void mostrargrafica(){
        //SE MANDAN LOS DATOS DEL ARREGLO DE PRODUCTOS AL ARREGLO TEMPORAL        
        for (int i = 0; i < Proy1.productos.length; i++) {
            arraytempg[i]=Proy1.productos[i];
        }
        //SE LLAMA AL METODO DE ORDENAMIENTO PARA QUE ORDENE LOS OBJETOS POR CANTIDAD
        Proy1.ordenamientoProductos(arraytempg);
        //SE MANDAN LOS DATOS PARA LA GRAFICA PONIENDO SOLO 3
        DefaultCategoryDataset datosbarra = new DefaultCategoryDataset();
        //SE APLICO UN TRYCATCH PARA EVITAR ALGUN ERROR CON LA GRAFICA
        try {
            for (int i = 0; i < 3; i++) {
                if (arraytempg != null && arraytempg[i].getCantidad() != 0) {
                    datosbarra.setValue(arraytempg[i].getCantidad(), arraytempg[i].getNombre(), String.valueOf(arraytempg[i].getCantidad()));
                }
            }
        } catch (Exception e) {
        }
        //SE DIBUJA LA GRAFICA
        JFreeChart barras = ChartFactory.createBarChart("Top 3 - Productos con mas disponibilidad","Productos", "Cantidad", datosbarra,PlotOrientation.VERTICAL,true,false, false);
        barras.setBackgroundPaint(azulito);
        barras.getTitle().setPaint(Color.BLACK);
        barras.getTitle().setFont(new Font("Arial", Font.PLAIN,20)); 
        ChartPanel chartPanel = new ChartPanel(barras);
        chartPanel.setBounds(900,220,350,300);
        this.add(chartPanel);
    }
    
    //=======================================LECTURA DE ARCHIVOS JSON===========================================
    
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
        boolean error = false;
        for (int i = 0; i < ja.size(); i++) {
            JsonObject jobj = ja.get(i).getAsJsonObject();
            
            int codigo = jobj.get("codigo").getAsInt();
            String nombre = jobj.get("nombre").getAsString();
            String descripcion = jobj.get("descripcion").getAsString();
            int cantidad = jobj.get("cantidad").getAsInt();
            float precio = jobj.get("precio").getAsFloat();
            
            if (verificar(codigo) == false) {
                Productos nuevo = new Productos(codigo, nombre, descripcion, cantidad, precio);
                Proy1.AgregarProducto(nuevo);
                error = false;
            }else{
                error = true;
            }            
        }
        if (error == true) {
            JOptionPane.showMessageDialog(null, "No se pudieron cargar ciertos productos porque ya existen estos codigos de producto");
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
        //BOTON EXPORTAR LISTA DE PRODUCTOS EN PDF
        else if (ae.getSource()==exportarp) {
            ListadoProductos lp = new ListadoProductos();
            lp.CrearPDFP();
        }
    }
    
    //VERIFICA SI YA EXISTE EL OBJETO
    public boolean verificar(int cod) {
        for (int i = 0; i<Proy1.productos.length; i++) {
            if (Proy1.productos[i]!=null && Proy1.productos[i].getCodigo()==cod) {
                return true;
            }
        }
        return false;
    }
}
