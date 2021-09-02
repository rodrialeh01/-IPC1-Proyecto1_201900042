package Admin;

import javax.swing.*;
import java.awt.*;
public class AProductos extends JPanel{
    JButton crearp, cargarp, actualizarp, eliminarp, exportarp;
    JPanel graficap;
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
        this.add(crearp);
        
        //BOTON MODIFICAR
        cargarp = new JButton("Carga Masiva");
        cargarp.setBounds(1100, 10, 150, 50);
        cargarp.setFont(new Font("Arial", Font.PLAIN,15));
        cargarp.setBackground(azulito);
        cargarp.setVisible(true);
        this.add(cargarp);
        
        //BOTON ACTUALIZAR
        actualizarp = new JButton("Actualizar");
        actualizarp.setBounds(900, 70, 150, 50);
        actualizarp.setFont(new Font("Arial", Font.PLAIN,15));
        actualizarp.setBackground(azulito);
        actualizarp.setVisible(true);
        this.add(actualizarp);
        
        //BOTON ELIMINAR
        eliminarp = new JButton("Eliminar");
        eliminarp.setBounds(1100, 70, 150, 50);
        eliminarp.setFont(new Font("Arial", Font.PLAIN,15));
        eliminarp.setBackground(azulito);
        eliminarp.setVisible(true);
        this.add(eliminarp);
        
        //BOTON EXPORTAR
        exportarp = new JButton("Exportar Listado PDF");
        exportarp.setBounds(900, 130, 350, 50);
        exportarp.setFont(new Font("Arial", Font.PLAIN,15));
        exportarp.setBackground(azulito);
        exportarp.setVisible(true);
        this.add(exportarp);
        
        graficap = new JPanel();
        graficap.setLayout(new BorderLayout());
	graficap.setBounds(900,220,350,300);
        graficap.setBackground(azulito);
        this.add(graficap);
        
        JLabel lbl1 = new JLabel("Pestaña Productos");
        lbl1.setBounds(10,11,348,14);
        this.add(lbl1);
        this.setBackground(gris);
        this.setLayout(null);
    }
    
}
