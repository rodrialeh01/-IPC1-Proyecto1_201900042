package Admin;

//==================LIBRERIAS===============
//LECTURA DE UN ARCHIVO JSON
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
//AWT-SWING
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
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

//==================PAQUETES===============
import proy1.Proy1;
import Clases.Vendedores;
import Listados.ListadoVendedores;


public class AVendedores extends JPanel implements ActionListener{
    JButton crearv, cargarv, actualizarv, eliminarv, exportarv;
    JPanel graficav;
    static JTable tablav;
    static Object[][] datos;
    Color azulito = new Color(112,114,231);
    public AVendedores(){
        //COLORES
        Color gris = new Color(204,201,201);
        Color azul = new Color(38,36,89);
        
        //BOTON CREAR
        crearv = new JButton("Crear");
        crearv.setBounds(900, 10, 150, 50);
        crearv.setFont(new Font("Century Gothic", Font.PLAIN,15));
        crearv.setBackground(azulito);
        crearv.setVisible(true);
        crearv.addActionListener(this);
        this.add(crearv);
        
        //BOTON MODIFICAR
        cargarv = new JButton("Carga Masiva");
        cargarv.setBounds(1100, 10, 150, 50);
        cargarv.setFont(new Font("Century Gothic", Font.PLAIN,15));
        cargarv.setBackground(azulito);
        cargarv.addActionListener(this);
        cargarv.setVisible(true);
        this.add(cargarv);
        
        //BOTON ACTUALIZAR
        actualizarv = new JButton("Actualizar");
        actualizarv.setBounds(900, 70, 150, 50);
        actualizarv.setFont(new Font("Century Gothic", Font.PLAIN,15));
        actualizarv.setBackground(azulito);
        actualizarv.addActionListener(this);
        actualizarv.setVisible(true);
        this.add(actualizarv);
        
        //BOTON ELIMINAR
        eliminarv = new JButton("Eliminar");
        eliminarv.setBounds(1100, 70, 150, 50);
        eliminarv.setFont(new Font("Century Gothic", Font.PLAIN,15));
        eliminarv.setBackground(azulito);
        eliminarv.setVisible(true);
        eliminarv.addActionListener(this);
        this.add(eliminarv);
        
        //BOTON EXPORTAR
        exportarv = new JButton("Exportar Listado PDF");
        exportarv.setBounds(900, 130, 350, 50);
        exportarv.setFont(new Font("Century Gothic", Font.PLAIN,15));
        exportarv.setBackground(azulito);
        exportarv.setVisible(true);
        exportarv.addActionListener(this);
        this.add(exportarv);
        
        //PANEL DE GRAFICA
        graficav = new JPanel();
	graficav.setBounds(900,220,350,300);
        graficav.setBackground(azulito);
        this.add(graficav);
        pg();
        
        //TABLA
        String [] encabezado = {"Código","Nombre","Caja","Ventas","Género","Contraseña"};
        datos = Proy1.convertirDVendedores();
        tablav = new JTable(datos,encabezado);
        JScrollPane sp= new JScrollPane(tablav);
        sp.setBounds(20, 10, 850, 600);
        //CENTRAR LOS DATOS DE LA TABLA
        DefaultTableCellRenderer renderc = new DefaultTableCellRenderer();
        renderc.setHorizontalAlignment(SwingConstants.CENTER);
        tablav.getColumnModel().getColumn(0).setCellRenderer(renderc);
        tablav.getColumnModel().getColumn(1).setCellRenderer(renderc);
        tablav.getColumnModel().getColumn(2).setCellRenderer(renderc);
        tablav.getColumnModel().getColumn(3).setCellRenderer(renderc);
        tablav.getColumnModel().getColumn(4).setCellRenderer(renderc);
        tablav.getColumnModel().getColumn(5).setCellRenderer(renderc);
        tablav.getTableHeader().setFont(new Font("Century Gothic", Font.PLAIN,15));
        tablav.getTableHeader().setBackground(azul);
        tablav.getTableHeader().setForeground(Color.WHITE);
        tablav.setEnabled(false);
        tablav.setFont(new Font("Century Gothic", Font.PLAIN,12));
        this.add(sp);
        
        //DISEÑO PANEL
        this.setBackground(gris);
        this.setLayout(null);
    }
    //=============================================GRAFICA=====================================================
    //MOSTRAR LO QUE TENGA QUE MOSTRAR EN EL PANEL DE GRAFICA
    public void pg(){
        JLabel nulo = new JLabel("No hay ningun vendedor registrado");
        nulo.setBounds(180,135,200,30);
        nulo.setFont(new Font("Century Gothic", Font.PLAIN,20));
        graficav.add(nulo);
        if (Proy1.vendedores[0] == null) {
            graficav.setVisible(true);
        }else{
            graficav.setVisible(false);
            mostrargrafica();
        }        
    }
    
