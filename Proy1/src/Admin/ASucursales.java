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
//LECTURA DE ARCHIVOS
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

//==================PAQUETES===============
import Clases.Sucursales;
import proy1.Proy1;
import Listados.ListadoSucursales;
import java.io.IOException;
import javax.swing.table.DefaultTableCellRenderer;

public class ASucursales extends JPanel implements ActionListener{
    JButton crears, cargars, actualizars, eliminars, exportars, actualizarps;
    static JTable tablas;
    JPanel esptab;
    static Object[][] datos;
    public ASucursales(){
        //COLORES
        Color gris = new Color(204,201,201);
        Color azulito = new Color(112,114,231);
        Color azul = new Color(38,36,89);
        
        //BOTON CREAR
        crears = new JButton("Crear");
        crears.setBounds(900, 10, 150, 50);
        crears.setFont(new Font("Century Gothic", Font.PLAIN,15));
        crears.setBackground(azulito);
        crears.setVisible(true);
        crears.addActionListener(this);
        this.add(crears);
        
        //BOTON CARGA MASIVA
        cargars = new JButton("Carga Masiva");
        cargars.setBounds(1100, 10, 150, 50);
        cargars.setFont(new Font("Century Gothic", Font.PLAIN,15));
        cargars.setBackground(azulito);
        cargars.setVisible(true);
        cargars.addActionListener(this);
        this.add(cargars);
        
        //BOTON ACTUALIZAR
        actualizars = new JButton("Actualizar");
        actualizars.setBounds(900, 70, 150, 50);
        actualizars.setFont(new Font("Arial", Font.PLAIN,15));
        actualizars.setBackground(azulito);
        actualizars.addActionListener(this);
        actualizars.setVisible(true);
        this.add(actualizars);
        
        //BOTON ELIMINAR
        eliminars = new JButton("Eliminar");
        eliminars.setBounds(1100, 70, 150, 50);
        eliminars.setFont(new Font("Century Gothic", Font.PLAIN,15));
        eliminars.setBackground(azulito);
        eliminars.setVisible(true);
        eliminars.addActionListener(this);
        this.add(eliminars);
        
        //BOTON EXPORTAR
        exportars = new JButton("Exportar Listado PDF");
        exportars.setBounds(900, 130, 350, 50);
        exportars.setFont(new Font("Century Gothic", Font.PLAIN,15));
        exportars.setBackground(azulito);
        exportars.setVisible(true);
        exportars.addActionListener(this);
        this.add(exportars);
        
        String [] encabezado = {"Código","Nombre","Dirreción","Correo","Teléfono"};
        datos = Proy1.convertirDSucursales();
        tablas = new JTable(datos, encabezado);  
        JScrollPane sp = new JScrollPane(tablas);
        sp.setBounds(20, 10, 800, 600);
        //CENTRAR LOS DATOS DE LA TABLA
        DefaultTableCellRenderer renderc = new DefaultTableCellRenderer();
        renderc.setHorizontalAlignment(SwingConstants.CENTER);
        tablas.getColumnModel().getColumn(0).setCellRenderer(renderc);
        tablas.getColumnModel().getColumn(1).setCellRenderer(renderc);
        tablas.getColumnModel().getColumn(2).setCellRenderer(renderc);
        tablas.getColumnModel().getColumn(3).setCellRenderer(renderc);
        tablas.getColumnModel().getColumn(4).setCellRenderer(renderc);
        tablas.getTableHeader().setFont(new Font("Century Gothic", Font.PLAIN,15));
        tablas.getTableHeader().setBackground(azul);
        tablas.getTableHeader().setForeground(Color.WHITE);
        tablas.setEnabled(false);
        tablas.setFont(new Font("Century Gothic", Font.PLAIN,12));
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
            //LLAMA AL METODO CONVERTIR JSON
            convertirjson(contenido);
        } catch (Exception e) {
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
    public void convertirjson(String c) {
        JsonParser parser = new JsonParser();
        JsonArray ja = parser.parse(c).getAsJsonArray();
        boolean error = false;
            for (int i = 0; i < ja.size(); i++) {
            JsonObject jobj = ja.get(i).getAsJsonObject();

            int codigo = jobj.get("codigo").getAsInt();
            String nombre = jobj.get("nombre").getAsString();
            String direccion = jobj.get("direccion").getAsString();
            String correo = jobj.get("correo").getAsString();
            int telefono = jobj.get("telefono").getAsInt();

            if (verificar(codigo) == false) {
                Sucursales nuevo = new Sucursales(codigo, nombre, direccion, correo, telefono);
                Proy1.AgregarSucursales(nuevo);
                error = false;

            } else {
                error = true;
            }
        }

        if (error == true) {
            JOptionPane.showMessageDialog(null, "No se pudieron cargar ciertas sucursales porque ya existen estos codigos de sucursales");
        }
        Proy1.LeerSucursales();
    }
    
    //ACCIONES DE LOS BOTONES
    @Override
    public void actionPerformed(ActionEvent ae) {
        //BOTON DE CARGA MASIVA
        if (ae.getSource()==cargars){
            leerArchivoS();
        }
        //BOTON CREAR SUCURSAL
        else if (ae.getSource()==crears) {
            Formcs fcs = new Formcs();
        }
        //BOTON ACTUALIZAR SUCURSAL
        else if (ae.getSource()==actualizars) {
            Formas fas = new Formas();
        }
        //BOTON ELIMINAR SUCURSAL
        else if (ae.getSource()==eliminars) {
            Formes fes = new Formes();
        }
        //BOTON EXPORTAR LISTA DE SUCURSALES EN PDF
        else if (ae.getSource()==exportars) {
            ListadoSucursales ls = new ListadoSucursales();
            ls.CrearPDFS();
        }
    }
    //VERIFICA SI YA EXISTE EL OBJETO
    public boolean verificar(int cod) {
        for (int i = 0; i<Proy1.sucursales.length; i++) {
            if (Proy1.sucursales[i]!=null && Proy1.sucursales[i].getCodigo()==cod) {
                return true;
            }
        }
        return false;
    }
}
