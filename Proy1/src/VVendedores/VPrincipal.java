package VVendedores;

//==================LIBRERIAS===============
//AWT-SWING
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class VPrincipal extends JFrame implements ActionListener{
    JButton cerrars;
    JPanel Panel;
    JLabel bienvenida;
    Color azul = new Color(38,36,89);
    Color celeste = new Color(119,194,249);
    Color azulito = new Color(33,86,159);
    Color rojo = new Color(236,17,17);
    public VPrincipal(){
        
        //PANEL1
        Panel = new JPanel();
        Panel.setBorder(new EmptyBorder(5,25,5,5));
        setContentPane(Panel);
        Panel.setLayout(null);
        
        //PESTAÑAS
        JTabbedPane pp = new JTabbedPane(JTabbedPane.TOP);
        pp.setBounds(20,21,1280,640);
        pp.setBackground(azulito);
        pp.setForeground(Color.WHITE);
        pp.setFont(new Font("Arial", Font.PLAIN,15));
        Panel.add(pp);
        
        //PANEL DE NUEVA VENTA
        VNuevaV vnv = new VNuevaV();
        pp.addTab("Nueva Venta", null, vnv,null);
        
        //PANEL DE VENTAS
        VVentas v = new VVentas();
        pp.addTab("Ventas", null, v,null);
        
        //BOTON DE CERRAR SESIÓN
        cerrars = new JButton("Cerrar Sesión");
        cerrars.setFont(new Font("Arial", Font.PLAIN,15));
        cerrars.setBounds(1150,0,150,30);
        cerrars.addActionListener(this);
        cerrars.setVisible(true);        
        cerrars.setBackground(rojo);
        cerrars.setForeground(Color.WHITE);
        this.add(cerrars);
        
        bienvenida = new JLabel("¡Bienvenido ");
        bienvenida.setFont(new Font("Arial", Font.BOLD,15));
        bienvenida.setBounds(850,5,150,30);
        bienvenida.setVisible(true);
        bienvenida.setForeground(Color.BLACK);
        this.add(bienvenida);
        
        //ICONO DE LA APLICACION
        setIconImage(new ImageIcon(getClass().getResource("Logo.png")).getImage());
        
        //DISEÑO DE LA VENTANA
        this.setTitle("Vendedores | Blue Mall - POS");
        this.setBounds(20,20,1320,700);
        this.getContentPane().setBackground(celeste);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }    
}
