package Login;
import Admin.Admin;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import proy1.Proy1;
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
        Image imag = new ImageIcon("Imagenes/Logo.png").getImage();
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
        
        //BOTON DE INICIO DE SESIÓN
        inicio = new JButton("Iniciar Sesión");
        inicio.setFont(new Font("Arial", Font.PLAIN,15));
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
    }boolean logueado = false;
//            for (int i = 0; i < Proy1.vendedores.length; i++) {
//                if (usu.equals(String.valueOf((Proy1.vendedores[i].getCodigo()))) && contra.equals("1234")) {
//                    logueado = true;
//                    System.out.println("Entró el usuario " + Proy1.vendedores[i].getCodigo());
//                }
//            }
//            if (logueado == true) {
//                JOptionPane.showMessageDialog(this, "Logueado");
//            }else{
//                JOptionPane.showMessageDialog(this, "Ingrese correctamente las credenciales.");
//            }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==inicio){
            usu = usuarios.getText();
            contra = contraseñas.getText();
            if (usu.equals("admin") && contra.equals("admin")) {
                System.out.println("HOLA ADMIN");
                Admin a = new Admin();
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(this, "Ingrese correctamente las credenciales.");
            }
//            
        }
    }
    
}
