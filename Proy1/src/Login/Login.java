package Login;
//=============LIBRERIAS==============
//AWT-SWING
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//==================PAQUETES===============
import Admin.Admin;
import VVendedores.VPrincipal;
import proy1.Proy1;

public class Login extends JFrame implements ActionListener{
    JLabel title, us, pas, img;
    static JTextField usuarios;
    static JPasswordField contraseñas;
    JRadioButton admin, vendedor;
    static String usu, contra;
    public static String usuv, genv;
    JButton inicio;
    public Login(){
        
        Color azul = new Color(38,36,89);
        
        //LABEL DE TITULO
        title = new JLabel("LOGIN - POS");
        title.setFont(new Font("Century Gothic", Font.BOLD, 50));
        title.setForeground(azul);
        title.setBounds(200,10,400,90);
        title.setVisible(true);
        this.add(title);
        
        //ICONO DE LA APLICACION
        setIconImage(new ImageIcon(getClass().getResource("Logo.png")).getImage());
        
        //IMAGEN IMPLEMENTADA EN EL PROGRAMA
        Image imag = new ImageIcon("Imagenes/Logo.png").getImage();
        ImageIcon imge = new ImageIcon(imag.getScaledInstance(65, 65, Image.SCALE_SMOOTH));
        img = new JLabel(imge);
        img.setLayout(null);
        img.setBounds(50,10, 200, 90);
        img.setVisible(true);
        this.add(img);
        
        //LABEL DE USUARIO
        us = new JLabel("Usuario: ");
        us.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        us.setForeground(Color.BLACK);
        us.setBounds(50,130,100,30);
        us.setVisible(true);
        this.add(us);
        
        //TEXTFIELD DE USUARIOS
        usuarios = new JTextField();
        usuarios.setFont(new Font("Century Gothic",Font.PLAIN,15));
        usuarios.setBounds(160,130,350,25);
        usuarios.setVisible(true);
        usuarios.addActionListener(this);
        this.add(usuarios);
        
        //LABEL DE CONTRASEÑA
        pas = new JLabel("Contraseña: ");
        pas.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        pas.setForeground(Color.BLACK);
        pas.setBounds(50,200,100,30);
        pas.setVisible(true);
        this.add(pas);
        
        //TEXTFIELD DE CONTRASEÑAS
        contraseñas = new JPasswordField();
        contraseñas.setFont(new Font("Century Gothic",Font.PLAIN,15));
        contraseñas.setBounds(160,200,350,25);
        contraseñas.setVisible(true);
        contraseñas.addActionListener(this);
        this.add(contraseñas);
        
        //BOTON DE INICIO DE SESIÓN
        inicio = new JButton("Iniciar Sesión");
        inicio.setFont(new Font("Century Gothic", Font.PLAIN,15));
        inicio.setBounds(240,280,150,30);
        inicio.setVisible(true);
        inicio.addActionListener(this);
        this.add(inicio);
        
        //DISEÑO DE LA VENTANA
        this.setTitle("Login | Blue Mall - POS");
        this.setBounds(400,200,600,400);
        this.getContentPane().setBackground(Color.GRAY);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == inicio) {
                usu = usuarios.getText();
                contra = contraseñas.getText();
                //VERIFICA LA ENTRADA DEL ADMINISTRADOR
                if (usu.equals("admin") && contra.equals("admin")) {
                    System.out.println("HOLA ADMIN");
                    JOptionPane.showMessageDialog(this, "Bienvenido Administrador");
                    Admin a = new Admin();
                    this.dispose();
                } //VERIFICA LA ENTRADA DEL VENDEDOR
                else if (Proy1.verificar(Integer.parseInt(usu)) == true && contra.equals("1234")) {
                    usuv = Proy1.nombrev(Integer.parseInt(usu));
                    if (usuv != null) {
                        genv = Proy1.generov(Integer.parseInt(usu));
                        if (genv.equals("M")) {
                            System.out.println("Bienvenido " + usuv);
                            JOptionPane.showMessageDialog(this, "Bienvenido " + usuv);
                            VPrincipal vp = new VPrincipal();
                            this.dispose();
                        } else if (genv.equals("F")) {
                            System.out.println("Bienvenida " + usuv);
                            JOptionPane.showMessageDialog(this, "Bienvenida " + usuv);
                            VPrincipal vp = new VPrincipal();
                            this.dispose();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Ingrese correctamente las credenciales.");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ingrese correctamente las credenciales.");
        }
    }
    
}
