package Admin;
import Login.Login;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class Admin extends JFrame implements ActionListener{
    private JPanel Panel;
    JButton cierre;
    public Admin(){
        
        Color azul = new Color(38,36,89);
        
        //PANEL1
        Panel = new JPanel();
        Panel.setBorder(new EmptyBorder(5,25,5,5));
        setContentPane(Panel);
        Panel.setLayout(null);
        
        //PESTAÑAS
        JTabbedPane pp = new JTabbedPane(JTabbedPane.TOP);
        pp.setBounds(10,11,1290,650);
        Panel.add(pp);
        
        //PANEL DE SUCURSALES
        ASucursales as = new ASucursales();
        pp.addTab("Sucursales", null, as,null);
        
        //PANEL DE PRODUCTOS
        AProductos ap = new AProductos();
        pp.addTab("Productos", null, ap, null);
        
        //PANEL DE CLIENTES
        AClientes ac = new AClientes();
        pp.addTab("Clientes", null, ac, null);
        
        //PANEL DE VENDEDORES
        AVendedores av = new AVendedores();
        pp.addTab("Vendedores", null, av, null);
        
        //ICONO DE LA APLICACION
        setIconImage(new ImageIcon(getClass().getResource("Logo.png")).getImage());
        
        //BOTON DE CERRAR SESIÓN
        cierre = new JButton("Cerrar Sesión");
        cierre.setFont(new Font("Arial", Font.PLAIN,10));
        cierre.setBounds(1150,0,150,30);
        cierre.addActionListener(this);
        cierre.setVisible(true);        
        cierre.setBackground(Color.RED);
        cierre.setForeground(Color.WHITE);
        this.add(cierre);
        
        //DISEÑO DE LA VENTANA
        this.setTitle("Administrador | Blue Mall - POS");
        this.setBounds(20,20,1320,700);
        this.getContentPane().setBackground(azul);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==cierre){
            this.dispose();
            Login l = new Login();
        }
    }
}
