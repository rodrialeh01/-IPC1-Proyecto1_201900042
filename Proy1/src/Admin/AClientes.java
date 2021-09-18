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
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

//==================PAQUETES===============
import proy1.Proy1;
import Clases.Clientes;
import Listados.ListadoClientes;
import javax.swing.table.DefaultTableCellRenderer;

public class AClientes extends JPanel implements ActionListener{
    JButton crearc, cargarc, actualizarc, eliminarc, exportarc;
    static JPanel graficac;
    static JTable tablac;
    static Object[][] datos;
    Color azulito = new Color(112,114,231);
    public AClientes(){
        //COLORES
        Color gris = new Color(204,201,201);
        Color azul = new Color(38,36,89);
        
        //BOTON CREAR
        crearc = new JButton("Crear");
        crearc.setBounds(900, 10, 150, 50);
        crearc.setFont(new Font("Century Gothic", Font.PLAIN,15));
        crearc.setBackground(azulito);
        crearc.setVisible(true);
        crearc.addActionListener(this);
        this.add(crearc);
        
        //BOTON MODIFICAR
        cargarc = new JButton("Carga Masiva");
        cargarc.setBounds(1100, 10, 150, 50);
        cargarc.setFont(new Font("Century Gothic", Font.PLAIN,15));
        cargarc.setBackground(azulito);
        cargarc.setVisible(true);
        cargarc.addActionListener(this);
        this.add(cargarc);
        
        //BOTON ACTUALIZAR
        actualizarc = new JButton("Actualizar");
        actualizarc.setBounds(900, 70, 150, 50);
        actualizarc.setFont(new Font("Century Gothic", Font.PLAIN,15));
        actualizarc.setBackground(azulito);
        actualizarc.addActionListener(this);
        actualizarc.setVisible(true);
        this.add(actualizarc);
        
        //BOTON ELIMINAR
        eliminarc = new JButton("Eliminar");
        eliminarc.setBounds(1100, 70, 150, 50);
        eliminarc.setFont(new Font("Century Gothic", Font.PLAIN,15));
        eliminarc.setBackground(azulito);
        eliminarc.setVisible(true);
        eliminarc.addActionListener(this);
        this.add(eliminarc);
        
        //BOTON EXPORTAR
        exportarc = new JButton("Exportar Listado PDF");
        exportarc.setBounds(900, 130, 350, 50);
        exportarc.setFont(new Font("Century Gothic", Font.PLAIN,15));
        exportarc.setBackground(azulito);
        exportarc.setVisible(true);
        exportarc.addActionListener(this);
        this.add(exportarc);
        
        //PANEL DE GRAFICA
        graficac = new JPanel();
	graficac.setBounds(900,220,350,300);
        graficac.setBackground(azulito);
        this.add(graficac);
        pg();
        
        //TABLA
        String [] encabezado = {"Código","Nombre","NIT","Correo","Género"};
        datos = Proy1.convertirDClientes();
        tablac = new JTable(datos,encabezado);
        JScrollPane sp= new JScrollPane(tablac);
        sp.setBounds(20, 10, 800, 600);
        //CENTRAR LOS DATOS DE LA TABLA
        DefaultTableCellRenderer renderc = new DefaultTableCellRenderer();
        renderc.setHorizontalAlignment(SwingConstants.CENTER);
        tablac.getColumnModel().getColumn(0).setCellRenderer(renderc);
        tablac.getColumnModel().getColumn(1).setCellRenderer(renderc);
        tablac.getColumnModel().getColumn(2).setCellRenderer(renderc);
        tablac.getColumnModel().getColumn(3).setCellRenderer(renderc);
        tablac.getColumnModel().getColumn(4).setCellRenderer(renderc);
        tablac.getTableHeader().setFont(new Font("Century Gothic", Font.PLAIN,15));
        tablac.getTableHeader().setBackground(azul);
        tablac.getTableHeader().setForeground(Color.WHITE);
        tablac.setEnabled(false);
        tablac.setFont(new Font("Century Gothic", Font.PLAIN,12));
        this.add(sp);
        
        //DISEÑO PANEL
        this.setLayout(null);
        this.setBackground(gris);
    }
    
    //=======================================LECTURA DE ARCHIVOS JSON===========================================
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
            int nit = jobj.get("nit").getAsInt();
            String correo = jobj.get("correo").getAsString();
            String genero = jobj.get("genero").getAsString();
            
            if (verificar(codigo) == false) {
                Clientes nuevo = new Clientes(codigo, nombre, nit, correo, genero.toUpperCase());
                Proy1.AgregarCliente(nuevo);
                error = false;
            }else{
                error = true;
            }            
        }
        if (error == true) {
            JOptionPane.showMessageDialog(null, "No se pudieron cargar ciertos clientes porque ya existen estos codigos de clientes");
        }
        Proy1.LeerCliente();
    }
    
    //================METODO PARA LA GRAFICA====================
    //MOSTRAR LO QUE TENGA QUE MOSTRAR EN EL PANEL DE GRAFICA
    public void pg(){
        JLabel nulo = new JLabel("No hay ningun cliente registrado");
        nulo.setBounds(180,135,200,30);
        nulo.setFont(new Font("Century Gothic", Font.PLAIN,20));
        graficac.add(nulo);
        if (Proy1.clientes[0] == null) {
            graficac.setVisible(true);
        }else{
            graficac.setVisible(false);
            mostrargrafica();
        }        
    }
    
    //MOSTRAR LA GRAFICA
    public void mostrargrafica(){
        DefaultPieDataset datosgraph = new DefaultPieDataset();
        datosgraph.setValue("Hombres", Proy1.ContadorCM());
        datosgraph.setValue("Mujeres", Proy1.ContadorCF());
        JFreeChart grafica = ChartFactory.createPieChart3D("Genero de Clientes", datosgraph);
        PiePlot3D pastel =(PiePlot3D)grafica.getPlot();
        pastel.setForegroundAlpha(0.40f);
        pastel.setInteriorGap(0.05);
        pastel.setBackgroundPaint(azulito);        
        ChartPanel panelgraph = new ChartPanel(grafica);
        panelgraph.setBounds(900,220,350,300);
        this.add(panelgraph);
    }
    
    //ACCION DE LOS BOTONES
    @Override
    public void actionPerformed(ActionEvent ae) {
        //BOTON DE CARGA MASIVA
        if (ae.getSource()==cargarc){
            leerArchivoC();
        }
        //BOTON CREAR CLIENTE
        else if (ae.getSource()==crearc) {
            Formcc fcc = new Formcc();
        }
        //BOTON ACTUALIZAR CLIENTE
        else if (ae.getSource()==actualizarc) {
            Formac fac = new Formac();
        }
        //BOTON ELIMINAR CLIENTE
        else if (ae.getSource()==eliminarc) {
            Formec fec = new Formec();
        }
        //BOTON EXPORTAR LISTA DE CLIENTES EN PDF
        else if (ae.getSource()==exportarc) {
            ListadoClientes lc = new ListadoClientes();
            lc.CrearPDFC();
        }
    }
    
    //VERIFICA SI YA EXISTE EL OBJETO
    public boolean verificar(int cods) {
        for (int i = 0; i<Proy1.clientes.length; i++) {
            if (Proy1.clientes[i]!=null && Proy1.clientes[i].getCodigo()==cods) {
                return true;
            }
        }
        return false;
    }
}