    //SE CREA UN ARREGLO TEMPORAL PARA ACTUAR EL ORDENAMIENTO
    public static Vendedores[] arraytempg = new Vendedores[400];
    
    //MOSTRAR LA GRAFICA
    public void mostrargrafica(){
        //SE MANDAN LOS DATOS DEL ARREGLO DE PRODUCTOS AL ARREGLO TEMPORAL        
        for (int i = 0; i < Proy1.vendedores.length; i++) {
            arraytempg[i]=Proy1.vendedores[i];
        }
        //SE LLAMA AL METODO DE ORDENAMIENTO PARA QUE ORDENE LOS OBJETOS POR CANTIDAD DE VENTAS
        Proy1.ordenamientoVendedores(arraytempg);
        //SE MANDAN LOS DATOS PARA LA GRAFICA PONIENDO SOLO 3
        DefaultCategoryDataset datosbarra = new DefaultCategoryDataset();
        //SE APLICO UN TRYCATCH PARA EVITAR ALGUN ERROR CON LA GRAFICA
        try {
            for (int i = 0; i < 3; i++) {
                if (arraytempg != null && arraytempg[i].getVentas() != 0) {
                    datosbarra.setValue(arraytempg[i].getVentas(), arraytempg[i].getNombre(), String.valueOf(arraytempg[i].getVentas()));
                }
            }
        }catch(Exception e){
        }
        //SE DIBUJA LA GRAFICA
        JFreeChart barras = ChartFactory.createBarChart("Top 3 - Vendedores con más Ventas","Vendedores", "Ventas", datosbarra,PlotOrientation.VERTICAL,true,false, false);
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
    public void leerArchivoV(){        
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
            int caja = jobj.get("caja").getAsInt();
            int ventas = jobj.get("ventas").getAsInt();
            String genero = jobj.get("genero").getAsString();
            String password = jobj.get("password").getAsString();
            
            if (verificar(codigo) == false) {
                Vendedores nuevo = new Vendedores(codigo, nombre, caja, ventas, genero.toUpperCase(), password);
                Proy1.AgregarVendedor(nuevo);
                error = false;
            }else{
                error = true;
            }            
        }
        if (error == true) {
            JOptionPane.showMessageDialog(null, "No se pudieron cargar ciertos vendedores porque ya existen estos codigos de vendedores");
        }
        Proy1.LeerVendedor();
    }

    //ACCIONES DE LOS BOTONES
    @Override
    public void actionPerformed(ActionEvent ae) {
        //BOTON CARGA MASIVA
        if (ae.getSource()==cargarv){
            leerArchivoV();
        }
        //BOTON CREAR VENDEDOR
        else if (ae.getSource()==crearv) {
            Formcv fcv = new Formcv();
        }
        //BOTON ACTUALIZAR VENDEDOR
        else if (ae.getSource()==actualizarv) {
            Formav fav = new Formav();
        }
        //BOTON ELIMINAR VENDEDOR
        else if (ae.getSource()==eliminarv) {
            Formev fev = new Formev();
        }
        //BOTON EXPORTAR LISTA DE VENDEDORES EN PDF
        else if (ae.getSource()==exportarv) {
            ListadoVendedores lv = new ListadoVendedores();
            lv.CrearPDFV();
        }
    }
    
    //VERIFICA SI YA EXISTE EL OBJETO
    public boolean verificar(int cod) {
        for (int i = 0; i<Proy1.vendedores.length; i++) {
            if (Proy1.vendedores[i]!=null && Proy1.vendedores[i].getCodigo()==cod) {
                return true;
            }
        }
        return false;
    }
}
