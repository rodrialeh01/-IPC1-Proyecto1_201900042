package Admin;
import Clases.Vendedores;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.*;
import proy1.Proy1;
public class AVendedores extends JPanel implements ActionListener{
    JButton crearv, cargarv, actualizarv, eliminarv, exportarv;
    JPanel graficav;
    static JTable tablav;
    static Object[][] datos;
    public AVendedores(){
        //COLORES
        Color gris = new Color(204,201,201);
        Color azulito = new Color(112,114,231);
        
        //BOTON CREAR
        crearv = new JButton("Crear");
        crearv.setBounds(900, 10, 150, 50);
        crearv.setFont(new Font("Arial", Font.PLAIN,15));
        crearv.setBackground(azulito);
        crearv.setVisible(true);
        this.add(crearv);
        
        //BOTON MODIFICAR
        cargarv = new JButton("Carga Masiva");
        cargarv.setBounds(1100, 10, 150, 50);
        cargarv.setFont(new Font("Arial", Font.PLAIN,15));
        cargarv.setBackground(azulito);
        cargarv.addActionListener(this);
        cargarv.setVisible(true);
        this.add(cargarv);
        
        //BOTON ACTUALIZAR
        actualizarv = new JButton("Actualizar");
        actualizarv.setBounds(900, 70, 150, 50);
        actualizarv.setFont(new Font("Arial", Font.PLAIN,15));
        actualizarv.setBackground(azulito);
        actualizarv.setVisible(true);
        this.add(actualizarv);
        
        //BOTON ELIMINAR
        eliminarv = new JButton("Eliminar");
        eliminarv.setBounds(1100, 70, 150, 50);
        eliminarv.setFont(new Font("Arial", Font.PLAIN,15));
        eliminarv.setBackground(azulito);
        eliminarv.setVisible(true);
        this.add(eliminarv);
        
        //BOTON EXPORTAR
        exportarv = new JButton("Exportar Listado PDF");
        exportarv.setBounds(900, 130, 350, 50);
        exportarv.setFont(new Font("Arial", Font.PLAIN,15));
        exportarv.setBackground(azulito);
        exportarv.setVisible(true);
        this.add(exportarv);
        
        //PANEL DE GRAFICA
        graficav = new JPanel();
        graficav.setLayout(new BorderLayout());
	graficav.setBounds(900,220,350,300);
        graficav.setBackground(azulito);
        this.add(graficav);
        
        //TABLA
        String [] encabezado = {"Código","Nombre","Caja","Ventas","Género"};
//        Object [][] fila1 = {{"1","rodri","100","23","m"}};
        datos = Proy1.convertirDVendedores();
        tablav = new JTable(datos,encabezado);
        JScrollPane sp= new JScrollPane(tablav);
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
        System.out.println("Tiene : " + ja.size() + " objetos");
        
        for (int i = 0; i < ja.size(); i++) {
            JsonObject jobj = ja.get(i).getAsJsonObject();
            
            int codigo = jobj.get("codigo").getAsInt();
            String nombre = jobj.get("nombre").getAsString();
            int caja = jobj.get("caja").getAsInt();
            int ventas = jobj.get("ventas").getAsInt();
            String genero = jobj.get("genero").getAsString();
            
            Vendedores nuevo = new Vendedores(codigo,nombre,caja,ventas,genero);
            Proy1.AgregarVendedor(nuevo);
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
    }
}
