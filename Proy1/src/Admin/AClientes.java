package Admin;
import javax.swing.*;
import java.awt.*;
public class AClientes extends JPanel{
    JButton crearc, cargarc, actualizarc, eliminarc, exportarc;
    JPanel graficac;
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
        
        graficac = new JPanel();
        graficac.setLayout(new BorderLayout());
	graficac.setBounds(900,220,350,300);
        graficac.setBackground(azulito);
        this.add(graficac);
        
        JLabel lbl1 = new JLabel("Pestaña Clientes");
        lbl1.setBounds(10,11,348,14);
        this.add(lbl1);
        this.setLayout(null);
        this.setBackground(gris);
    }
}
