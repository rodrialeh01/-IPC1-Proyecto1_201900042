package Admin;
import java.awt.*;
import javax.swing.*;
public class AVendedores extends JPanel{
    JButton crearv, cargarv, actualizarv, eliminarv, exportarv;
    JPanel graficav;
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
        
        JLabel lbl1 = new JLabel("Pestaña Vendedores");
        lbl1.setBounds(10,11,348,14);
        this.add(lbl1);
        this.setBackground(gris);
        this.setLayout(null);
    }
}
