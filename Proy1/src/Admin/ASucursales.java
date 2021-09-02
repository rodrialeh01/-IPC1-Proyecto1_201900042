package Admin;
import java.awt.*;
import javax.swing.*;
public class ASucursales extends JPanel{
    JButton crears, cargars, actualizars, eliminars, exportars;
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
        
        //BOTON MODIFICAR
        cargars = new JButton("Carga Masiva");
        cargars.setBounds(1100, 10, 150, 50);
        cargars.setFont(new Font("Arial", Font.PLAIN,15));
        cargars.setBackground(azulito);
        cargars.setVisible(true);
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
        
        JLabel lbl1 = new JLabel("Pestaña Sucursales");
        lbl1.setBounds(10,11,348,14);
        this.add(lbl1);
        this.setLayout(null);
        this.setBackground(gris);
    }
}
