package Login;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Login extends JFrame implements ActionListener{
    JLabel title, us, pas, img;
    static JTextField usuarios;
    static JPasswordField contraseñas;
    JRadioButton admin, vendedor;
    String usu, contra;
    JButton inicio;
    public Login(){
        
        Color azul = new Color(38,36,89);
        
        //LABEL DE TITULO
        title = new JLabel("LOGIN");
        title.setFont(new Font("Arial Black", Font.PLAIN, 50));
        title.setForeground(azul);
        title.setBounds(260,10,200,90);
        title.setVisible(true);
        this.add(title);
        
        //ICONO DE LA APLICACION
        setIconImage(new ImageIcon(getClass().getResource("Logo.png")).getImage());
        
        //IMAGEN IMPLEMENTADA EN EL PROGRAMA
        Image imag = new ImageIcon("Logo.PNG").getImage();
        ImageIcon imge = new ImageIcon(imag.getScaledInstance(65, 65, Image.SCALE_SMOOTH));
        img = new JLabel(imge);
        img.setLayout(null);
        img.setBounds(100,10, 200, 90);
        img.setVisible(true);
        this.add(img);
        
        //LABEL DE USUARIO
        us = new JLabel("Usuario: ");
        us.setFont(new Font("Arial", Font.PLAIN, 15));
        us.setForeground(Color.BLACK);
        us.setBounds(50,130,100,30);
        us.setVisible(true);
        this.add(us);
        
        //TEXTFIELD DE USUARIOS
        usuarios = new JTextField();
        usuarios.setFont(new Font("Segoe UI Semibold",Font.PLAIN,15));
        usuarios.setBounds(160,130,350,25);
        usuarios.setVisible(true);
        usuarios.addActionListener(this);
        this.add(usuarios);
        
        //LABEL DE CONTRASEÑA
        pas = new JLabel("Contraseña: ");
        pas.setFont(new Font("Arial", Font.PLAIN, 15));
        pas.setForeground(Color.BLACK);
        pas.setBounds(50,200,100,30);
        pas.setVisible(true);
        this.add(pas);
        
        //TEXTFIELD DE CONTRASEÑAS
        contraseñas = new JPasswordField();
        contraseñas.setFont(new Font("Segoe UI Semibold",Font.PLAIN,15));
        contraseñas.setBounds(160,200,350,25);
        contraseñas.setVisible(true);
        contraseñas.addActionListener(this);
        this.add(contraseñas);
        
        //RADIOBUTTON DE ADMIN
        admin = new JRadioButton("Administrador");
        admin.setFont(new Font("Arial",Font.PLAIN,15));
        admin.setBounds(160,270,150,30);
        admin.setVisible(true);
        admin.setForeground(Color.BLACK);
        admin.setBackground(Color.GRAY);
        admin.addActionListener(this);
        this.add(admin);
        
        //RADIOBUTTON DE VENDEDOR
        vendedor = new JRadioButton("Vendedor");
        vendedor.setFont(new Font("Arial",Font.PLAIN,15));
        vendedor.setBounds(330,270,150,30);
        vendedor.setVisible(true);
        vendedor.setForeground(Color.BLACK);
        vendedor.setBackground(Color.GRAY);
        vendedor.addActionListener(this);
        this.add(vendedor);
        
        //BOTON DE INICIO DE SESIÓN
        inicio = new JButton("Iniciar Sesión");
        inicio.setFont(new Font("Arial", Font.PLAIN,15));
        inicio.setBounds(240,330,150,30);
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
        
    }
    
}
